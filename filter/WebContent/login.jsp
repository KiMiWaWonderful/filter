<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<font color="red">${message }</font>
	<br><br>
	
	<form action="hello.jsp" method="post">
	
		username: <input type="text" name="username" value="${param.username }"/>
		password: <input type="password" name="password"/>
	
		<input type="submit" value="Submit"/>
		
	</form>
</body>
</html>