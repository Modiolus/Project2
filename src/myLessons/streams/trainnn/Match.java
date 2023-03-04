package myLessons.streams.trainnn;

import myLessons.lambda.predicate.Student2;

import java.util.ArrayList;
import java.util.List;

public class Match {
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

        boolean all = students.stream().allMatch(a -> a.course > 1); //allMatch - все ли соответствуют условиям
        boolean any = students.stream().anyMatch(w -> w.course == 4); //anyMatch - кто-либо ли соответствует условиям
        boolean non = students.stream().noneMatch(r -> r.name.equals("Petr"));// non - нието не сооотв условиям

        System.out.println(all);
        System.out.println(any);
        System.out.println(non);
    }
}
