package ru.otus.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter(filterName = "SampleFilter", urlPatterns = "/*", asyncSupported = true)
public class SampleFilter extends HttpFilter {
    public void destroy() {
    }

    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new HttpServletRequestWrapper(req), new HttpServletResponseWrapper(res));
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
