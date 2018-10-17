<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import> 
<body>
	<c:choose>
	<c:when test="${ not empty sessionScope.user }" > 
			<form action="editprofile" method="GET">
				<button><b><u>Edit Profile</u></b></button>
			</form>
		<div class="list-user" style='background: #669999;'>
        <p> <b>First Name: </b> ${sessionScope.user.firstName} </p>
        <p> <b>Last Name: </b> ${sessionScope.user.lastName} </p>
        <p> <b>Username: </b> ${sessionScope.user.username} </p>
        <p> <b>Email Name: </b> ${sessionScope.user.email} </p>
        </div>
    </c:when>
	<c:otherwise>
		<p> You are not logged in. </p>
	</c:otherwise>
	</c:choose>
	<p> <a href="./">Home page d-O_O-b</a></p>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>