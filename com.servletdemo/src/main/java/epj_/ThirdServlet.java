package epj_;

import java.io.IOException;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ThirdServlet implements Servlet {
    ServletConfig config;
    ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        this.context = config.getServletContext();
        System.out.println("✅ ThirdServlet initialized!");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        // Fetch context attribute
        String msg = (String) context.getAttribute("msg");

        res.getWriter().println("<h2>Hello from ThirdServlet!</h2>");
        res.getWriter().println("<p>Message from Context: " + msg + "</p>");
    }

    @Override
    public void destroy() {
        System.out.println("❌ ThirdServlet destroyed.");
    }

    @Override
    public ServletConfig getServletConfig() { return config; }
    @Override
    public String getServletInfo() { return "ThirdServlet"; }
}

