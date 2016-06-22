package com.univer.slownews.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("getRemoteAddr: " + servletRequest.getRemoteAddr());
        System.out.println("getRemoteHost: " + servletRequest.getRemoteHost());
        System.out.println("getLocalAddr: " + servletRequest.getLocalAddr());
        System.out.println("getLocalAddr: " + servletRequest.getServerPort());
        System.out.println("getRequestURI: " + ((HttpServletRequest) servletRequest).getRequestURI());
        System.out.println();
        servletRequest.setAttribute("uri", ((HttpServletRequest) servletRequest).getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}