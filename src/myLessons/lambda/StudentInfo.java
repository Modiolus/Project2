package myLessons.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentInfo {
    void testStudents(ArrayList<Student> a1, StudentChecks sc) {
        for (Student s : a1) {
            if (sc.check(s)) {
                System.out.println(s);
            }
        }
    }
// методы фильтрации по определенному признаку можно не писать т.к. много писанины и т.д., а можно создать функциональный интерфейс и пойти через лямбды

//    void printStudentsOverGrade(ArrayList<Student> a1, double grade) {
//        for (Student s : a1) {
//            if (s.avdGrade > grade) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void printStudentsUnderAge(ArrayList<Student> a1, int age) {
//        for (Student s : a1) {
//            if (s.age < age) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void printStudentsMixConditions(ArrayList<Student> a1, int age, double grade, char sex) {
//        for (Student s : a1) {
//            if (s.age > age && s.avdGrade < grade && s.sex == sex) {
//                System.out.println(s);
//            }
//        }
//    }
}


class TestMain {

    public static void main(String[] args) {

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();

        StudentChecks std = d -> d.avdGrade < 7.5;
        info.testStudents(students, std);





//        info.testStudents(students, new CheckOverGrade());
//        System.out.println("==================================================================");
//        //создаём анонимный класс
//        info.testStudents(students, new StudentChecks() {
//            @Override
//            public boolean check(Student s) {
//                return s.age<30;
//            }
//        });
        System.out.println("===================================================================");
        info.testStudents(students, s -> s.age < 30); // (Student s) ->{return s.age<30;} это тоже самое длинее
        info.testStudents(students, (Student s) -> s.avdGrade < 8.3);
        info.testStudents(students, s -> s.avdGrade > 8 && s.sex == 'f' && s.age < 30);

//        info.printStudentsOverGrade(students, 8);
//        System.out.println("================================================================");
//        info.printStudentsUnderAge(students, 30);
//        System.out.println("================================================================");
//        info.printStudentsMixConditions(students, 20, 9.5, 'f');

        Collections.sort(students, (stud1, stud2) -> stud1.course - st2.course);
    }
}

interface StudentChecks {// это функциональный интерфейс - т.е. содержит только один абстрактный метод - метод без реализации

    boolean check(Student s);
}

class CheckOverGrade implements StudentChecks {

    @Override
    public boolean check(Student s) {
        return s.avdGrade > 8;
    }
}


