<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="common.Product"%>
<%@page import="common.Client"%>
<%@page import="common.Deal"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/deal.css">
    <link rel="stylesheet" href="js/main.js">
    <title>Сделки</title>
</head>
<body>
<div class="header">
    <div class="container box-flex">
        <a class="logo" href="deal">CRM System</a>
    </div>
</div>
<div class="container flexand">
    <div class="deal">
        <form method="get" action="new">
            <button class="box1btn" type="submit">Создать сделку</button>
        </form>
        <form method="get" action="client" style="float: right;">
            <button class="box1btn" type="submit">Новый клиент</button>
        </form>
        <form class="search" method="get" action="deal">
            <div style="float: left;">
                <input type="text" class="placeholder" pattern="[0-9]*" name="min" placeholder="Мин. цена">
                <input type="text" class="placeholder" pattern="[0-9]*" name="max" placeholder="Мах. цена">
            </div>
            <div style="float: left;">
                <input type="text" class="placeholder" name="clientName" placeholder="Имя клиента">
                <input type="text" class="placeholder" name="productName" placeholder="Название продукта">
            </div>
            <div style="float: right; margin-top: 40px;">
                <button class="box3btn" type="submit">Поиск</button>
            </div>
        </form>
        <table class="simple-little-table" cellspacing='0'>
            <tr>
                <th>id</th>
                <th>Дата создания</th>
                <th>Клиент</th>
                <th>Продукт</th>
                <th>Стоимость</th>
                <th>Статус</th>
                <th>Комментарий</th>
                <th>Действие</th>
            </tr>
            <c:forEach var="deal" items="${deals}">
            <tr>
                <td><c:out value="${deal.id}"/></td>
                <td><c:out value="${deal.dateCreated}"/></td>
                <td><c:out value="${deal.clientName}"/></td>
                <td><c:out value="${deal.productName}"/></td>
                <td><c:out value="${deal.price}"/> руб.</td>
                <td><c:out value="${deal.statusName}"/></td>
                <td><c:out value="${deal.comment}"/></td>
                <td>
                    <c:if test="${deal.statusId != 5}">
                        <form method="post" action="deal">
                            <input type="hidden" name="dealId" value="${deal.id}">
                            <button class="box2btn" type="submit">Сменить статус</button>
                        </form>
                    </c:if>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>