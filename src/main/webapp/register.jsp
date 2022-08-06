<%--
  Created by IntelliJ IDEA.
  User: nur13
  Date: 3.08.2022
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <style><%@include file="/css/login.css"%></style>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form class="form-register" method="POST" action="auth?action=register">
    <div class="form-cont " >
        <h2>SIGN UP</h2>
        <div class="form-group m-4">
            <label for="name">Name</label>
            <input name="name" type="text" class="form-control" id="name"placeholder="Enter name">
        </div>

        <div class="form-group m-4">
            <label for="surname">Surname</label>
            <input name="surname" type="text" class="form-control" id="surname"placeholder="Enter surname">
        </div>

        <div class="form-group m-4">
            <label for="username">Username</label>
            <input name="username" type="text" class="form-control" id="username"placeholder="Enter username">
        </div>

        <div class="form-group m-4">
            <label for="password">Password</label>
            <input name="password" type="password" class="form-control" id="password" placeholder="Password">
        </div>

        <button type="submit" class="btn btn-primary m-4">Sign up</button>

        <div class="form-group m-3">
            <label>Do you have an account?&nbsp;<a href="auth?action=login">Login</a></label>
        </div>
    </div>
</form>

</body>
</html>
