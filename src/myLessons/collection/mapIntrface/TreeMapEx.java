package myLessons.collection.mapIntrface;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) {
        TreeMap<StudentExa, Double> treeMap = new TreeMap<>();
        TreeMap<Double, StudentExa> treeMap2 = new TreeMap<>();
        StudentExa st1 = new StudentExa("Zaur", "Tregulov", 3);
        StudentExa st2 = new StudentExa("Mariya", "Ivanova", 1);
        StudentExa st3 = new StudentExa("Sergey", "Petrov", 4);
        StudentExa st4 = new StudentExa("Igor", "Sidorov", 2);
        StudentExa st5 = new StudentExa("Vasiliy", "Smirnov", 1);
        StudentExa st6 = new StudentExa("Sasha", "Kapustin", 3);
        StudentExa st7 = new StudentExa("Elena", "Sidorova", 4);
        treeMap2.put(7.9, st5);
        treeMap2.put(5.8, st1);
        treeMap2.put(7.5, st4);
        treeMap2.put(8.2, st6);
        treeMap2.put(6.4, st2);
        treeMap2.put(9.1, st7);
        treeMap2.put(7.2, st3);

        treeMap.put(st5, 7.9);
        treeMap.put(st1, 5.8);
        treeMap.put(st4, 7.5);
        treeMap.put(st6, 8.2);
        treeMap.put(st2, 6.4);
        treeMap.put(st7, 9.1);
        treeMap.put(st3, 7.2);

        System.out.println(treeMap);
        //  System.out.println(treeMap.get(st2));
        //      System.out.println(treeMap.descendingMap()); // сортирует в обратную сторону
//        System.out.println(treeMap.tailMap(7.5));// выводит всех с ключём больше 7.5
//        System.out.println(treeMap.tailMap(7.9, false)); //выводит всех с ключём больше 7.9 исключая 7.9
//        System.out.println(treeMap.headMap(6.4));// выводит всех с ключём меньше 6.4
//        System.out.println(treeMap.subMap(st2, st5)); //в диапазоне, исключая последний

//        System.out.println(treeMap.lastEntry()); // последний элемент
//        System.out.println(treeMap.firstEntry()); // первый элемент
//        System.out.println("EntrySet: " + treeMap.entrySet());
    }
}

class StudentExa implements Comparable<StudentExa> {
    String name;
    String surname;
    int course;

    public StudentExa(String name, String surname, int course) {
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

    @Override
    public int compareTo(StudentExa anotherStudent) {
        return this.name.compareTo(anotherStudent.name);
    }
}
