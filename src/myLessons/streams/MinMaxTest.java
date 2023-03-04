package myLessons.streams;

import myLessons.lambda.predicate.Student2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMaxTest {
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
        Student2 min = students.stream().min((x, y) -> x.age - y.age).get();
        //   Student2 min1= students.stream().min(Comparator.comparingInt(x -> x.age)).get();//второй вариант
        System.out.println(min);
        Student2 max = students.stream().max((x, y) -> x.age - y.age).get();
        System.out.println(max);

        int[] numbers = {2, 1, 9, 4, 3, 10};
        int a = Arrays.stream(numbers).min().getAsInt();
        System.out.println(a);
    }
}
