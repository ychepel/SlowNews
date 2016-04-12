package com.univer.slownews.servlet;

import com.univer.slownews.service.WeatherProvider;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext context = servletRequest.getServletContext();
        if(weatherNeedUpdate(context.getAttribute("weatherUpdateTime"))) {
            context.setAttribute("weather", new WeatherProvider().getWeather());
            context.setAttribute("weatherUpdateTime", System.currentTimeMillis());
        }

        servletRequest.setAttribute("uri", ((HttpServletRequest)servletRequest).getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private boolean weatherNeedUpdate(Object lastTime) {
        if(lastTime == null) {
            return true;
        }
        if(System.currentTimeMillis() - (Long)lastTime > 10*60*1000) {
            return true;
        }
        return false;
    }
}
