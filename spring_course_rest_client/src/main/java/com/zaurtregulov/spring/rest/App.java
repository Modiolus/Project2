package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.configuration.MyConfig;
import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
//ВНИМАНИЕ!! Перед запуском приложения нужно запустить tomcat с привязанным приложением spring_course_rest
//Т.к. мы из этого клиента и обращаемся к сервису который находится на сервере tomcat
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication"
                , Communication.class);
//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee empById = communication.getEmployee(1);
//        System.out.println(empById);

//        Employee emp = new Employee("Sveta", "Sokolova"
//                , "IT", 1200);
//        emp.setId(9); // данная строка пишется когда нужно внести изменения в уже существующего в работника БД
//        communication.saveEmployee(emp);

        communication.deleteEmployee(9);


    }
}
