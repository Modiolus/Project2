package com.zaurtregulov.spring.rest.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees2")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // информацию в скобках можно не указывать т.к. перемненная и столбец имеют одинаковое название
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String department;
    @Column
    private int salary;

    public Employee() {
    }

    public Employee(int id, String name, String surname, String department, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
