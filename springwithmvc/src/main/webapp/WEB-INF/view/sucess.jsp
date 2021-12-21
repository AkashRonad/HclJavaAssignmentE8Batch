<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<i>List Of Students</i>

	<table border="1">
		<tr>
			<th align="left">Student Id</th>
			<th align="left">Student Name</th>
			<th align="left">City</th>
			<th align="left">Pincode</th>

		</tr>
		<c:forEach items="${studentlist}" var="student">

			<tr>
				<td>${student.id}</td>
				<td>${student.userName}</td>
				<td>${student.address.city}</td>
				<td>${student.address.pincode}</td>

			</tr>
		</c:forEach>

	</table>
</body>
</html>