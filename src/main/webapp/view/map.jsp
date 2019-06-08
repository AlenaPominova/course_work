<%--
  Created by IntelliJ IDEA.
  User: Алена
  Date: 02.02.2018
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>
    <title>Map</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/mapStyle.css"/>"/>
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script type="text/javascript" src="<c:url value="/resources/libs/jquery-3.3.1.min.js"/>"></script>
    <%--<script type="text/javascript" src="<c:url value="/resources/js/map.js"/>"></script>--%>

    <style>
        <%@include file='/resources/css/mapStyle.css' %>
    </style>

</head>
<body>
<div id="headerMain">
    <div id="header">
        <ul class="menu-top">
            <li id="mt-first"><a href="">Карта</a></li>
            <li id="mt-2"><a>Поиск</a></li>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li id="mt-3"><a href="/singup">Регистрация</a></li>
                <li id="mt-4"><a href="/singin">Войти</a></li>
            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                    <li id="mt-3"><a href="/admin">Админ</a></li>
                </c:if>

                <c:if test="${pageContext.request.isUserInRole('USER')}">
                    <li id="mt-3"><a href="/profile">Профиль</a></li>
                </c:if>

                <li id="mt-4">
                    <form action="<%=request.getContextPath()%>/logout" method="POST" style="display: inline;">
                        <input type="submit" value="Выйти" >
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </li>
            </c:if>
        </ul>
    </div>
</div>

<div class="map">
    <div id="map" style="height: 100%;"></div>
</div>

<div class="left-panel" id="left-panel">
    <div id="close-btn">X</div>
    <ul class="parkInfo">
        <li id="number"></li>
        <li id="address"></li>
        <li id="freeSpots"></li>
        <li id="time"></li>
        <li id="paid"></li>
        <li id="price"></li>
    </ul>
</div>

<div class="left-panel" id="left-panel1">
    <div id="close-btn1">X</div>
    <ul>
        <li>
            <label>Улица: </label>
            <input type="text" name="street">
        </li>
        <li>
            <label>Дом: </label>
            <input type="text" name="house">
        </li>
    </ul>
</div>

<div class="left-panel" id="left-panel2">
    <div id="close-btn2">X</div>
    <ul class="userInfo">
        <li id="email">${user.email}</li>
        <li id="fio">${user.fio}</li>
    </ul>
</div>


<footer class="footer">
    <ul class="name">
        <li id="first">JustParkIt</li>
        <li id="second">email: justparkit@gmail.com</li>
        <li id="fird">тел.: +7 (908) 123 45 67</li>
    </ul>
</footer>


<script>
ymaps.ready(init);

function init(){
myMap = new ymaps.Map("map", {
center: [51.67, 39.18],
zoom: 13,
controls: []
},
    clusterer = new ymaps.Clusterer({
        preset: 'islands#invertedRedClusterIcons',
        groupByCoordinates: false,
        clusterDisableClickZoom: false,
        clusterHideIconOnBalloonOpen: false,
        geoObjectHideIconOnBalloonOpen: false
    })
);

    /* Remove unnecessary map's elements */
    myMap.controls.remove('zoomControl');
    myMap.controls.remove('geolocationControl');
    myMap.controls.remove('trafficControl');
    myMap.controls.remove('typeSelector');
    myMap.controls.remove('fullscreenControl');

    /* Move search panel to particular place on the map */
    var searchControl = new ymaps.control.SearchControl({
        options: {
            float: 'left',
            floatIndex: 200,
            noPlacemark: true,
            searchControlMaxWidth: [30, 72, 500],
            fitMaxWidth: true
        }
    });
    myMap.controls.add(searchControl);

    /* Send all parks there */
    <c:forEach items="${object}" var="i">
        /* Place each parking place on the map */
        var myPlacemark = new ymaps.Placemark([${i.latitude}, ${i.longitude}],
            {
                hintContent: 'Свободных мест: ${i.numberOfFreeSpots}'
            },
            {
                preset : 'islands#redDotIcon'
            }
        );

        /* Add click event to each mark */
        myPlacemark.events.add('click', function (e) {
            /* Remove custom search window TODO: delete this window */
            var searchPanel = document.getElementById('left-panel1');
            searchPanel.style.display = 'none';

            /* Open special window with full info about park */
            var panel = document.getElementById('left-panel');
            panel.style.display = 'block';

            /* Fill information */
            document.getElementById('number').innerHTML = 'Парковка № ${i.id}';
            document.getElementById('address').innerHTML = 'Адрес: ${i.address}';
            document.getElementById('freeSpots').innerHTML = 'Свободных мест: ${i.numberOfFreeSpots}';
            document.getElementById('price').innerHTML = '';

            var paid = '';
            if (${i.isPaid}) {
                document.getElementById('time').innerHTML = 'Время работы: ${i.openTime} - ${i.closeTime}';
                paid = 'платная';
                document.getElementById('price').innerHTML = 'Цена: ' + ${i.price};
            }
            else {
                document.getElementById('time').innerHTML = 'Время работы: круглосуточно';
                paid = 'бесплатная';
            }
            document.getElementById('paid').innerHTML = 'Статус: ' + paid;
        });
    clusterer.add(myPlacemark);
    </c:forEach>
    myMap.geoObjects.add(clusterer);
}

var clBtn = document.getElementById('close-btn');
clBtn.onclick = function() {
    var panel = document.getElementById('left-panel');
    panel.style.display = 'none';
};

var clBtn1 = document.getElementById('close-btn1');
clBtn1.onclick = function() {
    var panel = document.getElementById('left-panel1');
    panel.style.display = 'none';
};

var clBtn2 = document.getElementById('close-btn2');
clBtn2.onclick = function() {
    var panel = document.getElementById('left-panel2');
    panel.style.display = 'none';
};

var search = document.getElementById('mt-2');
search.onclick = function() {
    document.getElementById('left-panel').style.display = 'none';
    var panel = document.getElementById('left-panel1');
    panel.style.display = 'block';
};

var profile = document.getElementById('mt-3');
profile.onclick = function() {
    document.getElementById('left-panel').style.display = 'none';
    document.getElementById('left-panel1').style.display = 'none';
    var panel = document.getElementById('left-panel2');
    panel.style.display = 'block';
}
</script>

</body>
</html>
