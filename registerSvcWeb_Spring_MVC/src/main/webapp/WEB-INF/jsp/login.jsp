<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 
<%
session.invalidate();
%> --%>


<form:form action="loginForm" method="POST" modelAttribute="lognReqBean">
<table align="center" bgcolor="orange">
<tr>
	<th colspan="2" align="center">OxyGen(O2) Login</th>
</tr>
<tr>
	<td>Account No: </td><td><form:input  path="accNo"/></td><td><form:errors path="accNo"/> </td>
	
</tr>
<tr>
	<td>Mobile No: </td><td><form:input path="mobNo" /></td><td><form:errors path="mobNo"/> </td>
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
</form:form>


<form:form action="wizardForm" method="POST" modelAttribute="regFrm">
<table align="center" bgcolor="orange">

<tr>
	<td colspan="2" align="right"><input type="submit" name="register_form" value="Register"></td>
</tr>


</table>
</form:form>
</body>
</html>