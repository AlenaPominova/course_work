<%--
  Created by IntelliJ IDEA.
  User: Алена
  Date: 11.03.2018
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>singup</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/singup.css"/>"/>
    <style>
        <%@include file='/resources/css/singup.css' %>
    </style>

</head>
<body>

<div id="singup-form">
    <h1>РЕГИСТРАЦИЯ</h1>

    <fieldset>
        <form>
            <input type="email" placeholder="Логин" />
            <input type="password" placeholder="Пароль" />
            <input type="password"  placeholder="Повторите пароль"/>
            <input type="submit" value="Зарегистрироваться">
            <input type="button" value="Назад" id="back-btn" onclick="location.href='/singin';">
        </form>
    </fieldset>
</div>

</body>
</html>
