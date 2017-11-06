<%--
  Created by IntelliJ IDEA.
  User: CreiZyz
  Date: 06/11/2017
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="elements/header.jsp"%>

<div>
    <form action="/User/Login" method="post">
        <input type="text"     name="login"    class="login-input" placeholder="identifiant"  required/>
        <input type="password" name="password" class="login-input" placeholder="mot de passe" required/>
        <input type="submit" value="connexion"/>
        <input type="checkbox" name="keepconnected" id="keepconnected"><label for="keepconnected"></label>
    </form>
</div>

</body>
</html>
