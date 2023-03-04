package myLessons.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterTest {

    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        students = students.stream()
                .filter(element -> element.age > 22 && element.avdGrade < 7.2)
                .collect(Collectors.toList());
        System.out.println(students);


        /*ещё один вариант написания*/
//        List<Student> ls = List.of(st1, st1, st3, st4, st5);
//        Stream<Student> studentStream = Stream.of(st1, st1, st3, st4, st5);
//        studentStream.filter(element -> element.age > 22 && element.avdGrade < 7.2).collect(Collectors.toList());
//        System.out.println(ls);
    }
}

class Student {
    String name;
    char sex;
    int age;
    int course;
    double avdGrade;

    public Student(String name, char sex, int age, int course, double avdGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avdGrade = avdGrade;
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
