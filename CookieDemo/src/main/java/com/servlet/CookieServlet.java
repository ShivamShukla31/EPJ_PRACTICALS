package com.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        // Encode the value to remove invalid characters like spaces
        String encodedUsername = URLEncoder.encode(username, "UTF-8");

        Cookie userCookie = new Cookie("username", encodedUsername);
        userCookie.setMaxAge(24 * 60 * 60); // 1 day
        resp.addCookie(userCookie);

        resp.sendRedirect("welcome.jsp");
    }
}

