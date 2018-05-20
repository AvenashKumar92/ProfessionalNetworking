package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Avenash_2 on 5/19/2018.
 */
@WebServlet({"/Login"})
public class Login extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/jsp/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        User user=new User(email, password);
        user=new UserDAO().authenticateUser(user);

        if(user!=null){
            resp.sendRedirect("Resume");
        }
        else{
            req.setAttribute("errMessage", "Invalid login credentials!");
            req.getRequestDispatcher("/jsp/Login.jsp").forward(req, resp);
        }
    }
}
