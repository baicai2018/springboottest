package com.nondo.maven.filter;

import javax.servlet.*;
import java.io.IOException;

public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-------------初始化过滤器---------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long star = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter耗时"+(System.currentTimeMillis()-star));
    }

    @Override
    public void destroy() {
        System.out.println("--------销毁过滤器--------------");
    }
}
