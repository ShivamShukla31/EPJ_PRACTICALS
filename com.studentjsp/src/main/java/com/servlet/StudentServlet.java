package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.dao.StudentsDao;
import com.pojo.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle POST from form
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));

            StudentsDao dao = new StudentsDao();
            dao.create(id, name, age);            // Insert student
            List<Student> data = dao.get();       // Fetch all students
            req.setAttribute("data", data);

            RequestDispatcher dispatch = req.getRequestDispatcher("Result.jsp");
            dispatch.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }

    // Handle GET to view all students directly
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            StudentsDao dao = new StudentsDao();
            List<Student> data = dao.get();
            req.setAttribute("data", data);
            RequestDispatcher dispatch = req.getRequestDispatcher("Result.jsp");
            dispatch.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}


