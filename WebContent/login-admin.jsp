<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,th, tr, td {
border: solid;
}
.center {
text-align: center;
}
</style>
<!--include jQuery -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" 
type="text/javascript"></script>

<!--include jQuery Validation Plugin-->
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.12.0/jquery.validate.min.js" 
type="text/javascript"></script>

</head>
<body>
<%@page import="coe.*" %>
<%@page import="java.util.List" %>
<h1> Welcome, Admin</h1>
<table>
<thead>
<tr>
<th>Employee Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email Id</th>
<th>Mobile Number</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<% 
if(session.getAttribute("emps")==null){
	response.sendRedirect("index.html");
}
else{
List<Employee>  employees=(List<Employee>) session.getAttribute("emps");
for(Employee emp: employees) { %>
<tr>
<td ><%=emp.getEmployee_id() %></td>
<td ><%=emp.getFirst_name() %></td>
<td ><%=emp.getLast_name() %></td>
<td ><%=emp.getEmail_id()%></td>
<td ><%=emp.getMobile_no()%></td>
<td ><a href="update-admin.jsp?id=<%=emp.getEmployee_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="delete.do?id=<%=emp.getEmployee_id() %>">Delete</a></td>
</tr>
<%} } %>
</tbody>
</table>
<br/>
<a href="logout.do">Logout</a>
</body>
</html>