<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento Film</title>
</head>
<body>

	<div style="text-align: center;">

		<form action="/WebAppSakilaSpring/inizio">
			<input type="submit" name="indietro" value="Torna alla HomePage">
		</form>
		${messaggio} <br>
		<form action="inserisciFilm" method="post">
			<table width="95%" border="1" align="center">
				<tr>
					<th width="28%">Titolo</th>
					<th width="28%">Prezzo (numero decimale, formato: 12.89)</th>
					<th width="15%">Durata in minuti</th>
					<th width="15%">Categoria</th>
					<th width="14%">Anno</th>
				</tr>
				<tr>
					<td width="28%"><input type="text" size="35" name="titolo"
						maxlength="30"></td>
					<td width="28%"><input type="text" name="prezzo">
						&nbsp; $</td>
					<td width="15%"><input type="number" name="durata" min="1" max="1000">
					</td>
					<td width="15%"><select name="categoria">
							<c:forEach items="${allCategories}" var="categoria">
								<option value="${categoria.category_id}">
									${categoria.name}</option>
							</c:forEach></td>

					<td width="14%"><input type="number" name="anno" min= "0" max="3000"
						value="2000"></td>
				</tr>
			</table>
			<br> <input type="submit" name="inserisciFilm"
				value="Inserisci Film"> <br> <br>
			<table width="20%" border="1" align="center">
				<tr>
					<th>Seleziona gli attori del film:</th>
				</tr>
				<c:forEach items="${allActors}" var="attore">
					<tr>

						<td><input type="checkbox" name="idAttoriDaInserire"
							value="${attore.actor_id}"> ${attore.first_name} &nbsp;
							${attore.last_name} <br></td>
					</tr>
				</c:forEach>
			</table>

		</form>

	</div>

</body>

</html>