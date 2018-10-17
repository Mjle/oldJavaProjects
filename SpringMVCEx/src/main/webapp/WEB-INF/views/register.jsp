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
			<div id="add-user" class="options">
				<form action="Register" method="POST">
					<label>First Name <input type="text" name="firstname"
						placeholder="Enter first name.." required />
					</label><br /> <label>Last Name <input type="text" name="lastname"
						placeholder="Enter last name.." required />
					</label><br />
					<c:if test="${ requestScope.usernameFailed }">
						<p>Invalid username. Try another one.</p>
					</c:if>
					<label>Username <input type="text" name="username"
						placeholder="Enter desired username.." required />
					</label><br />
					<c:if test="${ requestScope.passwordFailed }">
						<p>Password doesn't match.</p>
					</c:if>
					<label>Password <input type="password" name="password"
						placeholder="Enter password.." required />
					</label><br /> <label>Confirm Password <input type="password"
						name="confirmpassword" placeholder="Re-enter password.." required />
					</label><br /> <label>Email <input type="email" name="email"
						placeholder="Enter your e-mail.." required />
					</label><br /> <input type="submit" value="Register" name="submit" /> <br>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
	<p> <a href="/ServletProject">Home page d-O_O-b</a></p>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>