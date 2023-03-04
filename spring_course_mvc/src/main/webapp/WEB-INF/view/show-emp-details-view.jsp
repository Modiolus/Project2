<!-- taglib нужен для того что сработал forEach луп при выводе элементов массива при еализации кнопок check box-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

  <body>
  <!-- =========Для MyController==========  -->
    <h2>Dear, Employee, you are WELCOME!</h2>
    <br />
    <br />
    <br />
    <!-- employeeName ссылается на введенное пользователем имя в ask-emp-details-view и выводит его после Your name: -->

   Your name: ${param.employeeName}

  <!-- Выведи атрибут с названием nameAttribute который прописан в методе showEmpDetails (с HttpServletRequest в параметрах)
   По сути на данном этапе вывел из view-->

 <!--  Your name: ${nameAttribute} ${description}  -->

   <!-- =========== Ниже Для EmpController ========= -->
   <!-- =========== Форма input========= -->
   <h2>Dear, Employee, you are WELCOME!</h2>
       <br />
       <br />
       <br />
       <!-- employeeName ссылается на соответствующий name в ask-emp-details-view и выводит его после Your name: -->

     <!-- Выведи атрибуты с полями класса Employee
      По сути на данном этапе выводит из view-->

   <!-- Для каждого поля будет срабатывать геттер
   employee должен совпадать параметром "employee" в методе showEmpDetail -->

      Your name: ${employee.name}
      <br />
      Your surname: ${employee.surName}
      <br />
       Your salary: ${employee.salary}  грн.
       <br />

       <!-- =========== Форма select - выпадающий список ========= -->
       Your department: ${employee.department}
        <br />

        <!-- =========== Форма radiobutton - переключатель.========= -->
        Your car: ${employee.carBrand}
          <br />

          <!-- =========== Форма check box - флажок. ========= -->

          Language(s):
        <!-- <ul> или unordered list - это  неотсортированный лист -->
          <ul>
 <!-- c(си) берется из самой первой верхней строки prefix="c"-->

          <c:forEach var ="lang" items = "${employee.languages}">
           <!-- <li> это list item-->
                <li> ${lang}
          </li>

          </c:forEach>
          </ul>

       Phone number: ${employee.phoneNumber}
       <br />
       Email : ${employee.email}





  </body>
</html>
