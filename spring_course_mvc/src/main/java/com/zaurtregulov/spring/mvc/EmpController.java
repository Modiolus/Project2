package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee") // /employee нужно добавить в адресной строке к стандартному урл
public class EmpController {

    @RequestMapping("/") // в урле при встрече "/" будет вызываться метод ниже
    public String showFirstView() {
        return "first-view";

    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) { // Model в параметрах позволяет добавлять в модель атрибут
        model.addAttribute("employee", new Employee()); // добавляем в атрибут и затем в форму целый обект Employee(с соответствующими полями)

        return "ask-emp-details-view";

    }

    @RequestMapping("/showDetails")
//    @ModelAttribute - дает доступ к конкретному атрибуту модели потом вызываются в show-emp-details-view
    public String showEmpDetail(
            @ModelAttribute("employee") Employee emp) {
        String name = emp.getName();
        emp.setName("Mr. " + name);

        String surName = emp.getSurName();
        emp.setSurName(surName + " !");

        int salary = emp.getSalary();
        emp.setSalary(salary * 10);

        return "show-emp-details-view";
    }

    //===================================================================================================================
//    ниже метод showEmpDetail изменённый для примера валидации строк в форме
//    @RequestMapping("/showDetails")
////    @ModelAttribute - дает доступ к конкретному атрибуту модели потом вызываются в show-emp-details-view
////    @Valid - говорит о том что форма employee будет подвергаться валидации
////   BindingResult - сюда будет помещён результат валидации employee
//    public String showEmpDetail(@Valid @ModelAttribute("employee") Employee emp
//            , BindingResult bindingResult) {
//
////        если валидация не прошла hasErrors то НЕ вызывется форма show-emp-details-view
//        if (bindingResult.hasErrors()) {
//            return "ask-emp-details-view";
//        } else {
//            return "show-emp-details-view";
//        }
//
//    }


}
