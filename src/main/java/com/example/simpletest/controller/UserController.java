package com.example.simpletest.controller;

import com.example.simpletest.dao.UserDao;
import com.example.simpletest.dao.impl.UserDaoImpl;
import com.example.simpletest.model.User;
import com.example.simpletest.service.UserService;
import com.example.simpletest.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "user" ,value = "/user")
public class UserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username=req.getParameter("username");
       if (username==null){
           resp.sendRedirect("/user");
       }else{
           UserDao userDao=new UserDaoImpl();
           List<User> list=userDao.getUserByUsername(username);
           if (list!=null) {
               req.setAttribute("list", list);
               req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
           }else {
               String error="Data is not valid";
               req.setAttribute("error",error);
               req.getRequestDispatcher("user").forward(req,resp);
           }
       }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.getUserByUsername(null);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }
}
