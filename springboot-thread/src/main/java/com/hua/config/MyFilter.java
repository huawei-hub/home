package com.hua.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter
public class MyFilter implements Filter {
    //用于完成 Filter 的初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //实现过滤功能。
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //服务器请求预处理

        //分割线
        chain.doFilter(request, response);

        //服务器请求后置处理
    }

    //用于 Filter 销毁前，完成某些资源的回收
    @Override
    public void destroy() {

    }
}
