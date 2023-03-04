package myLessons.comparable;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    /*чтобы произвести сортировку небходимо джаве показать по какому критерию/параметру сравнивать объекты
    * т.к. джава не понимает что такое Employee
    * для этого имплементируем интерфейс Comparable указываем тип <Employee> и переопределяеам метод compareTo
    * после этого вызвав Collections.sort(list) коллеция будет отсортировна автоматически по заданному критерию в
    * compare Инанче не переопределив compareTo вызов sort вызовет ошибку
    *  */
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Zaur", "Tregulov", 12345);
        Employee emp2 = new Employee(15, "Ivan", "Sidorov", 6542);
        Employee emp3 = new Employee(123, "Ivan", "Petrov", 8542);
        //    Arrays.sort(list.toArray()); // не сортирует

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("Before sorting \n" + list);
        Collections.sort(list);

        System.out.println("After sorting \n" + list);


    }
}
// Comparable используется для сравнения обектов, используя естественный порядок(алфавит, порядо цифр и т.д.)
// просто укаав в compareTo по какому критерию нужно сравнивать объекты
class Employee
        implements Comparable<Employee>
         {
    Integer id;
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
    public int compareTo(Employee anotherEmp) { // сравнивает текущий объкт с объектом в параметре метода
//        if (this.id == anotherEmp.id) {
//            return 0;
//        } else if (this.id < anotherEmp.id) {
//            return -1;
//        } else {
//            return 1;
//        }
           return this.id - anotherEmp.id; // второй способ - вернет соотв число. ДЛя сортировки по id
//      ниже для сравнения по имени или фамилии
        //   return this.id.compareTo(anotherEmp.id); // compareTo метод написанный в обёрточных классах(String, Integer etc). Тогда поле id нужно назвать Integer
        //   return this.name.compareTo(anotherEmp.name); // сортировка по имени

        /*вариант в случае, если имена одинаковые, то сравнивает по фамилиям*/

//        int res = this.name.compareTo(anotherEmp.name);
//    //    int res = this.id - anotherEmp.id;
//        if (res == 0) {
//            res = this.surname.compareTo(anotherEmp.surname);
//        }
//        return res;
    }
}

