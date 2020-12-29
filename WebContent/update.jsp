<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, tr, td {
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


<script>
$(document).ready(function(){
    $("input[type=button]").click(function(){
    		$(this).closest("td").prev().children().removeAttr("disabled");
    });
    $("input[type=submit]").click(function(){
		$("input").removeAttr("disabled");
});
});
</script>
</head>
<body>
<%@page import="coe.*" %>
<% 
Employee emp;
if(session.getAttribute("emp")==null){
	response.sendRedirect("index.html");
}
else{
	emp= (Employee)session.getAttribute("emp");
	String id=emp.getEmployee_id();
	DatabaseConnection dconn=new DatabaseConnection();
	 emp=dconn.getEmployee(id);%>
<h1>welcome <%=emp.getFirst_name() %></h1>
<h1>Profile details</h1>
<form action="update.do" method="post" id="updateform">
<table>
<tr>
<td>Employee Id: </td>
<td colspan="2"><input type="hidden" name="employee_id" value="<%=emp.getEmployee_id() %>"/><%=emp.getEmployee_id() %></td>
</tr>

<tr>
<td>First Name: </td>
<td><input type="text" name="first_name" value="<%=emp.getFirst_name() %>" disabled="disabled"/></td>
<td><input type="button" value="edit" /></td>
</tr>
<tr>
<td>Last Name: </td>
<td><input type="text" name="last_name" value="<%=emp.getLast_name() %>" disabled="disabled"/></td>
<td><input type="button" value="edit" /></td>
</tr>
<tr>
<td>Email Id: </td>
<td><input type="text"  name="email_id" value="<%=emp.getEmail_id() %>" disabled="disabled"/></td>
<td><input type="button" value="edit" /></td>
</tr>
<tr>
<td>Mobile Number: </td>
<td><input type="text" name="mobile_no" value="<%=emp.getMobile_no()%>" disabled="disabled"/></td>
<td><input type="button" value="edit" /></td>
</tr>
<tr><td colspan="3" class="center"><input type="submit" value="update"  /></td></tr>
</table>
</form>
<br/>
<a href="logout.do">Logout</a>
<%} %>
</body>
</html>