package myLessons.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch2 {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(8);
        arrayList.add(12);
        arrayList.add(-8);
        arrayList.add(0);
        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(1);
        arrayList.add(150);
        arrayList.add(-30);
        arrayList.add(19);

        Collections.sort(arrayList);
        int index1 = Collections.binarySearch(arrayList, 12);
        System.out.println(arrayList);
        System.out.println(index1);
//=======================================================================
        Employee employee1 = new Employee(12, "Igor", "Egorov", 4323);
        Employee employee2 = new Employee(8, "Vasiliy", "Safronov", 5423);
        Employee employee3 = new Employee(10, "Igor", "Alforov", 6723);
        Employee employee4 = new Employee(35, "Maksim", "Regulov", 3421);

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);

        Collections.sort(list);
        System.out.println(list);

        int index2 = Collections.binarySearch(list, employee2);
        System.out.println(index2);

    }
}

class Employee implements Comparable<Employee> {

    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee anotherEmp) {
        int res = this.name.compareTo(anotherEmp.name);

        if (res == 0) {
            res = this.surname.compareTo(anotherEmp.surname);
        }
        return res;
    }
}
