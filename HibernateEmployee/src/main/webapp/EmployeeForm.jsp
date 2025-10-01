<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Employee Form</title></head>
<body>
<h2>Enter Employee Details</h2>
<form action="employee" method="post">
    Name: <input type="text" name="name" required/><br/>
    Salary: <input type="number" step="0.01" name="salary" required/><br/>
    <input type="submit" value="Add Employee"/>
</form>

<% String msg = (String) request.getAttribute("msg");
   if (msg != null) { %>
       <p><%= msg %></p>
<% } %>

<a href="employee">View All Employees</a>
</body>
</html>
