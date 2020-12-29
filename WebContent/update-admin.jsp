<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="coe.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</style>
<!--include jQuery -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" 
type="text/javascript"></script>

<!--include jQuery Validation Plugin-->
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.12.0/jquery.validate.min.js" 
type="text/javascript"></script>


<script>
$(document).ready(function(){
 
    $("input[type=submit]").click(function(){
		$("#disable").removeAttr("disabled");
});
});
</script>
</head>
<body>
<% 
String id=null;
Employee emp=null;
if(session.getAttribute("emps")==null){
	response.sendRedirect("index.html");
}
else{
 id=request.getParameter("id");	
	DatabaseConnection dconn=new DatabaseConnection();
 emp=dconn.getEmployee(id);
}%>
<h1>Update Employee Details</h1>
<form action="update.do" method="post" >
<table>
<tr>
<td> Employee ID: </td>
<td><input type="text" id="disable" disabled="disabled" name="employee_id" value="<%=emp.getEmployee_id()%>"/></td>
</tr>
<tr>
<td> First Name:</td>
<td> <input type="text" name="first_name" value="<%=emp.getFirst_name()%>"/></td>
</tr>
<tr>
<td> Last Name:</td>
<td> <input type="text" name="last_name" value="<%=emp.getLast_name()%>"/></td>
</tr>
<tr>
<td> Email ID:</td>
<td> <input type="text" name="email_id" value="<%=emp.getEmail_id()%>"/></td>
</tr>
<tr>

<td> Mobile No: </td>
<td><input type="text" name="mobile_no" value="<%=emp.getMobile_no()%>"/></td>
</tr>
<tr><td colspan="3"><input type="submit" value="update"  /></td></tr>
</table>
</form>
</body>
</html>