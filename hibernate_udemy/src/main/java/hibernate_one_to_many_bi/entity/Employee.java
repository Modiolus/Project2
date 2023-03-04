package hibernate_one_to_many_bi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
    // геттеры  сеттеры создаются через ломбок
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "surname")
    private String surName;

    @Column
    private int salary;

    // @ManyToOne потому что много работников может работать в одном отделе
        @ManyToOne(cascade = CascadeType.ALL)
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH
//            , CascadeType.REFRESH, CascadeType.MERGE}) // необходимо, чтобы не удалилось все при удалении в мэйне работника
    @JoinColumn(name = "department_id")  //@JoinColumn это ВСЕГДА foreign key ссылается на primary key в таблице departments
    private Department department;

    public Employee() {

    }

    public Employee(String firstName, String surName, int salary) {
        this.firstName = firstName;
        this.surName = surName;
        this.salary = salary;
    }
    public Employee(String firstName, String surName, int salary, Department department) {
        this.firstName = firstName;
        this.surName = surName;
        this.salary = salary;
        this.department = department;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", surName='" + surName + '\'' +
//                ", salary=" + salary +
//                '}';
//    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
