<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import> 
<body>
	<c:choose>
	<c:when test="${ requestScope.found }" >
        <p> <b>First Name: </b> ${requestScope.user.firstName} <p>
        <p> <b>Last Name: </b> ${requestScope.user.lastName} <p>
        <p> <b>User Name: </b> ${requestScope.user.username} <p>
        <p> <b>Email Name: </b> ${requestScope.user.email} <p>
    </c:when>
	<c:otherwise>
		<p> User not found.. </p>
	</c:otherwise>
	</c:choose>
	<p> <a href="/ServletProject">Home page d-O_O-b</a></p>
</body>
<c:import url="/WEB-INF/views/footer.html"></c:import>
</html>