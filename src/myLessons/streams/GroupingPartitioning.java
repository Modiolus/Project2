package myLessons.streams;

import hillel.lesson4.Student;
import myLessons.lambda.predicate.Student2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingPartitioning {

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

        Student2 first = students.stream().findFirst().get();

        System.out.println("First person: " + first);

        /*groupingBy группируем по курсу на несколько коллекций
         * !!! в таком случае возвращается Map !!!!
         * получается, что группинг похож на сортинг, но не требует компаратора*/
        Map<Integer, List<Student2>> map1 = students.stream()
                .map(el -> {
                    el.name.toUpperCase();
                    return el;
                })
                .collect(Collectors.groupingBy(el -> el.course));
//          System.out.println(map1);
        System.out.println("Вывод мапы через entry-->> ");
        for (Map.Entry<Integer, List<Student2>> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        System.out.println("Out of map==============================================");
        map1.forEach((e, r) -> System.out.println(e + "; " + r)); // вывод через лямбду
        System.out.println("вывод через лямбду");
        map1.forEach((Integer, students1) -> {
            System.out.print(Integer);
            students1.forEach(System.out::println);// можно и так System.out.println(students1)
        });
        System.out.println("Out of map==============================================");
        //===========================================================================

        /*partitioningBy разделяем на две коллекции  с оценками больше и меньше 7 соответственно*/
        Map<Boolean, List<Student2>> map2 =
                students.stream()
                        .collect(Collectors.partitioningBy(el -> el.avdGrade > 7));

        for (Map.Entry<Boolean, List<Student2>> entry : map2.entrySet()) {
            System.out.println(entry);
        }

    }
}
