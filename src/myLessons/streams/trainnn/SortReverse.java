package myLessons.streams.trainnn;


import myLessons.lambda.predicate.Student2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortReverse {
    public static void main(String[] args) {
        Worker st1 = new Worker("Ivan", 'm', 22, 3, 8.3);
        Worker st2 = new Worker("Nikolay", 'm', 28, 2, 6.4);
        Worker st3 = new Worker("Elena", 'f', 19, 1, 8.9);
        Worker st4 = new Worker("Petr", 'm', 35, 4, 7);
        Worker st5 = new Worker("Mariya", 'f', 23, 3, 7.4);

        List<Worker> worker1 = new ArrayList<>();
        worker1.add(st1);
        worker1.add(st2);
        worker1.add(st3);
        worker1.add(st4);
        worker1.add(st5);
        double d = worker1.stream().mapToDouble(e -> e.avdGrade).sum();
        System.out.println("Sum of avdGrade \n->> " + d);// вывод суммы любого показателя
        System.out.println("TEST");
        worker1.stream().mapToInt(e -> e.name.length()).forEach(System.out::println); // длина всех имен по отдельности
        int sumLengthName = worker1.stream().mapToInt(e -> e.name.length()).sum();
        System.out.println("Total sum of length names -> " + sumLengthName);

        worker1.forEach(System.out::println); // просто вывод коллекции на экран
// без создания геттера по age обратная сртировака отказывалась работать
        // фильтруем и сортируем в обратном порядке
        List<Worker> worker2 = worker1.stream().filter(q -> q.age <= 23)
                .sorted(Comparator.comparingInt(Worker::getAge)) // x->x.age можно и так
                .collect(Collectors.toList());

        List<Worker> worker3 = worker1.stream().filter(q -> q.age <= 23)
                .sorted(Comparator.comparingInt(Worker::getAge).reversed())
                .collect(Collectors.toList());
        // два способа выше и ниже - результат одинаковый
        Comparator<Worker> comparator = Comparator.comparingInt(Worker::getAge).reversed();
        worker1.sort(comparator);

        System.out.println("filter and avers: \n" + worker2);
        System.out.println("filter and revers: \n" + worker3);


        //сортировка более простой коллекции в прямом и обратном порядке
        List<String> list1 = new ArrayList<>();
        list1.add("Privet");
        list1.add("Kak dela?");
        list1.add("Ok");
        list1.add("Poka");

        Collections.sort(list1);
        Collections.reverse(list1);
        // сортировки стримами
        List<String> list2 = list1.stream().sorted(Comparator.comparing(String::toString)).collect(Collectors.toList());
        List<String> list3 = list1.stream().sorted(Comparator.comparing(String::toString).reversed()).collect(Collectors.toList());
        List<String> list4 = list1.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        List<String> list5 = list1.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        System.out.println("Сортитровка по алфавиту аверс \n" + list2);
        System.out.println("Сортитровка по алфавиту реверс \n" + list3);
        System.out.println("Сортировака по длине элемента аверс \n" + list4);
        System.out.println("Сортировака по длине элемента реверс \n" + list5);

    }

}

class Worker {
    String name;
    char sex;
    int age;
    int course;
    double avdGrade;

    public Worker(String name, char sex, int age, int course, double avdGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avdGrade = avdGrade;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student {" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avdGrade=" + avdGrade +
                '}';
    }
}
