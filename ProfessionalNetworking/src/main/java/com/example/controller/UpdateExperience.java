package com.example.controller;

import com.example.dao.UserDAO;
import com.example.exception.AuthenticationException;
import com.example.model.Company;
import com.example.model.JobExperience;
import com.example.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Avenash_2 on 5/21/2018.
 */
@WebServlet({"/UpdateExperience"})
public class UpdateExperience extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String employerName=req.getParameter("employer");
        String from=req.getParameter("from");
        String to=req.getParameter("to");
        String description=req.getParameter("description");

        if(req.getParameter("current")!=null)
            to="current";

        String email=req.getParameter("email");
        String password=req.getParameter("password");

        User user=new User(email, password);

        UserDAO userDAO=new UserDAO();

        try
        {
            user=userDAO.authenticateUser(user);

            //Company
            Company company=new Company();
            company.setName(employerName);

            //Job experience
            JobExperience jobExperience=new JobExperience();
            jobExperience.setCompany(company);
            jobExperience.setFrom(from);
            jobExperience.setTo(to);
            jobExperience.setDescription(description);

            //Add job experience
            user.addJobExperience(jobExperience);
            userDAO.updateUser(user);
        }
        catch (AuthenticationException e)
        {
            e.printStackTrace();
        }
    }
}
