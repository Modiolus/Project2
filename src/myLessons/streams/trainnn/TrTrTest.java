package myLessons.streams.trainnn;

import myLessons.lambda.predicate.Student2;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TrTrTest {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        int result = Arrays.stream(array)
                .filter(e -> e % 2 == 1)
                .map(e -> {
                    if (e % 3 == 0) {
                        e = e / 3;
                    }
                    return e;
                })
                .reduce((a, e) -> a + e)
                .getAsInt();
        System.out.println(result);
//===============================================================
        List<String> list = new ArrayList<>();

        list.add("Samsung");
        list.add("Acer");
        list.add("Dell");
        list.add("Apple");
        // подсчёт общей суммы длин всех элементов коллекции
        int res = 0;
        for (String s : list) {
            res += s.length();

        }
        System.out.println(res);

        int sum = list.stream().mapToInt(String::length).sum();

        System.out.println("Stream-->\n" + sum);
//==============================================================
        //подсчёт суммы элементо коллекции Integer
        List <Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(3);
        integerList.add(4);
        integerList.add(6);

        int sum1 = integerList.stream().mapToInt(a->a).sum();

        System.out.println("Sum int:-> "+sum1);
//==============================================================
        String strin = list.stream().reduce(String.valueOf(list.indexOf(1)), (q, w) -> q + w);
        System.out.println(strin);

        String str = list.stream().reduce((a, b) -> a + b).toString();
        System.out.println(Arrays.toString(str.toCharArray()));
        System.out.println(str);

        System.out.println(str.length());
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

        Student2 min = students.stream().min((x, y) -> x.course - y.course).get();
        Student2 max = students.stream().max(Comparator.comparing(y -> y.course)).get();
        Student2 student2 = students.stream().min(Comparator.comparing(s -> s.name)).get();

        List<Student2> l = students.stream().filter(c -> c.age < 22).limit(3).collect(Collectors.toList());
        List<Student2> l1 = students.stream().filter(d -> d.age < 25).collect(Collectors.toList());
        List<Student2> l2 = students.stream().filter(d -> d.age < 25).skip(2).collect(Collectors.toList());
        System.out.println("l--> \n" + l);
        System.out.println("l1--> \n" + l1);
        System.out.println("l2--> \n" + l2);

        System.out.println("==================================================================");
        System.out.println(min);
        System.out.println(max);
        System.out.println(student2);

    }
}
