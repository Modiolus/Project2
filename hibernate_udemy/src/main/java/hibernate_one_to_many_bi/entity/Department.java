package hibernate_one_to_many_bi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department {
    // геттеры  сеттеры создаются через ломбок
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

    @OneToMany(mappedBy = "department" //здесь в кавычках пишется ссылка на объект private Department department, которую мы создали в в классе Employee
            ,cascade = CascadeType.ALL
    ,fetch = FetchType.LAZY
    )
//     В БД таблица департамента ссылается на таблицу с многими работниками. При загрузке департамента нам не всегда нужны все работники
//     Поэтому существует EAGER и LAZY загрузка, чтобы ускорить работу программы
//     EAGER - при получении департамента мы получим сразу всех его работников. Будет всего один select к департаменту и вместе с департаментом выведутся все работниики
//     LAZY - сначала будет получен департамент без работников, а затем hibernate сделает новый select(т.к. мф сделали в мэйне запрос department.getEmps()) и будут получены работники
    //    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH
//            , CascadeType.REFRESH, CascadeType.MERGE}) // необходимо, чтобы не удалилось всё  при удалении работника в мэйне
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
        employee.setDepartment(this); // когда мы в мэйн на объекте(определённом департаменте) класса Department
        // будем вызывать метод addEmployeeToDepartment, то он будет добавлять работнику этот департамент
        // Таким образом реализуется обратная двустороння(bidirectional) связь таблицы departments и employees

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
