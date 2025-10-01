package epj_;

import java.io.IOException;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyServlet implements Servlet {
    ServletConfig config;
    ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        this.context = config.getServletContext();
        System.out.println("✅ MyServlet initialized!");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        // Store data in context
        context.setAttribute("msg", "Hello from MyServlet");

        // Read init parameter from web.xml (if defined)
        String name = config.getInitParameter("name");

        // Print greeting
        res.getWriter().println("<h2>Hello " + name + "</h2>");

        // Print HTML login form
        String form = "<form action='second' method='POST'>"
                + "Name: <input type='text' name='name'/><br/>"
                + "Email: <input type='email' name='email'/><br/>"
                + "Password: <input type='password' name='password'/><br/>"
                + "<input type='submit' value='Login'/>"
                + "</form>";
        res.getWriter().println(form);
    }

    @Override
    public void destroy() {
        System.out.println("❌ MyServlet destroyed.");
    }

    @Override
    public ServletConfig getServletConfig() { return config; }
    @Override
    public String getServletInfo() { return "MyServlet"; }
}

