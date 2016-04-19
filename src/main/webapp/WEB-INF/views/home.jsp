<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title><spring:message code="label.title" /></title>
</head>
<body>
	<h1>
		<spring:message code="label.message" />
	</h1>

	<P>
		<spring:message code="label.timeMessage" />
		${serverTime}.
	</P>
	<br/><br/>
	<a href="login">Login</a>
	<br/><br/>
	<a href="feedback">Provide Feedback</a>
</body>
</html>
