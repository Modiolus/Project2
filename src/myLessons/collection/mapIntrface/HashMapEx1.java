package myLessons.collection.mapIntrface;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapEx1 {
    public static void main(String[] args) {
        Map<StudentExa, Double> map = new HashMap<>();
        StudentExa st1 = new StudentExa("Zaur", "Tregulov", 3);
        StudentExa st2 = new StudentExa("OLeg", "Olegov", 4);
        StudentExa st3 = new StudentExa("Ivan", "Ivanov", 2);
        StudentExa st4 = new StudentExa("Olga", "Petrova", 1);
        map.put(st1, 3.4);
        map.put(st2, 2.3);
        map.put(st3, 3.5);
        map.put(st4, 4.3);

        System.out.println("Map: \n"+map);
        for (Double values : map.values()) {
            System.out.println(values);
        }
        System.out.println("map.entrySet()");
        System.out.println(map.entrySet());
        System.out.println();

        System.out.println("Map.Entry->");
        for (Map.Entry<StudentExa, Double> entry : map.entrySet()) {// entrySet() возвращает множество для map
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
        System.out.println("BiConsumer->");
        map.forEach((q, w) -> System.out.println(q + ":" + w)); // вывод лямбдой через интерфейс BiConsumer и метод accept

    }

}

class StudentEx {
    String name;
    String surname;
    int course;

    public StudentEx(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentExa student = (StudentExa) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

}
