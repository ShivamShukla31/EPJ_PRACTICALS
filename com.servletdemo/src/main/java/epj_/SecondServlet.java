package epj_;

import java.io.IOException;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class SecondServlet implements Servlet {
    ServletConfig config;
    ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        this.context = config.getServletContext();
        System.out.println("✅ SecondServlet initialized!");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        // Fetch context attribute
        String msg = (String) context.getAttribute("msg");

        // Read form data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        res.getWriter().println("<h2>Welcome " + name + "!</h2>");
        res.getWriter().println("<p>Email: " + email + "</p>");
        res.getWriter().println("<p>Password: " + password + "</p>");
        res.getWriter().println("<p>Message from Context: " + msg + "</p>");

        // Link to ThirdServlet
        res.getWriter().println("<a href='third'>Go to Third Servlet</a>");
    }

    @Override
    public void destroy() {
        System.out.println("❌ SecondServlet destroyed.");
    }

    @Override
    public ServletConfig getServletConfig() { return config; }
    @Override
    public String getServletInfo() { return "SecondServlet"; }
}
