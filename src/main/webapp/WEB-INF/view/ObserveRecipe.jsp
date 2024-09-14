<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Observe Recipe</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div class="text-center bg-grey-200 min-h-screen py-3">
    <div class="bg-white rounded-lg w-full shadow-black shadow-lg mx-auto">
        <h1 class="font-semibold text-xl">Обзор существующих рецептов</h1>
    </div>
    <div class="rounded-xl bg-white shadow-black shadow-lg my-1">
    <c:forEach var="name" items="${cheeseNames}">
        <h3 class="text-xl">Название сыра: ${name}</h3>
        <table class="border-collapse border border-slate-900 w-96">
            <tbody>
            <th class="border border-slate-950">Компонент:</th>
            <th class="border border-slate-950">Количество:</th>
            <c:forEach var="recipe" items="${recipes}">
                <tr>
                    <c:if test="${recipe.cheeseName == name}">
                        <td class="border border-slate-950">${recipe.materialName}</td>
                        <td class="border border-slate-950">${recipe.amountOfMaterialRequired}</td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:forEach>
    </div><br>
    <div class="text-left">
        <button class="bg-gray-600 text-xl text-white font-semibold px-2 py-0 rounded-lg hover:bg-green-800" onclick="window.location.href='/recipes/add-recipe'">Добавить рецепт</button>
    </div><br>
    <div class="text-left">
        <button class="bg-gray-600 text-xl text-white font-semibold px-2 py-0 rounded-lg hover:bg-red-800" onclick="window.location.href='/recipes/delete-recipe'">Удалить рецепт</button>
    </div>
</div>


</body>
</html>
