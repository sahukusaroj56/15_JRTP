<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>View Contacts</h3>
	
	
	<a href="LoadForm">+Add New Contact</a>
	<table border="1">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Name</th>
				<th>Number</th>
				<th>Email</th>
				<th>Action</th>
			</tr>

		</thead>

		<tbody>
			<c:forEach items="${contacts }" var="c" varStatus="count">
				<tr>
					<td>${count.index+1}</td>
					<td>${c.contactName}</td>
					<td>${c.contactNumber}</td>
					<td>${c.contactEmail}</td>
					<td><a href="">Edit</a> &nbsp; <a href="">Delete</a>



				</tr>

			</c:forEach>

		</tbody>
	</table>

</body>
</html>