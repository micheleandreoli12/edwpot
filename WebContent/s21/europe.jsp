<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sql:query dataSource="jdbc/hr" var="regions">select country_id, country_name from regions r natural join countries c where region_name= 'Europe'</sql:query>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<table class="table table-hover">
			<tr>
				<th>countryid</th>
				<th>name</th>
			</tr>
			<c:forEach var="cur" items="${regions.rows}">
				<tr>
					<td>${cur.COUNTRY_ID}</td>
					<td>${cur.COUNTRY_NAME}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>