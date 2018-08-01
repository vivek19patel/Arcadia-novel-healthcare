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
<form:form action="wizardForm" method="POST" modelAttribute="regFrm">
<table align="center" bgcolor="orange">
<tr>
	<th colspan="2" align="center">Registeration Form </th>
</tr>
<tr>
	<td>Card No: </td><td><form:input type="text" path="cardNum"/></td><td><form:errors path="cardNum"/> </td>
</tr>
<tr>
	<td>CVV No: </td><td><form:input type="text" path="cvv"/></td><td><form:errors path="cvv"/> </td>
</tr>
<tr>
	<td>Name on card: </td><td><form:input type="text" path="nameOnCard"/></td><td><form:errors path="nameOnCard"/> </td>
</tr>
<tr>
	<td>Exp Date: </td><td><form:input type="text" path="expDate"/></td><td><form:errors path="expDate"/> </td>
</tr>
<tr>
	<td>Mobile No: </td><td><form:input type="text" path="mobNum"  /></td><td><form:errors path="mobNum"/> </td>
</tr>
<tr>
	<td colspan="2" align="right"><input type="submit" name="continue" value="Continue"></td>
	
</tr>


</table>
</form:form>
</body>
</html>
