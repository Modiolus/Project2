<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>

<!-- Таблица для вывода всех работников -->
    <h2>All Employees</h2>
    <table>
      <tr>
      <!-- Заголовки колонок <th> - table header -->
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
      </tr>

 <!-- emp - это временный параметр для использования в forEach лупе -->
      <c:forEach var="emp" items="${allEmps}">

<!-- Две стороки ниже это ссылка на id(не видимая на фронте), которая будет дальше использоваться внутри кнопки Update -->
      <c:url var="updateButton" value="/updateInfo">
         <c:param name ="empId" value="${emp.id}"/>
      </c:url>

      <c:url var="deleteButton" value="/deleteEmployee">
              <c:param name ="empId" value="${emp.id}"/>
            </c:url>

        <tr>
     <!-- <td> table data это ячейка в таблице -->

          <td>${emp.name}</td>
          <td>${emp.surname}</td>
          <td>${emp.department}</td>
          <td>${emp.salary}</td>
          <td>
                 <input type="button" value="Update"
                 onclick="window.location.href = '${updateButton}'"/>

                 <input type="button" value="Delete"
                  onclick="window.location.href = '${deleteButton}'"/>

          </td>

        </tr>
      </c:forEach>

    </table>
    <br>
    <input type ="button" value ="Add"
    onclick = "window.location.href = 'addNewEmployee'"/>

  </body>
</html>
