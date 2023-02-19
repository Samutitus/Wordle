<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/cover/">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>end</title>
	</head>
	<body class="text-center bg-info" style="margin-left:30%; margin-right:30%;">
	<div class="h1 mb-4 fw-normal text-white " style="margin-top:30;">Usted Gana</div>
		<form action="/search" method="post">
        	<input class="form-control text-center" style="margin-top:30;" type="number" name="number" id="number">
        	<button class="w-50 btn btn-lg btn-primary" style="margin-top:30;" type="submit">Search</button>
    	</form>
    <c:if test="${posicion != null}">
        <h4 class="h1 mb-4 fw-normal text-white " style="margin-top:30;">En la posicion ${posicion} probaste la palabra "${resultado}"</h4>
    </c:if>
	</body>
</html>