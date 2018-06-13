<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${empty loginAdmin}">

</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<table border="1">
		<tr>
			<th>user_id</th>
			<th>user_name</th>
			<th>telephone</th>
		</tr>
		<c:forEach var="select" items="${select}">
			<tr>
				<td>${fn:escapeXml(select.user_id)}</td>
				<td>${fn:escapeXml(select.user_name)}</td>
				<td>${fn:escapeXml(select.telephone)}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>
