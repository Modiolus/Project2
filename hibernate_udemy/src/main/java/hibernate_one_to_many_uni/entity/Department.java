package hibernate_one_to_many_uni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    /*При использовании связи OneToMany в аннотации @JoinColumn name будет ссылаться
    на ForeignKey не из source, а из target таблицы. А Hibernate уже сам разберётся где именно находится ForeignKey,
    несмотрия на то что мы сейчас в классе который не имеет ForeignKey
    ForeignKey всегда будет находиться в таблице которая отвечает за many*/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private List<Employee> emps; // сделали сразу не просто ссылку на работника, а лист т.к. работников будет много

    public Department() {
    }

    public Department(String departmentName, int maxSalary, int minSalary) {
        this.departmentName = departmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public void addEmployeeToDepartment(Employee employee) {
        if (emps == null) {
            emps = new ArrayList<>();
        }
        emps.add(employee);
//        employee.setDepartment(this);
// это строка должны быть удалена т.к. работник не знает о свём департаменте(НЕТУ ССЫЛКИ НА ДЕПАРТАМЕНТ В КЛАССЕ Employee)

    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
