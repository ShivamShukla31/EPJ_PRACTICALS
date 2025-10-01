<%@ page import="java.util.List, com.pojo.Employee" %>
<!DOCTYPE html>
<html>
<head><title>Employee List</title></head>
<body>
<h2>All Employees</h2>
<%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
    if (employees != null && !employees.isEmpty()) {
        for (Employee e : employees) {
%>
            <p>
                ID: <%= e.getId() %><br>
                Name: <%= e.getName() %><br>
                Salary: <%= e.getSalary() %>
            </p>
            <hr>
<%
        }
    } else {
%>
    <p>No employees found!</p>
<%
    }
%>
<a href="EmployeeForm.jsp">Add New Employee</a>
</body>
</html>
