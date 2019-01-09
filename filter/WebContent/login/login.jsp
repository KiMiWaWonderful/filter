<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope[initParam.userSessionKey]==null }">
<form action="doLogin.jsp" method="post">
username:<input type="text" name="username">
<input type="submit" value="Submit">
</form>
</c:if>

<c:if test="${sessionScope[initParam.userSessionKey]!=null }">
欢迎：${sessionScope.USERSESSIONKEY}
</c:if>
</body>
</html>