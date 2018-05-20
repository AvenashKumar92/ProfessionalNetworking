package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ProductDAO;
import com.example.dao.UserDAO;
import com.example.model.Product;
import com.example.model.User;
import com.example.util.DBConnection;
//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ProductController
 */
@WebServlet({"/Product"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDAO dao;
	//ObjectMapper mapper = new ObjectMapper();

	@Override
	public void init() throws ServletException {
		dao = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//UserDAO userDAO=new UserDAO();
		User user=new User();
		user.setEmail("Avenash");
		user.setfName("sadsa");
		user.setlName("asda");
		user.setPassword("123");
		DBConnection.getInstance().addData("User", user.getEmail(), user);
		UserDAO userDAO=new UserDAO();

        user.setlName("Virat");
        userDAO.updateUser(user);


		request.setAttribute("products", dao.getAllProducts());
		RequestDispatcher view = request.getRequestDispatcher("resume.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        String json=request.getParameter("User");
		/*Product product = mapper.readValue(request.getParameter("product"), Product.class);
		product.setId(dao.genId());
		dao.addProduct(product);

		PrintWriter out =response.getWriter();
		try{
			out.print(mapper.writeValueAsString(product));
		}catch (JsonGenerationException e) {
			e.printStackTrace();
		}*/

	}

}
