package com.example.controller;

import com.example.dao.UserDAO;
import com.example.exception.AuthenticationException;
import com.example.model.User;
import com.example.util.Constants;
import com.example.util.CookieManager;
import com.example.util.General;

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

        User loginUser=new User(email, password);

        try
        {
            loginUser = new UserDAO().authenticateUser(loginUser);

            //Create or Delete cookies
            boolean rememberMe= General.str2Bool(req.getParameter("remember"));
            if(rememberMe)
                CookieManager.storeUserCookies(resp, loginUser.getEmail(), loginUser.getPassword(), rememberMe);
            else
                CookieManager.clearAllCookies(req, resp);

            //Create user session
            req.getSession().setAttribute(Constants.USER_ATTRIBUTE, loginUser);

            //Redirect to Resume
            resp.sendRedirect("Resume");
        }
        catch (AuthenticationException e){
            req.setAttribute(Constants.AUTH_ERROR_ATTRIBUTE, e.getMessage());
            req.getRequestDispatcher("/jsp/Login.jsp").forward(req, resp);
        }
    }
}
