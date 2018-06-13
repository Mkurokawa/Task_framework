<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新結果確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<p>実行者：${fn:escapeXml(loginAdmin.admin_name)}</p>
<c:if test="${not empty msg}">
</c:if>
		<p>正常に登録されました</p>
		
<form action="select.jsp">
  <input type="submit" value="検索">
</form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
