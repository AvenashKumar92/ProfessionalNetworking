package com.example.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.util.Constants.TIME_PERIOD_COOKIES_USER;

/**
 * Created by Avenash_2 on 5/20/2018.
 */
public class CookieManager
{
    public static void storeUserCookies(HttpServletResponse resp, String email, String pass, boolean isRemember){
        Cookie cookieEmail = new Cookie(Constants.COOKIE_EMAIL, email);
        cookieEmail.setMaxAge(TIME_PERIOD_COOKIES_USER); //in seconds
        resp.addCookie(cookieEmail);

        Cookie cookiePassword = new Cookie(Constants.COOKIE_PASS, pass);
        cookiePassword.setMaxAge(TIME_PERIOD_COOKIES_USER); //in seconds
        resp.addCookie(cookiePassword);

        Cookie cookieRememberMe = new Cookie(Constants.COOKIE_REMEMBER, isRemember?"checked":"");
        cookieRememberMe.setMaxAge(TIME_PERIOD_COOKIES_USER); //in seconds
        resp.addCookie(cookieRememberMe);
    }

    public static void clearAllCookies(HttpServletRequest req, HttpServletResponse resp){
        for(Cookie c:req.getCookies()){
            if(c.getName().equalsIgnoreCase("JSESSIONID"))
                continue;
            c.setValue("");
            c.setMaxAge(0);
            resp.addCookie(c);
        }
    }
}
