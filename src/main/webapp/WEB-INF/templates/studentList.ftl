<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список студентов</title>
    <style type="text/css">
        TABLE {
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
            width: 30%;
        }

        TH {
            background: #b2d6ff; /* Цвет фона ячейки */
            text-align: left; /* Выравнивание по левому краю */

        }

        TD {
            background: #fff; /* Цвет фона ячеек */
            text-align: center; /* Выравнивание по центру */
        }

        TH, TD {
            border: 1px solid black; /* Параметры рамки */
            padding: 4px; /* Поля вокруг текста */
        }
    </style>
</head>
<body>
<h1>Список студентов</h1>

<p>
<form method="post" action="/filter">
    Поиск
    <input type="text" name="filter">
    <button type="submit">Найти</button>
</form>
</p>

<table>
    <tr>
        <th rowspan="2" class="first">id</th>
        <th rowspan="2">ФИО</th>
        <th colspan="3">Группа</th>
        <th rowspan="2">Тип стипендии</th>
        <th rowspan="2">Дата выдачи</th>
        <th rowspan="2">Удалить</th>
        <th rowspan="2">Изменить</th>
    </tr>
    <tr>
        <td class="first">id</td>
        <td class="first">Номер</td>
        <td class="first">Группа</td>
    </tr>

    <#list students as student>
        <tr>
            <td>${student.id}</td>
            <td>${student.fullName}</td>
            <td><#if (!student.group??)>-<#else> ${student.group.id}</#if></td>
            <td><#if (!student.group??)>-<#else> ${student.group.number}</#if></td>
            <td><#if (!student.group??)>-<#else> ${student.group.faculty}</#if></td>
            <td>${student.typeScholarship}</td>
            <td>${student.dateReceipt}</td>
            <td><a href="/delete/${student.id}">X</a></td>
            <td><a href="/update/${student.id}">Update</a></td>
        </tr>
    </#list>
</table>

<p>
<form action="/add">
    <button type="submit">Добавить студента</button>
</form>
</p>

<p>
<form action="/menu">
    <button type="submit">Меню</button>
</form>
</p>

</body>
</html>