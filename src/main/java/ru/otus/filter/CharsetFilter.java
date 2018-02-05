package ru.otus.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

//@WebFilter(filterName = "CharsetFilter", urlPatterns = "/*")
@WebFilter(filterName = "CharsetFilter", servletNames = "HTMLServlet")
public class CharsetFilter implements Filter {
    private FilterConfig fc;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /* preprocessing */
        req.setAttribute("subject", ((HttpServletRequest) req).getHeader("X-User"));
        if (new Random().nextBoolean()) {
            chain.doFilter(req, resp);
        }
        else {
            ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        /* postprocessing */
        System.out.println("Post processing has happened");
    }

    public void init(FilterConfig config) throws ServletException {
        this.fc = config;
    }

}
