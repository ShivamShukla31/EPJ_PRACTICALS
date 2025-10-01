<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                c.setMaxAge(0);  // Delete cookie
                response.addCookie(c);
            }
        }
    }
    response.sendRedirect("index.jsp");
%>
