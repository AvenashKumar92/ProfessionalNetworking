package com.example.controller;

import com.example.dao.UserDAO;
import com.example.exception.AuthenticationException;
import com.example.model.Address;
import com.example.model.Contact;
import com.example.model.User;
import com.example.util.Constants;
import com.example.util.CookieManager;
import org.apache.tomcat.util.http.fileupload.*;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * Created by Avenash_2 on 5/19/2018.
 */
@WebServlet({"/Registration"})
@MultipartConfig
public class Registration extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("/jsp/Registration.jsp").forward(req, resp);
    }

    private String uploadImage(HttpServletRequest request)
    {
        try
        {
            Part filePart = request.getPart("imgURL"); // Retrieves <input type="file" name="file">
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();

            String imageDir = "C:\\Users\\Avenash_2\\Documents\\Personal\\Study\\Academic\\MSCS2\\WAP\\Project3\\ProfessionalNetworking\\src\\main\\webapp\\img\\Resume";
            String imageName = imageDir + "\\" + fileName;
            File uploadFile = new File(imageName);

            java.nio.file.Files.copy(fileContent, uploadFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            IOUtils.closeQuietly(fileContent);

            return fileName;
        }
        catch (IOException | ServletException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //Since we are uploading image file
        PrintWriter out = resp.getWriter();
        if (!ServletFileUpload.isMultipartContent(req))
        {
            out.println("Nothing to upload");
            return;
        }

        String profileImgName = uploadImage(req);

        Address address = new Address();
        address.setCity(req.getParameter("city"));
        address.setState(req.getParameter("state"));
        address.setCountry(req.getParameter("country"));

        Contact contact = new Contact();
        contact.setAddress(address);
        contact.setContactNo(req.getParameter("contactNo"));

        User user = new User(req.getParameter("email"), req.getParameter("password"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setProfession(req.getParameter("profession"));
        user.setProfileImgName(profileImgName);
        user.setContact(contact);


        UserDAO userDAO = new UserDAO();
        boolean isUserExist=userDAO.isUserAlreadyExist(user);

        if (isUserExist)
        {
            //Set request attribute
            req.setAttribute(Constants.USER_ATTRIBUTE, user);
            req.setAttribute(Constants.USER_ALREADYEXIST_ATTRIBUTE, "Provided email is already associated with existing user!");
            doGet(req, resp);
            return;
        }

        //Clear all cookies of old user
        CookieManager.clearAllCookies(req, resp);

        //Create user session
        req.getSession().setAttribute(Constants.USER_ATTRIBUTE, user);

        //Add user in database
        userDAO.addUser(user);

        //Open user resume
        resp.sendRedirect("Resume");

    }
}
