package hibernate_one_to_one.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @Column
    private String surName;

    @Column
    private String department;

    @Column
    private int salary;

    // между классом Employee и Detail будет OneToOne отношение
    @OneToOne(cascade = CascadeType.ALL) // удаление связанной записи в одной таблице приведет к удалению соответств записи в другой
    @JoinColumn(name = "details_id") // Employee соединяется с таблицей Detail через details_id - который явл внешним ключем
    private Detail empDetail; // ссылка empDetail будет использоваться для связи таблиц

    public Employee() {

    }

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
