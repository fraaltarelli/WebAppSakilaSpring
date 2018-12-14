<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web App Sakila Spring</title>
</head>
<body>
	<div style="text-align: center;">

		<c:if test="${allcategories != null}">
			<form action="filmpercategoria">
				<strong>Ricerca film per categoria</strong> <br> <select
					name="categoriafilm">

					<c:forEach items="${allcategories}" var="categoria">
						<option value="${categoria.category_id}">
							${categoria.name}</option>
					</c:forEach>
				</select> <input type="submit" name="cercafilmpercategoria" value="Cerca">
			</form>
		</c:if>
		<br>


		<c:if test="${allactors != null}">
			<form action="filmperattore">
				<strong>Ricerca film per attore</strong> <br> <select
					name="attorefilm">
					<c:forEach items="${allactors}" var="attore">
						<option value="${attore.actor_id}">${attore.first_name}
							&nbsp ${attore.last_name}</option>
					</c:forEach>
				</select> <input type="submit" name="cercafilmperattore" value="Cerca">
			</form>
		</c:if>

		<c:if test="${listafilm != null }">
			<a href="inizio">
				<button>Torna alla Home</button>
			</a>
			<br>
			<br>
			<table width="75%" border="1" align="center">
				<tr>
					<th width="50%">Titolo</th>
					<th width="25%">Costo</th>
					<th width="25%">Durata</th>
				</tr>
				<c:forEach items="${listafilm}" var="film">
					<tr>
						<td width="50%"><a
							href="attoriperfilm?filmId=${film.film_id}"> ${film.title} </a></td>
						<td width="25%">${film.rental_rate}&nbsp;$</td>
						<td width="25%">${film.length}&nbsp;min</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<c:if test="${listaattori != null }">
			<a href="inizio">
				<button>Torna alla Home</button>
			</a>
			<br>
			<br>
			<table width="50%" border="1" align="center">
				<tr>
					<th width="50%">Attori</th>
				</tr>
				<c:forEach items="${listaattori}" var="attore">
					<tr>
						<td width="50%"><a
							href="filmperattore?attorefilm=${attore.actor_id}">
								${attore.first_name} &nbsp; ${attore.last_name} </a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</div>

</body>
</html>