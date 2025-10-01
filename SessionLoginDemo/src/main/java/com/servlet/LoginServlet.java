package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Hardcoded credentials for simplicity
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = req.getSession();  // Create session
            session.setAttribute("username", username);
            resp.sendRedirect("welcome.jsp");        // Redirect to welcome page
        } else {
            req.setAttribute("msg", "Invalid username or password!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}

