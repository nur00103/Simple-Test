package com.example.simpletest.filter;

import com.example.simpletest.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", value = {"/user","/userinfo"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        if(user==null){
            resp.sendRedirect(req.getContextPath() + "/auth?action=login");
        }else {
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}
