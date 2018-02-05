package ru.otus.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

//@WebFilter(filterName = "SampleFilter", urlPatterns = "/*", asyncSupported = true)
public class SampleFilter extends HttpFilter {
//    public void destroy() {
//    }

    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        List<Object> producs = (List<Object>) req.getSession(true).getAttribute("items");
        chain.doFilter(new HttpServletRequestWrapper(req){
            @Override
            public String getParameter(String param){
                String result = super.getParameter(param);
                if (result != null) {
                    result += "Test";
                }
                return result;
            }
        }, new HttpServletResponseWrapper(res));
    }

//    public void init(FilterConfig config) throws ServletException {
//
//    }

}
