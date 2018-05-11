<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    Welcome <sec:authentication property="principal.username"/>
</sec:authorize>
<h1>Search Author</h1>
<form action="search">
    Author Name: <input type="text" name="authorname" value=""/><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>