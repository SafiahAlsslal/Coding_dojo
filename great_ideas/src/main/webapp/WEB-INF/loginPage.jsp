<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<c:if test="${logoutMessage != null}">
			<c:out value="${logoutMessage}"></c:out>
		</c:if>
		<h1>Login</h1>
		<c:if test="${errorMessage != null}">
			<c:out value="${errorMessage}"></c:out>
		</c:if>


		<form method="POST" action="/login">

			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					name="email">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="exampleInputPassword1"
					name="password">
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit" class="btn btn-primary">Login</button>

		</form>


		<h1>Register</h1>

		<p>
			<form:errors path="user.*" />
		</p>

		<form:form method="POST" action="/registration" modelAttribute="user">


			<div class="form-group">
				<p>
					<form:label path="name">Name:</form:label>
					<form:input class="form-control" path="name" />
				</p>
			</div>
			<div class="form-group">
				<p>
					<form:label path="email">Email:</form:label>
					<form:input class="form-control" type="Email" path="email" />
				</p>
			</div>
			<div class="form-group">
				<p>
					<form:label path="password">Password:</form:label>
					<form:password class="form-control" path="password" />
				</p>
			</div>
			<div class="form-group">
				<p>
					<form:label path="passwordConfirmation">Password Confirmation:</form:label>
					<form:password class="form-control" path="passwordConfirmation" />
				</p>
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
		</form:form>
	</div>

</body>
</html>