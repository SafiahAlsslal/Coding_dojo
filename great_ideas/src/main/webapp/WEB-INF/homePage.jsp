<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h1>
			Welcome <c:out value="${currentUser.name}"></c:out>
		</h1>

		<br> <a href="/homea"> Asc </a> <span> | </span> <a
			href="/homed"> desc </a>


		<table class="table">
			<thead>
    <tr>
      <th scope="col">idea</th>
      <th scope="col">created by</th>
      <th scope="col">likes</th>
      <th scope="col">actions</th>
    </tr>
  </thead>
  
  	<c:forEach items="${ideas}" var="idea">
  				  <c:set var="x" scope="session" value="false" />
  <tbody>
    <tr>
    	<td><a href="/ideas/${idea.id}"><c:out
									value="${idea.content}" /></a></td>
			    			<td><c:out value="${idea.getUser().getname()}" /></td>
			    			<td><c:out value="${idea.likes}" /></td>
			    			
			    			<c:forEach items="${idea.getUsers_likes()}" var="i">
			    			<c:if test="${i == currentUser.name }"> 
			    			 <c:set var="x" scope="session" value="true" />
			    			 </c:if>
			    			</c:forEach>
			    			
			    			
			    			<c:if test="${x == 'true' }"> 
			    			<td><a href="/unlike/${idea.id}">UnLike</a></td>
			    			  </c:if>
			    			  
			    			  <c:if test="${x == 'false' }"> 
			    			 <td><a href="/likes/${idea.id}">Like</a></td>
			    			  </c:if>
    </tr>
    
			</c:forEach>
  </tbody>
</table>



		<a href="/ideas/new"> Create new idea </a>
		<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
        <br>
          <button type="submit" class="btn btn-primary">Logout!</button>
    </form>
    
    </div>
</body>
</html>