package com.example.controller;

import com.example.dao.UserDAO;
import com.example.exception.AuthenticationException;
import com.example.model.*;
import com.example.util.General;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Avenash_2 on 5/21/2018.
 */
@WebServlet({"/UpdateEducation"})
public class UpdateEducation extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String schoolName=req.getParameter("school");
        String from= General.convertDateInSpecificFormat(req.getParameter("from"));
        String to=General.convertDateInSpecificFormat(req.getParameter("to"));
        String degree=req.getParameter("degree");

        if(req.getParameter("current")!=null)
            to="current";

        String email=req.getParameter("email");
        String password=req.getParameter("password");

        User user=new User(email, password);

        UserDAO userDAO=new UserDAO();

        try
        {
            user=userDAO.authenticateUser(user);

            //School
            School school=new School();
            school.setName(schoolName);

            //Education
            Education education=new Education();
            education.setSchool(school);
            education.setFrom(from);
            education.setTo(to);
            education.setDegree(degree);

            //Add education
            user.addEducation(education);
            userDAO.updateUser(user);
        }
        catch (AuthenticationException e)
        {
            e.printStackTrace();
        }
    }
}
