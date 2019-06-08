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

<div id="container" align="center" class="box">

    <div id="allParks">
        список парковок
        <%--<div id="parkList">--%>
        <ul>
            <c:forEach items="${object}" var="i">
            <li onClick="document.getElementById('number').innerHTML = 'Парковка № ${i.id}';
                    document.getElementById('address').value = '${i.address}';
                    document.getElementById('freeSpots').value = '${i.numberOfFreeSpots}';
                    document.getElementById('price').value = '';
                    if (${i.isPaid}) {
                    document.getElementById('time').value = '${i.openTime} - ${i.closeTime}';
                    document.getElementById('price').value = ${i.price};
                    document.getElementById('paid').checked = true;
                    }
                    else {
                    document.getElementById('time').value = 'круглосуточно';
                    document.getElementById('paid').checked = false;
                    }">${i.address}</li>
            </c:forEach>
        </ul>
        <%--</div>--%>
    </div>
    <div id="selectPark">
        <label id="number"></label>
        <label>Адрес: </label> <input id="address"/>
        <label>Свободных мест: </label> <input id="freeSpots">
        <label>Время работы: </label> <input id="time">
        <label>Платная: </label> <input type="checkbox" id="paid">
        <label>Цена: </label> <input id="price">
        <input class="button" type="submit" value="Сохранить" >
        <input class="button" type="submit" value="Удалить" >
    </div>

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
