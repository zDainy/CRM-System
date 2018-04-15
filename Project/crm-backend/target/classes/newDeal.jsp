<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="common.Product"%>
<%@page import="common.Client"%>
<%@page import="common.Deal"%>
<%@page import="common.Status"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/new.css">
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
        <form method="post" action="new">
            <h2>Выберите клиента</h2>
            <select name="clientSelect">
                <c:forEach var="client" items="${clients}">
                    <option value="${client.id}"><c:out value="${client.fio}"/></option>
                </c:forEach>
            </select>
            <h2>Выберите товар</h2>
            <select name="productSelect">
                <c:forEach var="product" items="${products}">
                    <option value="${product.id}"><c:out value="${product.name}"/> (<c:out value="${product.price}"/> руб.)</option>
                </c:forEach>
            </select>
            <h2>Статус</h2>
            <select name="statusSelect">
                <c:forEach var="status" items="${statuses}">
                    <option value="${status.id}"><c:out value="${status.name}"/></option>
                </c:forEach>
            </select>
            <h2>Комментарий</h2>
            <textarea placeholder="Комментарий.." name="comment" style="height:200px"></textarea>
            <div style="float: right;">
                <button class="box1btn" type="submit">Создать</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>