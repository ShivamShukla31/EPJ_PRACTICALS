package com.servlet;

import java.io.IOException;
import java.util.List;
import com.pojo.Employee;
import com.util.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle POST: create employee
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = new Employee(name, salary);
        session.save(emp);
        tx.commit();
        session.close();

        req.setAttribute("msg", "Employee added successfully!");
        req.getRequestDispatcher("EmployeeForm.jsp").forward(req, resp);
    }

    // Handle GET: list all employees
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        session.close();

        req.setAttribute("employees", employees);
        req.getRequestDispatcher("EmployeeList.jsp").forward(req, resp);
    }
}

