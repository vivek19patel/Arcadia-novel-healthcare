<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="loginServlet" method="POST">
<table align="center" bgcolor="orange">
<tr>
	<th colspan="2" align="center">Welcome to O2 </th>
</tr>
<tr>
	<td>Your Account No: </td><td>${accNo}</td>
</tr>
<tr>
	<td><a href="register.jsp">Registeration</a></td>
</tr>
<tr>
	<td colspan="2" align="right"><input type="submit" name="login" value="LogIn"></td>
</tr>
<!-- <tr>
	<td>Password: </td><td><input type="text" name="pwd"></td>
</tr> -->
<c:if test="${not empty loginRespFail}" var="loginF">
	<tr>
	<td colspan="2" align="center">${loginRespFail}</td>
</tr>
</c:if>
</table>
</form>
</body>
</html>