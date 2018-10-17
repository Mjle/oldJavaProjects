<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div id="add-msg" class="options">
				<form action="Login" method="POST">
				<c:if test="${ requestScope.usernameFailed }" > <p> Invalid username. </p> </c:if>
					<label>Login <input type="text" name="username"
						placeholder="Username.." required />
					</label><br /> <label>Password <input type="password" name="password"
						placeholder="Password.." required /> 				<c:if test="${ requestScope.passwordFailed }" > Invalid password. </c:if>
					</label><br /> <input type="submit" value="Login" name="submit" /> <br>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
	<p> <a href="/ServletProject">Home page d-O_O-b</a></p>
</body>
<c:import url="/WEB-INF/views/footer.html"></c:import>
</html>