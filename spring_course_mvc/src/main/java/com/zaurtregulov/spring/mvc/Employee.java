package com.zaurtregulov.spring.mvc;

import com.zaurtregulov.spring.mvc.validation.CheckEmail;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

// Этот класс в данном пакете относится только к контроллеру EmpController
public class Employee {
    //    @Size валидирует на предмет размера вводимых данных и пишется над тем полем которое будем валидировать
    @Size(min = 2, message = "name must be min 2 symbols!") // здесь можно писать и max количество символов
    private String name;

    //  @NotNull(message = "surname is required field") // делает поле обязательным для заполнения и делает стринг не null, а пустым стрингом
//  @NotEmpty - делает так чтобы поле было и не null и не пустым стрингом
//  @NotEmpty(message = "surname is required field") // Но есть проблема - можно вместо символов внести пробелы и всё сработает ОК
    @NotBlank(message = "surname is required field") // тоже, что @NotEmpty, НЕ даёт ввести пробелы
    private String surName;

    @Min(value = 500, message = "must be more than 499")
    // показывает, что число не должно быть меньше или равно указанного value
    @Max(value = 1000, message = "must be less than 1001") // показывает, что число должно быть меньше или равно value
    private int salary;

    private String department;

 //    используем Мар во втором способе для более короткого кода в ask-emp-details-view и вводим данные в теле конструктора
//    обязательно создаем геттеры и сеттеры для поля и коллекции
    private Map<String, String> departments;

    private String carBrand;
    //    используем Мар во втором способе для более короткого кода в ask-emp-details-view и вводим данные в теле конструктора
    //    обязательно создаем геттеры и сеттеры для поля и коллекции

    private Map<String, String> carBrands;

    @Size(min = 1, message = "have to least one language select") // минимум выбор одного языка должен быть сделан
    private String[] languages;
    private Map<String, String> languageList;
//    По языку - как мимнимум нужно делать лист, а ен просто поле т.к. чек бокс или флажок подразумвает выбор нескольких данных
//    А еще лучше мапу, чтобы в ask-emp-details  сделать код одной строкой

    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "please use pattern XXX-XX-XX")
    // regexp - это регулярное выражение
    private String phoneNumber;

    //    ниже своя созданная аннотация. Смотри пакет validation
    @CheckEmail(value = "abc.com", message = "email must ends with abc.com") // данные которые затрут дефолтные, описанные в @interface CheckEmail
//    @Email // стандартная аннотация, которая проверяет что это именно email
    private String email;

    public Employee() {
        departments = new HashMap<>();
        departments.put("Information Technology", "IT");
        departments.put("Human Resources", "HR");
        departments.put("Sales", "Sales");

        carBrands = new HashMap<>();
        carBrands.put("BMW", "BMW");
        carBrands.put("Audi", "Audi");
        carBrands.put("Mercedes-Benz", "MB");

        languageList = new HashMap<>();
        languageList.put("English", "EN");
        languageList.put("Deutch", "DE");
        languageList.put("French", "FR");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Map<String, String> languageList) {
        this.languageList = languageList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
