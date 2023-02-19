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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="text-center bg-info" style="margin-left:30%; margin-right:30%;">

		<h4 class="h1 mb-4 fw-normal text-white " style="margin-top:30;">Intentos: ${Attempts}</h3>
		<h4 class="h4 mb-4 fw-normal text-white " style="margin-top:30;">Numero de letras por palabra: ${numLetras}</h3>
		
		<c:forEach var="lista" items="${historial}">
		<div style="display: flex; margin-left:40%;">
			<c:forEach var="letra" items="${lista}">
				<c:if test="${letra.correcto}">
					<c:if test="${letra.posicion == letra.posicionCorrecta}">
						<h1 class="text-center" style="color:green; font-weight: bold;">${letra.letra}</h1> 
					</c:if>
					<c:if test="${letra.posicion != letra.posicionCorrecta}">
						<h1 class="text-center" style="color:yellow; font-weight: bold; ">${letra.letra}</h1> 
					</c:if>
				</c:if>
				<c:if test="${letra.correcto == false}">
					<h1 class="text-center" style="color:red; font-weight: bold; ">${letra.letra}</h1> 
				</c:if>
			</c:forEach> 
			</div>
		</c:forEach>
		
		

	<c:forEach var="word" items="${word}">
	<c:if test="${word.correcto}">
		<c:if test="${word.repetido == true}">
			<h1 class="text-center" style="color:green; font-weight: bold">La letra ${word.letra} se repite ${word.numRepetido} veces</h1> 
		</c:if>
	</c:if>
	</c:forEach>
	<div class="form-floating">
	<c:if test="${Attempts > 0}">
		<form action="/comprobar"  method="post">
			<input class="form-control text-center" type="text" name="word" id="word" >
			<input class="w-50 btn btn-lg btn-primary" style="margin-top:30" type="submit" value="Check">
		</form>
	</c:if>
	</div>
	<c:if test="${Attempts <= 0}">
		<h1>No tienes mas intentos</h1>
	</c:if>
	<form action="/limpiarHistorial" method="post">
		<input class="w-50 btn btn-lg btn-primary" type="submit" value="Restart">
	</form>
	<p class="mt-7 mb-3 text-muted">Gracias por jugar :)</p>

</body>
</html>


