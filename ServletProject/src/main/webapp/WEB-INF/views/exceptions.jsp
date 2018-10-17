<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:import url="head.jsp"></c:import> 
<c:import url="navbar.jsp"></c:import> 
<body>
<h1>RUNTIME EXCEPTION ERROR PAGE!</h1>
<h1>${ pageContext.exception.message }</h1>
<div>
	<a href ="/ServletProject">Go back to home page.. </a>
</div>	
</body>
<c:import url="footer.html"></c:import> 
</html>