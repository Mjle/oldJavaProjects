<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<c:choose>
		<c:when test="${!empty sessionScope.user }">
			<h1>Editing ${sessionScope.user.username }</h1>
			<form action="RemoveUser" method="GET">
			<button><b><u>Delete</u></b> your account <b><u>PERMANENTLY</u></b></button>
			</form>
			<c:if test="${ !sessionScope.userPw }">
				<p>No edits made. Enter current password..</p>
			</c:if>
			<c:if test="${ sessionScope.userPw }">
				<p>Successfully edited your account information.</p>
			</c:if>
			<div id="add-msg" class="options">
				<form action="EditProfile" method="POST">
					<label>First Name <input type="text" name="firstname"
						value="${ sessionScope.user.firstName }" required />
					</label><br /> <label>Last Name <input type="text" name="lastname"
						value="${ sessionScope.user.lastName }" " required />
					</label><br /> <label>Current Password <input type="password"
						name="currentpassword" placeholder="Enter current password.."
						required /> 
					</label><br /> 
					<c:if test="${ !sessionScope.validPw && sessionScope.userPw }">
							<p> Enter matching passwords.. Password not updated</p>
						</c:if>
					<label>Desired Password <input type="password"
						name="password" placeholder="Enter password.." />
					</label><br /> <label>Confirm Password <input type="password"
						name="confirmpassword" placeholder="Re-enter password.." />
					</label><br /> </label><br /> <label>Email <input type="text"
						name="email" value="${ sessionScope.user.email }" " required />
					</label><br /> <input type="submit" value="Edit Profile" name="submit" />
					<br>
				</form>
			</div>
			<c:set var="userPw" value="false" scope="session" />
		</c:when>
		<c:otherwise>
			<p>You are not logged in.</p>
		</c:otherwise>
	</c:choose>
	<p>
		<a href="/ServletProject">Home page d-O_O-b</a>
	</p>
</body>
<c:import url="/WEB-INF/views/footer.html"></c:import>
</html>