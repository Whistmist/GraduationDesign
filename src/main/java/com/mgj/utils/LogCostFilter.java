package com.mgj.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@WebFilter()
public class LogCostFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
 
    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {     
        String requestUrl = ((HttpServletRequest) servletRequest).getRequestURL().toString();//得到请求的URL地址    
        /*log.info("请求URL为--->  "+requestUrl);*/
        if(((HttpServletRequest) servletRequest).getQueryString()!=null) {
        	String queryString = ((HttpServletRequest) servletRequest).getQueryString();//得到请求的URL地址中附带的参数  
        	log.info("请求URL为--->  "+requestUrl);
        	log.info("请求参数为--->  "+queryString);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
 
    @Override
    public void destroy() {
 
    }
}
