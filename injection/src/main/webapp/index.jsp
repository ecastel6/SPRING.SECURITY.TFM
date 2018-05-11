<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SQL Injection Demo - Login</title>
</head>
<body>
<h1>Introduzca usuario y password</h1>
<form action="login">
    Usuario: <input type="text" name="username" value=""/><br/>
    Password: <input type="password" name="password" value=""/><br/>
    <input type="submit" value="Login"/>
</form>
</body>
</html>