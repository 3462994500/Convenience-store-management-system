package com.gec.filter;
// 登录拦截器
//登录拦截
//        在访问主页面时要判断是不是有登录
//        有登录才可以访问
//        没有登录就跳转到登录页面
// 过滤器实现Filter接口，重写里面三个方法
// 过滤器，是可以设置要过滤的请求

import com.gec.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*.jsp")  // 拦截所有的jsp页面
public class LoginFilter implements Filter {

    // 初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // 过滤方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 当请求是login.jsp时 直接放行
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String uri = req.getRequestURI();
        System.out.println("uri:"+uri);

        if("/login.jsp".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {

            // 判断是否有登录 ，通过session里面的session_user有没有值来判断

            // 先得到session
            User user = (User) req.getSession().getAttribute("session_user");

            if(user != null){
                // 有登录
                // 放行
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                // 没有登录
                // 重定向到login.jsp
                resp.sendRedirect("login.jsp");
            }
        }


    }

    // 销毁方法
    @Override
    public void destroy() {

    }
}
