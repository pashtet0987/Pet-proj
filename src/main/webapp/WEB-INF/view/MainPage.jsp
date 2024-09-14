<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your shop</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div class="text-center bg-grey-200 min-h-screen py-3">
    <div class="bg-white rounded-lg w-full shadow-black shadow-lg mx-auto">
        <h1 class="font-semibold text-xl">Данные магазина</h1>
    </div>
    <div class="rounded-xl bg-white shadow-black shadow-lg my-1">
        <h3 class="font-semibold text-center">Сыры</h3>
        <table class="border-collapse border border-slate-900 w-full">
            <tbody>
            <tr>
                <th class="border border-slate-950">Id:</th>
                <th class="border border-slate-950">Название:</th>
                <th class="border border-slate-950">Себестоимость(за 1 головку):</th>
                <th class="border border-slate-950">Наценка(в %):</th>
                <th class="border border-slate-950">Цена с наценкой(за 1 головку):</th>
                <th class="border border-slate-950">Количество(в головках):</th>
                <th class="border border-slate-950">Дата производства:</th>
                <th class="border border-slate-950">Номер подчиненного:</th>

            </tr>

            <c:forEach var="myCheese" items="${cheese}">
                <tr>
                    <td class="border border-slate-950">${myCheese.id}</td>
                    <td class="border border-slate-950">${myCheese.cheeseName}</td>
                    <td class="border border-slate-950">${myCheese.price}</td>
                    <td class="border border-slate-950">${myCheese.markUp}</td>
                    <td class="border border-slate-950">${myCheese.markUpPrice}</td>
                    <td class="border border-slate-950">${myCheese.amount}</td>
                    <td class="border border-slate-950">${myCheese.dateOfProducing}</td>
                    <td class="border border-slate-950">${myCheese.action_performer_number}</td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="text-left">
    <button class="bg-gray-600 text-xl text-white font-semibold px-2 py-0 rounded-lg hover:bg-blue-800" onclick="window.location.href='/shop/add-cheese'">Произвести сыр</button>
    </div>
    <div class="rounded-xl bg-white shadow-black shadow-lg my-1">
        <h3 class="font-semibold text-center">Сырье</h3>
        <table class="border-collapse border border-slate-900 w-full">
            <tbody>
            <tr>
                <th class="border border-slate-950">Id:</th>
                <th class="border border-slate-950">Название:</th>
                <th class="border border-slate-950">Цена закупки(за 1 ед.):</th>
                <th class="border border-slate-950">Валюта:</th>
                <th class="border border-slate-950">Цена в рублях(за 1 ед.):</th>
                <th class="border border-slate-950">Количество на складе:</th>
                <th class="border border-slate-950">Дата получения:</th>
                <th class="border border-slate-950">Номер подчиненного:</th>
            </tr>
            <c:forEach var="material" items="${materials}">
                <tr>
                    <td class="border border-slate-950">${material.id}</td>
                    <td class="border border-slate-950">${material.name}</td>
                    <td class="border border-slate-950">${material.price}</td>
                    <td class="border border-slate-950">${material.currencyName}</td>
                    <td class="border border-slate-950">${material.rub_price}</td>
                    <td class="border border-slate-950">${material.amount}</td>
                    <td class="border border-slate-950">${material.date}</td>
                    <td class="border border-slate-950">${material.action_performer_number}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="text-left">
    <button class="bg-gray-600 text-xl text-white font-semibold px-2 py-0 rounded-lg hover:bg-blue-800" onclick="window.location.href='/shop/add-material'">Принять сырье</button>
    </div>
    <div class="rounded-xl bg-white shadow-black shadow-lg my-1">
        <h3 class="font-semibold text-center">Продажи</h3>
        <table class="border-collapse border border-slate-900 w-full">
            <tbody>
            <tr>
                <th class="border border-slate-950">Id:</th>
                <th class="border border-slate-950">Название сыра:</th>
                <th class="border border-slate-950">Количество проданных головок:</th>
                <th class="border border-slate-950">Цена(за 1 головку):</th>
                <th class="border border-slate-950">Дата продажи:</th>
                <th class="border border-slate-950">Номер подчиненного:</th>
            </tr>
            <c:forEach var="sell" items="${sells}">
                <tr>
                    <td class="border border-slate-950">${sell.id}</td>
                    <td class="border border-slate-950">${sell.cheeseName}</td>
                    <td class="border border-slate-950">${sell.amountOfSells}</td>
                    <td class="border border-slate-950">${sell.price}</td>
                    <td class="border border-slate-950">${sell.date}</td>
                    <td class="border border-slate-950">${sell.action_performer_number}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="text-left">
    <button class="bg-gray-600 text-xl text-white font-semibold px-2 py-0 rounded-lg hover:bg-blue-800 my-2" onclick="window.location.href='/shop/add-sell'">Продать сыр</button><br>
    <button class="bg-gray-600 text-xl text-white font-semibold px-2 py-0 rounded-lg hover:bg-blue-800 my-2" onclick="window.location.href='/shop/observe-recipes'">Рецепты</button><br>

    <button class="bg-gray-600 text-xl text-white font-semibold px-2 py-0 rounded-lg hover:bg-red-800 my-2" onclick="window.location.href='/logout'">Выйти</button>
    </div>
</div>
</body>
</html>
