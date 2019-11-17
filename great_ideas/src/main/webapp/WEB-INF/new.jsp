<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>new idea</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<div class="form-group">
			<form:form method="POST" action="/ideas/new" modelAttribute="idea">
				<form:label path="content">idea:
		    	<form:errors path="content" />
					<br>
					<form:input type="text" class="form-control" path="content" />
				</form:label>
				<br>

				<input type="hidden" name="user" value=${currentUser.id}>
				<button type="submit" class="btn btn-primary">Create</button>
			</form:form>
		</div>
	</div>
</body>
</html>