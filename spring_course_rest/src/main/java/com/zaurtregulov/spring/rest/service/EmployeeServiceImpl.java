package com.zaurtregulov.spring.rest.service;

import com.zaurtregulov.spring.rest.dao.EmployeeDAO;
import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // эта аннотация отмечает класс содержащий бизнес логику. В иерархии приложения
// @Service является соединительным звеном между Controller-ом и DAO
// @Service - это специальзированный @Component. При поиске компонентов Spring также будет регистрировать все классы
// с аннотацей @Service в спринг КОНТЕЙНЕРЕ
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired // создает объект класса EmployeeDAO
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {

        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
