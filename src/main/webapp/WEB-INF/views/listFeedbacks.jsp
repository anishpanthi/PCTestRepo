<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<title>Feedbacks</title>
</head>
<body>
	<h1 align="center">Customer Feedbacks</h1>
	<div class="container">
		<table class="table table-striped">
			<th>First Name</th>
			<th>Last Name</th>
			<th>Comment</th>
			<c:forEach var="feedback" items="${feedbacks}">
				<tr>
					<td>${feedback.firstname}</td>
					<td>${feedback.lastname}</td>
					<td>${feedback.comments}</td>
				</tr>
			</c:forEach>
		</table>
		<br/><br/>
		<a href="/petclinic">Goto Home</a>
	</div>
</body>
</html>