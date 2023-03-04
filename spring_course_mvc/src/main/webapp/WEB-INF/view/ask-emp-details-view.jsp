<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>

    <link rel="stylesheet" type="text/css" href="style.css">


  </head>

   <body>

<!-- <div class="exampleone">

  </div> -->


  <!-- =========Для MyController========== -->
  <!--
    <h2>Dear, Employee, please enter you details</h2>
    <br />
    <br />
    <!-- форма показывает что будет работать метод в контроллере с добавлением к url showDetails и далее,
после нажатия на кнопку -отправить-, срабатывает метод в контроллере showEmpDetails
А метод в свою очередь вернёт show-emp-details-view
employeeName это временная переменная которая будет хранить вводимое пользователем имя
При нажатии на кнопку submit будет вызван action и соответственно метод showDetails -->

    <form action="showDetails" method="get">
      <input type="text" name="employeeName"
      placeholder="Write your name"/>
      <input type="submit">
    </form>

 <!-- =========== Ниже Для EmpController =========-->
 <!-- =========== Форма input========= -->
<h2>Dear, Employee, please enter you details</h2>
<br />
<br />
<!-- showDetails это адрес на след вью и сработает метод с "/showDetails" т.е. showEmpDetail-->
<!-- form:form это форма(форма содержащая др формы т.е. контейнер) в которой содержится однострочная форма input-->
<form:form action ="showDetails" modelAttribute ="employee">

<!-- Для каждой формы будет срабатывать геттер getName, getSurname
Name - это что будет стоять перед формой,а "name" ссылка на имя(поле) в классе Employee-->
<!-- placeholder="Write your name" это маска в форме -->

    Name <form:input path ="name" placeholder="Write your name"/>

 <!--Строка ниже выводит ошибку при не пройдении валидации. path = "name" означает,что это относится к name  -->
 <!-- form:errors -  форма отображающая ошибки-->

    <form:errors path = "name" />
<br>
<br>
Surname <form:input path ="surName"/>

<!-- валидация для surName-->
    <form:errors path = "surName"/>
<br>
<br>
Salary <form:input path="salary"/>

<!-- валидация для salary-->
    <form:errors path = "salary"/>
<br>
<br>

<!-- =========== Форма select - выпадающий список ========= -->
 Department <form:select path = "department">
<!-- в выпадающем списке будет "IT" а в значениях будет "Information Technology" -->
 <!-- <form:option value = "Information Technology" label = "IT"/> -->
 <!-- <form:option value = "Human Resources" label = "HR"/> -->
<!-- <form:option value = "Sales" label = "Sales"/> -->

<!-- Ниже тоже самое что и выше, но меньше кода благодаря выводу через мапу в классе Employee. И пишем  options а не option-->
<!-- items - это элементы коллекции departments из которой берём элементы. employee.departments - значит элемент коллекции экземпляра employee -->
 <form:options items = "${employee.departments}"/>

 </form:select>

<!-- =========== Форма radiobutton - переключатель. Пользователь може выбрать только один вариант========= -->
<br>
<br>
Which car do you want?

<!-- BMW <form:radiobutton path ="carBrand" value = "BMW"/>
Audi <form:radiobutton path ="carBrand" value = "Audi"/>
MB <form:radiobutton path ="carBrand" value = "Mercedes-Benz"/> -->

<!-- Ниже тоже самое что и выше, но меньше кода благодаря выводу через мапу в классе Employee -->
<!-- items - это элементы коллекции departments из которой берём элементы. employee.departments - значит элемент коллекции экземпляра employee -->
<form:radiobuttons path="carBrand" items ="${employee.carBrands}"/>

<form:errors path ="carBrand"/>
<!-- =========== Форма check box - флажок. Пользователь может выбрать несколько вариантов в отличие от radiobutton========= -->
<br>
<br>
Foreign language(s)
<!-- EN <form:checkbox path ="languages" value ="English"/>
DE <form:checkbox path ="languages" value ="Deutch"/>
FR <form:checkbox path ="languages" value ="French"/> -->

<!-- Ниже тоже самое что и выше, но меньше кода благодаря выводу через мапу в классе Employee. И пишем уже checkboxes а не checkboxe-->

<form:checkboxes path = "languages" items = "${employee.languageList}"/>

<!-- валидация для languages-->
<form:errors path ="languages"/>

<br>
<br>
Phone number <form:input path="phoneNumber"/>
<!-- валидация для phoneNumber-->
    <form:errors path ="phoneNumber"/>

<br>
<br>
Email  <form:input path="email"/>

    <!-- валидация для email-->
    <form:errors path="email"/>

<br>
<br>
<input type="submit" value="OK">

<!-- Сначала срабатывает геттеры -->
<!-- После нажатия кнопки ОК срабатывают Сеттеры котре мы вызываем в контроллере-->


    </form:form>

  </body>
</html>
