package ru.otus.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HTMLServlet", urlPatterns = "/servlet")
public class HTMLServlet extends HttpServlet /*implements SingleThreadModel */{

    public HTMLServlet(){}

    private ThreadLocal<HttpServletRequest> threadRequest;
    private ThreadLocal<HttpServletResponse> threadResponse;

//    private static ServletConfig sc = null; //not thread safe
    private ServletConfig sc = null; //not thread safe

    public void init(ServletConfig sc){
        this.sc = sc;
    }

    private void validateThreadLocalData() {
        if (threadRequest == null) {
            threadRequest = new ThreadLocal<HttpServletRequest>();
        }
        if (threadResponse == null) {
            threadResponse = new ThreadLocal<HttpServletResponse>();
        }
    }

    /**
     * Gets the <code>HttpServletRequest</code> object for the current call. It is
     * stored thread-locally so that simultaneous invocations can have different
     * request objects.
     */
    protected final HttpServletRequest getThreadLocalRequest() {
        synchronized (this) {
            validateThreadLocalData();
            return threadRequest.get();
        }
    }

    /**
     * Gets the <code>HttpServletResponse</code> object for the current call. It
     * is stored thread-locally so that simultaneous invocations can have
     * different response objects.
     */
    protected final HttpServletResponse getThreadLocalResponse() {
        synchronized (this) {
            validateThreadLocalData();
            return threadResponse.get();
        }
    }

    protected /*synchronized*/ void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Store the request & response objects in thread-local storage.
            //
            synchronized (this) {
                validateThreadLocalData();
                threadRequest.set(request);
                threadResponse.set(response);
            }

            super.service(request, response);

        } catch (Throwable e) {
            // Give a subclass a chance to either handle the exception or rethrow it
            //
            doUnexpectedFailure(e);
        } finally {
            // null the thread-locals to avoid holding request/response
            //
            threadRequest.set(null);
            threadResponse.set(null);
        }
        switch(request.getMethod()) {
            case "POST" : doPost(request, response); break;
            case "GET" : doGet(request, response); break;
        }
    }

    protected void doUnexpectedFailure(Throwable e) {
        try {
            getThreadLocalResponse().reset();
        } catch (IllegalStateException ex) {
            /*
             * If we can't reset the request, the only way to signal that something
             * has gone wrong is to throw an exception from here. It should be the
             * case that we call the user's implementation code before emitting data
             * into the response, so the only time that gets tripped is if the object
             * serialization code blows up.
             */
            throw new RuntimeException("Unable to report failure", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final PushBuilder pushBuilder = request.newPushBuilder(); // local variables are thread safe
        if (pushBuilder != null) {
            pushBuilder.path("images/hotnews.png").push();
        }
        HttpSession session = request.getSession(true);
        request.getRequestDispatcher("/page.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param1 = request.getParameter("param");
        HttpSession session = request.getSession(true);
        session.setAttribute("items", new ArrayList<>());
        session.setAttribute("sessionobject", new SessionObject());
        request.getRequestDispatcher("/WEB-INF/page.html").forward(request, response);
        request.getServletContext().setAttribute("", "");

        response.sendRedirect("");
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {

    }
}
