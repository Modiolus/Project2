package com.zaurtregulov.spring.rest.controller;

import com.zaurtregulov.spring.rest.entity.Employee;
import com.zaurtregulov.spring.rest.exception_handling.EmployeeIncorrectData;
import com.zaurtregulov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.zaurtregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")  // формулировка в скобках /api это рекомендовано
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")   // получение всех работников
    public List<Employee> showAllEmployee() {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;

    }

    @GetMapping("/employees/{id}")  // получение работника по id
    public Employee getEmployee(@PathVariable int id) {  // @PathVariable используется чтобы читать переменную из url
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " in Database");
        }
        return employee;
    }

    @PostMapping("/employees")  // создание работника
    public Employee addNewEmployee(@RequestBody Employee employee) {  //тело json в запросе
        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees") //изменение работника
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        return employee;

    }

    @DeleteMapping("/employees/{id}")  // удаление работника
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = "
                    + id + " in Database");

        }
        employeeService.deleteEmployee(id);
        return "Employee with iD = " + id + " was deleted";

    }

}
