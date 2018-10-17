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
		<c:when test="${ not empty sessionScope.user }">
			<p>Already logged in.</p>
		</c:when>
		<c:otherwise>
			<div id="add-user" class="options">
				<c:if test="${ requestScope.usernameFailed }" > <p> Invalid username. </p> </c:if>
				<c:if test="${ requestScope.passwordFailed }" > <p> Invalid password. </p> </c:if>
				<form action="loginproc" method="POST">
					<label>Login <input type="text" name="username"
						placeholder="Username.." required />
					</label><br /> 
					<label>Password 
					<input type="password" name="password" placeholder="Password.." required />
					</label><br /> 
					<input type="submit" value="Login" name="submit" /> <br>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
	<p>
		<a href="./">Home page d-O_O-b</a>
	</p>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>