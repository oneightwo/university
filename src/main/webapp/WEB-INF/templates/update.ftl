<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Редактировать студента</title>
</head>
<body>
<h1>Редактировать студента</h1>
<form id="student" name="student" action="/update/${student.id}" method="post">
    <p>Id
        <input type="text" name="id" disabled value="${student.id}"></p>
    <p>ФИО
        <input type="text" name="fullName" value="${student.fullName}"></p>
    <p>Группа

        <select name="idGroup" form="student">
            <option value="" <#if student.group??>selected</#if>></option>
            <#list groups as group>
                <option value="${group.id}"
                        <#if (student.group?? && group.id == student.group.id)>selected</#if>>${group.number}</option>
            </#list>
        </select></p>

    <p>Тип стипендии
        <input type="text" name="typeScholarship" value="${student.typeScholarship}"></p>
    <p>Дата зачисления
        <input type="text" name="dateReceipt" value="${student.dateReceipt}">
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