<%--
  Created by IntelliJ IDEA.
  User: Алена
  Date: 11.03.2018
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>login</title>
    <%--<script type="text/javascript" src="<c:url value="/resources/libs/jquery-3.3.1.min.js"/>"></script>--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/singin.css"/>"/>
    <style>
        <%@include file='/resources/css/singin.css' %>
    </style>
    <%--<img src="../resources/img/parkovka.jpg" alt="">--%>

</head>
<body>

<div id="login-form">
    <h1>АВТОРИЗАЦИЯ</h1>
    <fieldset>
        <form action="<%=request.getContextPath()%>/singin" method="POST">
            <input name="email" type="email" required placeholder="Логин">
            <input name="password" type="password" required placeholder="Пароль">
            <input type="submit" value="Войти"/>
            <input type="button" value="Регистрация" onclick="location.href='/singup';" id="singup-btn">
            <input type="button" value="Карта" onclick="location.href='/map';" id="map-btn">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </fieldset>
</div>

</body>
</html>
