<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${empty loginAdmin}">
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
 <c:if test="${not empty msg}">
 <span class="required">${msg}</span>
	</c:if>
	<form action="login" method="post">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id">
    </div>
    <div>
      <label>PASS</label><input type="password" name="password">
    </div>
  </fieldset>
  <input type="submit" value="ログイン">
</form>
<div>
  <a href="index.jsp">TOP画面へ</a>
</div>
</body>
</html>