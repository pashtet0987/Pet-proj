<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a material</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div class="mx-auto text-left w-auto py-8 shadow-lg shadow-black rounded-3xl bg-white my-32 max-w-2xl">
    <h2 class="text-2xl font-semibold text-center border-b-2 pb-2 mx-6">Введите данные о принятом на склад сырье</h2>
    <form:form action="add-material" method="post" modelAttribute="material">
    <div class="grid grid-cols-2 gap-2 my-1 mx-6">
        <label class="text-xl flex items-center" for="name">Название сырья: </label>
        <form:input
                class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                id="name" path="name"/>
        <label class="text-xl flex items-center" for="name">Цена за единицу сырья(кг, л, т.д.): </label>
        <form:input
                class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                id="price" path="price"/>
        <label class="text-xl flex items-center" for="name">Валюта: </label>
        <form:select
                class="w-52 p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                id="currency" path="currencyName" items="${currencies}"/>
        <label class="text-xl flex items-center" for="amount">Количество единиц: </label>
        <form:input
                class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                id="amount" path="amount"/>
    </div><br>
    <div class="text-center">
        <button class="bg-gray-600 text-xl rounded-lg px-2 py-1 text-white hover:bg-blue-800" type="submit">
            Отправить
        </button>
    </div>
    </form:form>
</div>
</body>
</html>
