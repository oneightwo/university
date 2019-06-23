<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавить студента</title>
</head>
<body>
<h1>Добавить студента</h1>
<form id="student" name="student" action="/add" method="post">
    <p>ФИО
        <input title="FullName" type="text" name="fullName"></p>

    <p>Группа
        <select name="idGroup" form="student">
            <option value=""></option>
            <#list groups as group>
                <option value="${group.id}">${group.number}</option>
            </#list>
        </select></p>

    <p>Тип стипендии
        <input title="TypeScholarship" type="text" name="typeScholarship"></p>
    <p>Дата зачисления
        <input title="DateReceipt" type="text" name="dateReceipt">
        <input form="student" type="submit" value="Сохранить"></p>
</form>

<p>
<form action="/list">
    <button type="submit">Список студентов</button>
</form>
</p>

<p>
<form action="/menu">
    <button type="submit">Меню</button>
</form>
</p>

</body>
</html>