package myLessons.streams;

import myLessons.lambda.predicate.Student2;

import java.util.*;
import java.util.stream.Collectors;

public class FindFirst {
    public static void main(String[] args) {
        Student2 st1 = new Student2("Ivan", 'm', 22, 3, 8.3);
        Student2 st2 = new Student2("Nikolay", 'm', 28, 2, 6.4);
        Student2 st3 = new Student2("Elena", 'f', 19, 1, 8.9);
        Student2 st4 = new Student2("Petr", 'm', 35, 4, 7);
        Student2 st5 = new Student2("Mariya", 'f', 23, 3, 7.4);

        List<Student2> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        Student2 firstPerson = students.stream().findFirst().get();
        System.out.println("First from original:-> \n " + firstPerson);

        // выводит всех по описанным условиям
        System.out.println("Everyone on conditions:-> ");
        //========================================================================
        // TODO: 09.10.2021 тренировался выводить по разным критериям
        System.out.println("TEST-->>");
        Student2 s = students.stream().max((e, r) -> e.age - r.age).get();
        System.out.println("s ->> " + s);
        Student2 stud = students.stream().max(Comparator.comparing(a -> a.age)).get();
        Optional<Student2> maxAge = Optional.ofNullable(students.stream().max((e, r) -> e.age - r.age)).get();
        maxAge.ifPresent(System.out::println); // правильный вывод optional
        maxAge.ifPresentOrElse(w -> { // вывод optional или вывод если null
            System.out.println(w);
        }, () -> System.out.println("Нет такого значения")); // здесь после запятой - выражение OrElse

        students.stream().sorted(Comparator.comparing(q -> q.course)).collect(Collectors.toList());

        // System.out.println(s);
        System.out.println("=========================================================");
        //=============================================================================================
        students.stream().map(el -> {
                    el.name.toUpperCase();
                    return el;
                })
                .filter(el -> el.sex == 'f')
                .forEach(System.out::println);

        // выводит из отфильтрованных по условиям только первого

        Student2 firstStudent = students.stream().map(el -> {
                    el.name.toUpperCase();
                    return el;
                })
                .filter(el -> el.sex == 'f')
                // .forEach(System.out::println);
                .findFirst().get(); // можно вместо get() вначале Student2 обернуть в Optional
        System.out.println("First from everyone on conditions:-> \n " + firstStudent);

    }
}
