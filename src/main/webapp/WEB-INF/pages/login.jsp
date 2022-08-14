<%--
  Created by IntelliJ IDEA.
  User: nur13
  Date: 3.08.2022
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/login.css" rel="stylesheet">
    <style><%@include file="/css/login.css"%></style>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form class="login-form" method="POST" action="auth?action=login" >
    <div class="form-cont " >
        <h2 style="justify-content: center;justify-items: center">LOGIN</h2>
    <div class="form-group m-4">
        <label for="username">Username</label>
        <input type="text" class="form-control" name="username" id="username"placeholder="Enter username">
    </div>

    <div class="form-group m-4">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" id="password" placeholder="Password">
    </div>
        <div class="form-group m-lg-4">
            <%
                String error = (String) request.getAttribute("error");
            %>
            <span id="error" class="text-danger form-group"><%=error==null?"":error%></span>
        </div>

    <button type="submit" class="btn btn-primary m-4">Login</button>

    <div class="form-group m-3">
        <label>Don't you have an account?&nbsp;<a href="auth?action=register">Sign up</a></label>
    </div>
    </div>
</form>

</body>
</html>
