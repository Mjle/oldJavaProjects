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
	<div id="add-user" class="options">
		<c:choose>
			<c:when test="${ empty sessionScope.user }">
				<sf:form action="registerproc" method="POST" modelAttribute="user">
				<c:if test="${ requestScope.usernameFailed }" > <p> Invalid username. </p> </c:if>
				<c:if test="${ requestScope.passwordFailed }" > <p> Passwords don't match.. </p> </c:if>
					<table style="margin: 0 auto;">
						<tr>
							<td>First Name</td>
							<td><sf:input path="firstName" placeholder="Enter your first name..." required="required" /></td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td><sf:input path="lastName" placeholder="Enter your last name..." required="required"  /></td>
						</tr>
						<tr>
							<td>Username</td>
							<td><sf:input path="username"
									placeholder="Enter your username..." required="required"  /></td>
						</tr>
						<tr>
							
							<td>Password</td>
							<td><sf:password path="password"
									placeholder="Enter your password..." required="required" /></td>
						</tr>
						<tr>
							<td>Re-type password</td>
							<td><input type="password" name="confirmPassword" placeholder="Re-enter password" required="required" /></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><sf:input type="email" path="email" placeholder="Enter your email..." required="required" /></td>
						</tr>
						<tr>
							<td></td>
							<td><sf:button>Submit</sf:button></td>
						</tr>
					</table>
				</sf:form>
			</c:when>
			<c:otherwise>
				<p>You're already logged in. </p>
			</c:otherwise>
		</c:choose>
	</div>
	<p>
		<a href="./">Home page</a>
	</p>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>