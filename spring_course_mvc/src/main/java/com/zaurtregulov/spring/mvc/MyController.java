package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//ComponentScan в данном случае прописан в applicationContext.xml
@Controller // @Controller содержит @Component, поэтому указывать его не нужно,а достаточно использовать @Controller
//@RequestMapping("/employee") // указывает, что /employee будет добавляться в начало каждого метода. но это просто можно сделать в настройках урла Томката
public class MyController {
    // !!! вывод данных напрямую из формы
    @RequestMapping("/") // в урле при встрече "/" будет вызываться метод ниже
    public String showFirstView() {
        return "first-view";

    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }

    //=============================================================================
// Простой вывод из формы, вводимого в форму имени. Можно обойтись без контейнера Model
//        @RequestMapping("/showDetails")
//    public String showEmpDetails() {
//        return "show-emp-details-view";
//    }
//    ============================================================================
//    Ниже использование так называемого контейнера Model для хранения любых данных, вводимых во view и дальнейшего вывода этих данных
//     вывод дынных через HttpServletRequest request, метод getParameter и model.addAttribute
//    @RequestMapping("/showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model) {
////        В этом методе мы добавляем к вводимому пользователем имени приставку Mr. и добавлем это изменённое имя в качестве атрибута в Model
////        А затем выводим во view
//
//        String empName = request.getParameter("employeeName"); //employeeName это название поля name, которое вернется из ask-emp-details-view
//        empName = "Mr. " + empName;
////        Название атрибута(любое наше название) nameAttribute, empName - значение атрибута.
//        model.addAttribute("nameAttribute", empName); //  Добавь в модель empName и выведи его в ask-emp-details-view через атрибут nameAttribute
//// можно добавить еще данные к имени и потом в show-emp-details-view указать ${description}
//        model.addAttribute("description", " - udemy instructor");// вторым параметром можно добавлять любой объект - не только стринг
//
//        return "show-emp-details-view";
//    }
////    =================================================================
//     вывод данных через @RequestParam("указание name из ask-emp-details-view ") и конкантенации
    @RequestMapping("/showDetails")
    public String showEmpDetails(@RequestParam("employeeName") String empName,
                                 Model model) {
// @RequestParam("employeeName") позволяет брать данные из name из ask-emp-details-view без request.getParameter("employeeName")
// соответственно код стал меньше на одну строку
        empName = "Mr. " + empName + " - udemy instructor";
        // атрибут который добавляли в методе выше через addAttribute можно добавить просто конкантенацией в строке выше
        model.addAttribute("nameAttribute", empName); // добавь название атрибута nameAttribute (в ask-emp-details-view) к empName

        return "show-emp-details-view";
    }


}
