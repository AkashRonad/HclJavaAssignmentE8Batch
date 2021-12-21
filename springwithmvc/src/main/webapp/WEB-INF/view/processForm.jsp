<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>

<h1>Employee Details</h1>
<table border="1">
<tr>
<th align="left" >Name</th>
<th align="left">SAPID </th>
</tr>
<tr>
<td>${param.name}</td>
<td>${param.sapid}</td>

</tr>
</table>

</body>
</html>