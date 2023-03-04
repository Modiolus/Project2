package myLessons.streams;

import myLessons.lambda.predicate.Student2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MapToInt {
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
        /*mapToInt выводит интовые элементы в данном случае курс студентов*/
        List<Integer> courses =
                students.stream()
                        .mapToInt(e -> e.course)
                        .boxed()// т.к. mapToInt возвращает int то нужен boxed() который переведет int в Integer
                        .collect(Collectors.toList());

        System.out.println(courses);

        int sum = students.stream().mapToInt(e -> e.course).sum();// СУММА
        System.out.println(sum);

        double average = students.stream().mapToInt(e -> e.course).average().getAsDouble();
        System.out.println(average);
        int min = students.stream().mapToInt(e -> e.course).min().getAsInt();
        System.out.println(min);

        int max = students.stream().mapToInt(e -> e.course).max().getAsInt();
        System.out.println(max);
    }
}
