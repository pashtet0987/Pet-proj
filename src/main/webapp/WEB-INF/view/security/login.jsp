<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div class="bg-blue-500 min-h-screen py-1">
    <div class="mx-auto text-center w-2/3 py-8 shadow-lg rounded-3xl bg-white my-52 max-w-2xl">
        <h2 class="text-xl font-semibold border-b-2 pb-2 mx-6">Login</h2>
        <form action="/login" method="post">
            <div class="grid grid-cols-2 gap-4 my-5 mx-6">
                <label for="phone" class="text-xl flex items-center">Телефон: </label>
                <input class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2" id="phone" type="tel" name="username">
                <label for="pw" class="text-xl flex items-center">Пароль: </label>
                <input class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2" id="pw" type="password" name="password">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"><br>
            <button class="bg-gray-600 text-xl text-white font-semibold px-4 py-1 rounded-lg hover:bg-blue-800" type="submit">Войти</button><br>
        </form>
        <button class="bg-gray-600 text-xl text-white font-semibold px-4 py-1 rounded-lg hover:bg-blue-800" onclick="window.location.href='/registration'">Регистрация</button>
    </div>
</div>

</body>
</html>
