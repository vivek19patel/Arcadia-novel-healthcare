<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" isErrorPage="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="wizardForm" method="POST" modelAttribute="regFrm">
<table align="center" bgcolor="orange" height="150" width="150">
<tr>
	<th colspan="2" align="center">Re-Confirmation </th>
</tr>
<tr>
	<td>Card No: </td><td><form:input  path="cardNum" disabled="true"/> </td>
</tr>
<tr>
	<td>CVV No: </td><td><form:input  path="cvv" disabled="true"/></td>
</tr>
<tr>
	<td>Name on card: </td><td><form:input  path="nameOnCard" disabled="true"/></td>
</tr>
<tr>
	<td>Exp Date: </td><td><form:input  path="expDate" disabled="true"/></td>
</tr>
<tr>
	<td>Mobile No: </td><td><form:input  path="mobNum" disabled="true"/></td>
</tr>
<tr>
	<td colspan="2" align="left">
	<input type="submit" name="_back" value="Back"> &nbsp;&nbsp;
	<input type="submit" name="_cancel" value="Cancel">&nbsp;&nbsp;
	<input type="submit" name="_proceed" value="Register">
					
	
	</td>
</tr>
</table>
</form:form>
</body>
</html>
