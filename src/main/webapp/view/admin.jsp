<%--
  Created by IntelliJ IDEA.
  User: Алена
  Date: 04.05.2018
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>admin</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/adminStyle.css"/>"/>
    <style>
        <%@include file='/resources/css/adminStyle.css' %>
    </style>

</head>
<body>

<div id="headerMain">
    <div id="header">
        <ul class="menu-top">
            <li id="mt-first"><a href="/map">Карта</a></li>

                <li id="mt-4">
                    <form action="<%=request.getContextPath()%>/logout" method="POST" style="display: inline;">
                        <input type="submit" value="Выйти" >
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </li>
        </ul>
    </div>
</div>

<div id="center">
    <ul class="panels">
        <li>
            <div id="allParks">

            </div>
        </li>
        <li>
            <div id="selectPark">

            </div>
        </li>
    </ul>
</div>

<footer class="footer">
    <ul class="name">
        <li id="first">JustParkIt</li>
        <li id="second">email: justparkit@gmail.com</li>
        <li id="fird">тел.: +7 (908) 123 45 67</li>
    </ul>
</footer>

</body>
</html>
