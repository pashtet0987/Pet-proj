<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удаление рецепта</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div class="mx-auto text-left w-2/3 py-8 shadow-lg shadow-black rounded-3xl bg-white my-32 max-w-2xl">
    <h2 class="text-2xl font-semibold text-center border-b-2 pb-2 mx-6">Удалить компонент(все компоненты) из рецепта</h2>
<form method="post" action="delete-recipe" >
    <div class="grid grid-cols-2 gap-2 my-1 mx-6">
        <label for="cheese" class="text-xl flex items-center">Название сыра: </label>
    <input class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2" id="cheese" type="text" name="cheese" placeholder="enter cheese name">
        <label for="component" class="text-xl flex items-center">Название компонента: </label>
    <input class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2" id="component" type="text" name="material" placeholder="enter material name">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    </div>
    <br>
    <div class="text-center">
    <button class="bg-gray-600 text-xl rounded-lg px-2 py-1 text-white hover:bg-blue-800" type="submit">Удалить</button>
    </div>
</form>
</div>
</body>
</html>
