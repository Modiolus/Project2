package hibernate.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity // выбирать из javax.persistence(предлагает идея)
@Table(name = "employees2") // если название таблицы в БД и название класса совпадают запись в скобках можно НЕ писать
// !! Глобально для лучшего понимания - класс это строки, а поля это столбцы
public class Employee {
//!!! Если название столбца и поля совпадают то название поля в скобках можно НЕ писать
    // а можно в таком случае(совпадения) просто писать для читабельности

    @Id // показывает, что поле id является(соотвествует) primary key в таблице БД
    @GeneratedValue(strategy = GenerationType.IDENTITY) // описывает стратегию по генерации значений столбца с primary key
   /*стратегия GenerationType.IDENTITY полагается на автоматическое увеличение столбца по правилам, прописанным в БД
   * GenerationType.SEQUENCE полагается на SEQUENCE созданного в БД. !!!НЕ ИСПОЛЬЗУЕТСЯ В MySql
   * GenerationType.TABLE !!!Это не эффективно и не используется. Полагается на значение столбца в БД. Цель такой таблицы - поддержка уникальности значений
   * в последней стратегии увеличение нужно прописыввать самому.
   * GenerationType.AUTO - дефолтный тип. Выбор стратегии будет зависеть от типа базы с которой мы работаем. Hibernate выберит стратегию автоматически*/
    @Column(name = "id") //название столбца
    private int id;

    @Column
    private String name;

    @Column
    private String surName;

    @Column
    private String department;

    @Column
    private int salary;

    public Employee(){

    }

//    в констуркторе с параметрами id не указываем т.к. он будет генерироваться в БД автоматически
    public Employee(String name, String surName, String department, int salary) {
        this.name = name;
        this.surName = surName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
