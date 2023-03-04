package com.zaurtregulov.spring.mvc_hibernate_aop.myController;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;
import com.zaurtregulov.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired // данные две строки заменяют создание объекта EmployeeDAOImpl в методе ниже
//    private EmployeeDAO employeeDAO;
    private EmployeeService employeeService; // эта строка нужна вместо строки выше при использовании класса EmployeeServiceImpl реализуещего интерфэйс EmployeeService

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/"; // перенаправление на слэш /
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id
            , Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {

        employeeService.deleteEmployee(id);

        return "redirect:/";

    }

}

