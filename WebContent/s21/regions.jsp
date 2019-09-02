<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sql:query dataSource="jdbc/hr" var="regions">select * from regions</sql:query>
<title>HR Regions</title>
</head>
<body>
<div class="container-fluid">
    <table class="table table-hover">
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="cur" items="${regions.rows}">
            <tr>
                <td>${cur.REGION_ID}</td>
                <td>${cur.REGION_NAME}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
</body>
</html>