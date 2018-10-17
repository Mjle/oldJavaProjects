<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import> 
<body>
	<c:choose>
	<c:when test="${ not empty requestScope.user }" >
		<div class="list-user" style='background: #669999;'>
        <p> <b>First Name: </b> ${requestScope.user.firstName} <p>
        <p> <b>Last Name: </b> ${requestScope.user.lastName} <p>
        <p> <b>User Name: </b> ${requestScope.user.username} <p>
        <p> <b>Email Name: </b> ${requestScope.user.email} <p>
		</div>
    </c:when>
	<c:otherwise>
		<p> User not found.. </p>
	</c:otherwise>
	</c:choose>
	<p> <a href="./">Home page d-O_O-b</a></p>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>