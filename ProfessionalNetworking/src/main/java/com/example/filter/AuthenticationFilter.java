package com.example.filter;

import com.example.util.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Avenash_2 on 5/20/2018.
 */
@WebFilter(
        filterName = "AuthenticationFilter",
        urlPatterns = { "/Resume"},
        servletNames = { "Login" }
)
public class AuthenticationFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;

        Object objCurrUser=req.getSession().getAttribute(Constants.USER_ATTRIBUTE);

        if(objCurrUser==null){
            resp.sendRedirect("Login");
            return;
        }

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy()
    {

    }
}
