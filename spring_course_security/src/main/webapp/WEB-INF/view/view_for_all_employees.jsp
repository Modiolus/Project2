<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>Information for all employees</h3>
    <br>
    <br>
<%-- <security:authorize </security:authorize> скрывает копку Salary от всех кроме HR(того кто находся в access), которая находится внутри этих тегов --%>
<security:authorize access="hasRole('HR')">
<input type="button" value="Salary"
onclick="window.location.href = 'hr_info'">
Only for HR stuff
</security:authorize>
<br>
<br>

<security:authorize access="hasRole('MANAGER')">

<input type="button" value="Performance"
onclick="window.location.href = 'manager_info'">
Only for managers
</security:authorize>

</body>
</html>