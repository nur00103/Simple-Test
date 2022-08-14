package com.example.simpletest.controller;

import com.example.simpletest.dao.UserDao;
import com.example.simpletest.dao.impl.UserDaoImpl;
import com.example.simpletest.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;

@WebServlet(name = "userinfo",value = "/userinfo")
public class UserInfoController  extends HttpServlet {
  private UserDao userDao=new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        int id=Integer.valueOf(req.getParameter("id"));

        if (action.equalsIgnoreCase("delete")){
          userDao.deleteUser(id);

        }else if (action.equalsIgnoreCase("update")){
            String upName=req.getParameter("upName");
            String upSurname=req.getParameter("upSurname");
            String upUsername=req.getParameter("upUsername");
            String upPassword=req.getParameter("upPassword");
            User user=userDao.getUserById(id);
            user.setFirstName(upName);
            user.setLastName(upSurname);
            user.setUsername(upUsername);
            user.setPassword(upPassword);
            userDao.updateUser(user);

        }
        resp.sendRedirect("user");
    }
}
