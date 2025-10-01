<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<h2>Enter Student Details</h2>
<form action="students" method="post">
    Id: <input type="number" name="id" required /><br/>
    Name: <input type="text" name="name" required /><br/>
    Age: <input type="number" name="age" required /><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>

