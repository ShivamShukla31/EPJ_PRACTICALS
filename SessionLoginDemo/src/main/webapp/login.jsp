<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h2>Login</h2>
<form action="login" method="post">
    Username: <input type="text" name="username" required /><br/>
    Password: <input type="password" name="password" required /><br/>
    <input type="submit" value="Login" />
</form>

<% String msg = (String) request.getAttribute("msg");
   if (msg != null) { %>
       <p style="color:red;"><%= msg %></p>
<% } %>
</body>
</html>
