<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div class="bg-blue-500 min-h-screen py-1">
    <div class="mx-auto text-left w-2/3 py-8 shadow-lg shadow-black rounded-3xl bg-white my-32 max-w-2xl">
        <h2 class="text-2xl font-semibold text-center border-b-2 pb-2 mx-6">Registration</h2>
        <form:form modelAttribute="user" action="/registration" method="post">
            <div class="grid grid-cols-2 gap-2 my-1 mx-6">
                <label class="text-xl flex items-center" for="phone">Телефон: </label>
                <form:input
                        class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                        id="phone" path="phoneNumber"/>
                <label class="text-xl flex items-center" for="password">Пароль: </label>
                <form:input
                        class="w-full p-1 border-2 placeholder-blue-800 border-blue-700 appearance-none rounded-lg focus:outline-none focus:ring-2"
                        id="password" path="password"/>
            </div>
            <div class="grid grid-cols-1 gap-2 my-1 mx-6">
                <label class="text-xl flex" for="role">Отдел: </label>
                <form:checkboxes class="text-bald" id="role" path="roles" items="${rolesMap}"/><br>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button class="bg-gray-600 text-xl rounded-lg px-2 py-0 text-white hover:bg-blue-800" type="submit">
                    Зарегистрироваться
                </button>
            </div>
        </form:form>
    </div>
</div>


<%--<form:form modelAttribute="user" action="/registration" method="post">--%>
<%--    <form:label path="phoneNumber">Телефон: </form:label>--%>
<%--    <form:input path="phoneNumber"/><br>--%>
<%--    <form:label path="password">Пароль: </form:label>--%>
<%--    <form:input path="password" /><br>--%>
<%--    <form:label path="roles">Отдел: </form:label>--%>
<%--    <form:checkboxes path="roles" items="${rolesMap}"/><br>--%>
<%--    <input type="hidden" name="_csrf" value="${_csrf.token}">--%>
<%--    <button type="submit">Зарегистрироваться</button>--%>
<%--</form:form>--%>

</body>
</html>
