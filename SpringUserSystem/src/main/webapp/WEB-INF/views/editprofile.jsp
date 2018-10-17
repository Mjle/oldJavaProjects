<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<c:choose>
		<c:when test="${!empty sessionScope.user }">
			<h1>Editing ${sessionScope.user.username }</h1>
			<form action="removeproc" method="GET">
				<button>
					<b><u>Delete</u></b> your account <b><u>PERMANENTLY</u></b>
				</button>
			</form>
			<c:if test="${ requestScope.passwordCurrentFail }">
				<p>No edits made. Enter current password..</p>
			</c:if>
			<c:if test="${ requestScope.userPw }">
				<p>Successfully edited your account information.</p>
			</c:if>
			<div id="add-msg" class="options">
								<sf:form action="editprofileproc" method="POST" modelAttribute="editUser">
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
							<td>Password</td>
							<td><sf:password path="password"
									placeholder="Enter your password..." required="required" /></td>
						</tr>
						<tr>
							<td>Desired password</td>
							<td><input type="password" name="desiredPassword" placeholder="Desired password" /></td>
						</tr>
						<tr>
							<td>Re-type password</td>
							<td><input type="password" name="confirmPassword" placeholder="Re-enter password" /></td>
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
			</div>
		</c:when>
		<c:otherwise>
			<p>You are not logged in.</p>
		</c:otherwise>
	</c:choose>
	<p>
		<a href="./">Home page d-O_O-b</a>
	</p>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>