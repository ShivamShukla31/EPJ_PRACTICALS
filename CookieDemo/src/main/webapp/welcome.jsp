<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.net.URLDecoder" %>
<%
    Cookie[] cookies = request.getCookies();
    String username = null;

    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                username = URLDecoder.decode(c.getValue(), "UTF-8");
            }
        }
    }

    if (username != null) {
%>
<h2>Welcome, <%= username %>!</h2>
<h2>Cookie Created Successfully </h2>
<p><a href="deleteCookie.jsp">Delete Cookie</a></p>
<% 
    } else {
        response.sendRedirect("index.jsp");
    }
%>

