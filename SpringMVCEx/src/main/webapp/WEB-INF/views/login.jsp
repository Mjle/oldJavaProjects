<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<c:choose>
		<c:when test="${ sessionScope.loggedIn }">
			<p>Already logged in.</p>
		</c:when>
		<c:otherwise>
			<div id="add-user" class="options">
				<sf:form action="process" method="POST" modelAttribute="user">
					<sf:label path="username"> Username </sf:label>
					<sf:input type="text" path="username" />
					<sf:label path="password"> Password </sf:label>
					<sf:input type="password" path="password" />
					<input type="submit" value="Login" />
				</sf:form>
			</div>
		</c:otherwise>
	</c:choose>
	<p>
		<a href="/ServletProject">Home page d-O_O-b</a>
	</p>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>