<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Welcome</title></head>
<body>
<%
    // Use implicit session variable provided by JSP
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp"); // Redirect if not logged in
    } else {
        String username = (String) session.getAttribute("username");
%>
<h2>Welcome, <%= username %>!</h2>
<a href="logout.jsp">Logout</a>
<% } %>
</body>
</html>

