<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

   <!-- Этот view предназначен для отображения полей для заполнения информации по работику перед сохранением -->

    <title>Document</title>
  </head>
  <body>
    <h2>Employee Info</h2>
    <br>
    <form:form action = "saveEmployee" modelAttribute = "employee">
<!-- Ниже скрытая строка, чтобы подтянуть из базы id работника и не было видно на фронте. Зато вызовется метод saveEmployee и сохранится работник с нужным id-->
<form:hidden path = "id"/>

Name <form:input path = "name"/>
<br>
<br>
Surname <form:input path = "surname"/>
<br>
<br>
Department <form:input path = "department"/>
<br>
<br>
Salary <form:input path = "salary"/>
<br>
<br>
<input type = "submit" value = "OK">

<!-- Сначала срабатывают геттеры -->
<!-- После нажатия кнопки ОК срабатывают сеттеры -->

</form:form>
  </body>
</html>
