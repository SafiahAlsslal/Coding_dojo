<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>show idea</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>

	<div class="container">
		<h2>
			<c:out value="${idea.content}" />
		</h2>
		<p>
			Created by :
			<c:out value="${ idea.getUser().getname()}" />
		</p>
		<br>
		<h4>Users who liked your idea :</h4>
		<ul>
			<c:forEach items="${users}" var="user">
				<li>
					<p>
						<c:out value="${user}" />
					<p>
				</li>
			</c:forEach>

		</ul>


		<c:if test="${idea.getUser().getname() == name }">
			<a href="/ideas/${idea.id}/edit">Edit </a>
		</c:if>
	</div>

</body>
</html>