package com.example.controller;

import com.example.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Avenash_2 on 5/22/2018.
 */
@WebServlet({"/Logout"})
public class Logout extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //Remove session from server side
        req.getSession().removeAttribute(Constants.USER_ATTRIBUTE);

        //Redirect to login page
        resp.sendRedirect("Login");
    }
}
