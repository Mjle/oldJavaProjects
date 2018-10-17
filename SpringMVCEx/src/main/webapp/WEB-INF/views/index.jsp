<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:import url="head.jsp"></c:import> 
<c:import url="navbar.jsp"></c:import> 
<body>
	<h1> Welcome to Spring MVC User System</h1>
	<c:if test="${ not empty sessionScope.user }">
		<h2 style="color: red;"> Welcome back, ${ sessionScope.user.firstName } </h2>
	</c:if>
	<h3> You may use the navigation bar for website navigation / user management .</h3>
	<h4> Alternatively, most pages should have a home page </h4>
</body>
<c:import url="footer.jsp"></c:import> 
</html>