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

		<c:if test="${allCategories != null}">
			<form action="/WebAppSakilaSpring/ricercaFilmPerCategoria">
				<strong>Ricerca film per categoria</strong> <br> <select
					name="categoriaFilm">

					<c:forEach items="${allCategories}" var="categoria">
						<option value="${categoria.category_id}">
							${categoria.name}</option>
					</c:forEach>
				</select> <input type="submit" name="cercaFilmPerCategoria" value="Cerca">
			</form>
		</c:if>
		<br>


		<c:if test="${allActors != null}">
			<form action="/WebAppSakilaSpring/ricercaFilmPerAttore">
				<strong>Ricerca film per attore</strong> <br> <select
					name="attoreId">
					<c:forEach items="${allActors}" var="attore">
						<option value="${attore.actor_id}">${attore.first_name}
							&nbsp ${attore.last_name}</option>
					</c:forEach>
				</select> <input type="submit" name="cercaFilmPerAttore" value="Cerca">
			</form>
		</c:if>

		<br>
		<form action="/WebAppSakilaSpring/ricercaAttore">
			<input type="text" name="ricercaAttore"> <input type="submit"
				name="cercaAttore" value="Cerca Attore">
		</form>
		<br>

		<form action="/WebAppSakilaSpring/inserimentoFilm">
			<input type="submit" name="inserimentoFilm"
				value="Inserisci un nuovo film">
		</form>
		<br>


		<c:if test="${listaFilm != null }">

			<table width="75%" border="1" align="center">
				<tr>
					<th width="40%">Titolo</th>
					<th width="24%">Costo</th>
					<th width="24%">Durata</th>
					<th width="12%">Anno</th>
				</tr>
				<c:forEach items="${listaFilm}" var="film">
					<tr>
						<td width="40%"><a
							href="/WebAppSakilaSpring/attoriPerFilm/${film.film_id}">
								${film.title} </a></td>
						<td width="24%">${film.rental_rate}&nbsp;$</td>
						<td width="24%">${film.length}&nbsp;min</td>
						<td width="12%">${film.release_year}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<c:if test="${listaAttori != null }">
			<table width="50%" border="1" align="center">
				<tr>
					<th width="50%">Attori</th>
				</tr>
				<c:forEach items="${listaAttori}" var="attore">
					<tr>

						<td width="50%"><a
							href="/WebAppSakilaSpring/filmPerAttore/${attore.actor_id}">
								${attore.first_name} &nbsp; ${attore.last_name} </a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</div>

</body>
</html>