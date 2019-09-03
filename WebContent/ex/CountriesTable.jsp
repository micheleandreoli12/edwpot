<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>
<c:if test="${countries != null }">
Countries in ${requestScope.region}
</c:if>
<c:if test="${countries == null }">
Region selection
</c:if>
</title>
</head>
<body>
<c:if test="${countries == null }">

<h1>Welcome</h1>

	<h2>Please select which region you would like to discover</h2>

</c:if>
<c:if test="${countries != null }">

<h1>Data obtained</h1>

	
</c:if>
	
	<form action="/edwpot/ex/RegionsandCountriesPr">
		<div>
			<input type="radio" id="EU" name="fav" value="1" checked /> <label
				for="EU">Europe</label> <input type="radio" id="Amer" name="fav"
				value="2" /> <label for="Amer">Americas</label> <input type="radio"
				id="As" name="fav" value="3" /> <label for="As">Asia</label> <input
				type="radio" id="MEA" name="fav" value="4" /> <label for="MEA">Middle
				East and Africa</label>
		</div>
		<div>
			<input type="submit" value="Enter" />
		</div>
	</form>

<c:if test="${countries != null }">
	<h1>${requestScope.region}</h1>

	<div>

		<table>

			<tr>
				<th>country_id</th>
				<th>name</th>
			</tr>
			<c:forEach var="cur" items="${countries}">
				<tr>
					<td>${cur.id}</td>
					<td>${cur.name}</td>
				</tr>
			</c:forEach>

		</table>

	</div>
</c:if>
</body>
</html>