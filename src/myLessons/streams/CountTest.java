package myLessons.streams;

import myLessons.lambda.predicate.Student2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CountTest {
    public static void main(String[] args) {
        /*count() подсчитывает количество элементов*/
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        System.out.println(stream1.count());

        Stream<String> stream2 = Stream.of("Ivanov", "Petrov", "Sidorov", "Ivanov");
        List<String> list = List.of("Ivanov", "Petrov", "Sidorov", "Ivanov");
        list.stream().count();

        System.out.println(stream2.count());
        long l =list.stream().distinct().count(); // подсчет уникальных элементов
        System.out.println(l);
//        =============================================================================================
        System.out.println("===========================================================");
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
        //подсчет элементов удовлетвряющим прописанным условиям
        long l2= students.stream().filter(r->r.course==3).count();
        System.out.println("Count-> "+l2);

    }
}
