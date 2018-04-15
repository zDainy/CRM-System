<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/client.css">
    <title>Клиент</title>
</head>
<body>
<div class="header">
    <div class="container box-flex">
        <a class="logo" href="deal">CRM System</a>
    </div>
</div>
<div class="container flex-1">
    <div class="client">
        <h2>Создать нового клиента</h2>
        <h3>Пожалуйста заполните данные</h3>
        <form action="client" method="post">
            <input type="text" class="placeholder" name="name" placeholder="Имя">
            <input type="text" class="placeholder" name="address" placeholder="Адрес">
            <input type="text" class="placeholder" name="number" placeholder="Телефон">
            <input type="text" class="placeholder" name="passport" placeholder="Паспорт">
            <button class="box1btn" type="submit">Создать</button>
        </form>
    </div>
</div>
</body>
</html>