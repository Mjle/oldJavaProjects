<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<p>
		<a href="/ServletProject">Home page d-O_O-b</a>
	</p>
	<c:choose>
		<c:when test='${empty requestScope.users}'>
			<p>Something went wrong. No users in the system.</p>
		</c:when>
		<c:otherwise>
			<c:forEach var='user' items='${ requestScope.users }'>
				<div class="list-msg" style='background: #669999;'>
					<p>
						First Name:
						<c:out value='${ user.firstName }' />
					</p>
					<p>
						Last Name:
						<c:out value='${ user.lastName }' />
					</p>
					<p>
						Username:
						<c:out value='${ user.username }' />
					</p>
					<p>
						Email:
						<c:out value='${ user.email }' />
					</p>
					<p>
				</div>
				<br>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
<c:import url="/WEB-INF/views/footer.html"></c:import>
</html>