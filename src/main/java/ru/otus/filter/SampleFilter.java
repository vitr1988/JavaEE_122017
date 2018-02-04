package ru.otus.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

@WebFilter(filterName = "SampleFilter", urlPatterns = "/*", asyncSupported = true)
public class SampleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) req), new HttpServletResponseWrapper((HttpServletResponse) res));
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
