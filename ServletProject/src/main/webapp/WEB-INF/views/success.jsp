<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import> 
<body>
	
	<c:if test="${ sessionScope.added }" >
		<p> Thanks <b>${ sessionScope.user.firstName }</b>. Successfully registered.</p>
		<p> <a href="editprofile">Edit Profile</a></p>
		<c:set var="added" value="false" scope="session"/>
	</c:if>
	<c:choose>
	<c:when test="${ sessionScope.loggedIn }" >
		<p> Welcome, <b>${ sessionScope.user.firstName }</b>. Successfully logged-in.</p>
	</c:when>
	<c:otherwise>
		<p> Something went wrong. </p>
		<p> <a href="login">Try again?</a></p>
	</c:otherwise>
	</c:choose>
	<p> <a href="/ServletProject">Home page</a></p>
</body>
<c:import url="/WEB-INF/views/footer.html"></c:import>
</html>