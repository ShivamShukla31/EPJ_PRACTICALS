<%@ page import="java.util.List, com.pojo.Student" %>
<!DOCTYPE html>
<html>
<head><title>Student Records</title></head>
<body>
<h2>Student Records</h2>
<%
    List<Student> data = (List<Student>) request.getAttribute("data");
    if (data != null && !data.isEmpty()) {
        for (Student s : data) {
%>
            <p>
                ID: <%= s.getId() %><br>
                Name: <%= s.getName() %><br>
                Age: <%= s.getAge() %>
            </p>
            <hr>
<%
        }
    } else {
%>
    <p>No student records found!</p>
<%
    }
%>
</body>
</html>

