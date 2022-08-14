package com.example.simpletest.controller;

import com.example.simpletest.model.User;
import com.example.simpletest.service.UserService;
import com.example.simpletest.service.impl.UserServiceImpl;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "auth",value = "/auth")
public class Auth extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action=req.getParameter("action");
    if (action!=null){
        if (action.equalsIgnoreCase("login")){
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);

        }else if (action.equalsIgnoreCase("register")){
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req,resp);

        }else if (action.equalsIgnoreCase("logout")) {
            HttpSession session=req.getSession(false);
            session.removeAttribute("user");
            resp.sendRedirect(req.getContextPath()+"/auth?action=login");

        } else{
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req,resp);
        }
    }else {
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req,resp);
    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action!=null){
            if (action.equalsIgnoreCase("login")){
                String username=req.getParameter("username");
                String password=req.getParameter("password");
                UserService userService=new UserServiceImpl();
                User user= userService.login(username,password);
                if(user==null){
                    String error="Username or password is incorrect";
                    req.setAttribute("error",error);
                    req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
                }else {
                    HttpSession session= req.getSession(true);
                    session.setAttribute("user",user);
                    resp.sendRedirect("user");
                }

            } else if (action.equalsIgnoreCase("register")) {
                String firstName=req.getParameter("name");
                String lastName=req.getParameter("surname");
                String username=req.getParameter("username");
                String password=req.getParameter("password");
                User user=new User(null,firstName,lastName,username,password,1,null);
                UserService userService=new UserServiceImpl();
                boolean opr=userService.register(user);
                if (opr){
                    resp.sendRedirect("auth?action=login");
                }else {
                    String error="Data is not valid";
                    req.setAttribute("error",error);
                    req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req,resp);
                }
            }else if (action.equalsIgnoreCase("logout")) {
                HttpSession session=req.getSession(false);
                session.removeAttribute("user");
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);

            }
            else {
                    req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req,resp);
            }
        }else {
             req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req,resp);
        }
    }
}
