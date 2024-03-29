package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/spring_course_rest/api/employees";

    public List<Employee> getAllEmployees() {

        ResponseEntity<List<Employee>> responseEntity =  // ResponseEntity это будет ответом на http запрос
                restTemplate.exchange(URL, HttpMethod.GET, null  // третий параметр это тело которое хотим добавить в реквесту. В данном сучае ниего не добавляем поэтому null
                        , new ParameterizedTypeReference<List<Employee>>() {  // ParameterizedTypeReference класс для передачи дженерик типа
                        });
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id
                , Employee.class);
        return employee;
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity = // String - то что будет в теле респонса
                    restTemplate.postForEntity(URL, employee, String.class); // employee то что мы добавляем в тело метода пост

            System.out.println("New employee was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID " + id + " was updated");
        }
    }

    public void deleteEmployee(int id) {

        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID " + id + " was deleted from DB");
    }

}
