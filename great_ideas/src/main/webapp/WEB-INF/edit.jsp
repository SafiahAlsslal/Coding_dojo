<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>edit</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<form:form action="/ideas/${idea.id}" method="post"
			modelAttribute="idea">

			<div class="form-group">
				<p>
					<form:label path="content">Idea</form:label>
					<form:errors path="content" />
					<form:input class="form-control" path="content" />
				</p>
			</div>
			<form:hidden path="user" />
			<form:hidden path="likes" value="${idea.likes}" />

			<button type="submit" class="btn btn-primary">Update</button>
			
		</form:form>


		<a href="/ideas/delete/${idea.id}"> Delete</a>

	</div>
</body>
</html>