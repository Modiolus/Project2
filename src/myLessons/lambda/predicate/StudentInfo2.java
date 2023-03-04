package myLessons.lambda.predicate;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentInfo2 {
    void testStudents(ArrayList<Student2> a1, Predicate<Student2> pr) { //Predicate<Student2> pr
        for (Student2 s : a1) {
            if (pr.test(s)) {
                System.out.println(s);
            }
        }
    }

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

class TestMain2 {


    public static void main(String[] args) {
        Student2 st1 = new Student2("Ivan", 'm', 22, 3, 8.3);
        Student2 st2 = new Student2("Nikolay", 'm', 28, 2, 6.4);
        Student2 st3 = new Student2("Elena", 'f', 19, 1, 8.9);
        Student2 st4 = new Student2("Petr", 'm', 35, 4, 7);
        Student2 st5 = new Student2("Mariya", 'f', 23, 3, 9.1);

        ArrayList<Student2> students2 = new ArrayList<>();
        students2.add(st1);
        students2.add(st2);
        students2.add(st3);
        students2.add(st4);
        students2.add(st5);


        //======================================================
        // /*пример на stream метод sorted из темы СТРИМОВ!!!*/
        students2 = (ArrayList<Student2>) students2 //(ArrayList<Student2>) кастит list в arraylist
                .stream()
                .sorted((x, y) -> x.name.compareTo(y.name))// система предлагает заменить на более короткий Comparator.comparing(x -> x.name)
                // compareTo - здесь это метод String(a)
                .collect(Collectors.toList());
        System.out.println("Stream sorted: \n" + students2);
        students2.stream().sorted(Comparator.comparing(x -> x.name)).collect(Collectors.toList());
        //======================================================
        System.out.println("Задача из темы стримов chainingTest методы========================");
        /*задача вывести с имена с большой буквы, отфильтровать их по женскому полу и отсортировать по возрасту
         * задача из урока метод chaining*/

        System.out.println("Task: ");

        List<Student2> students3 = students2.stream()
                .map(e -> {
//                    e.name.toUpperCase(); // !! Важно: так не будет увеличения букв. Нужно желать код ниже через сеттеры и геттеры
//                    return e;
                    e.setName(e.getName().toUpperCase());
                    return e;
                })
                .filter(el -> el.sex == 'f')
                .sorted(Comparator.comparing(x -> x.age)) // прямая сортировка по возрасту
//                .sorted((f1, f2)-> Long.compare(f2.age, f1.age)) // обратная сортировка по возрасту
                .sorted(Comparator.comparing(Student2::getName)) // прямая сортировка по имени
//                .sorted(Comparator.comparing(Student2::getName).reversed()) // обратная сортировка по имени

                // .forEach(System.out::println);
                .collect(Collectors.toList());
        System.out.println(students3);
        System.out.println("===========================================");

        StudentInfo2 info = new StudentInfo2();
        //  StudentChecks std = d -> d.avdGrade < 7.5;
        //   info.testStudents(students2, std);
// ниже объяснение предиката с целью фильтрации по параметрам
        Predicate<Student2> p1 = student1 -> student1.avdGrade > 7.5; // предыдущая строка, только через Predicate и лямбду
        Predicate<Student2> p2 = student2 -> student2.sex == 'm';
        System.out.println("p2->>");
        info.testStudents(students2, p2);// выведет только m - соответственно условию выше


        System.out.println("=======================================");
        info.testStudents(students2, p1.and(p2)); // оба условия
        info.testStudents(students2, p1.or(p2)); // или, или
        info.testStudents(students2, p1.negate()); // значение обратное p1

//        info.testStudents(students2, new CheckOverGrade());
//        System.out.println("==================================================================");
//        //создаём анонимный класс
//        info.testStudents(students2, new StudentChecks() {
//            @Override
//            public boolean check(Student s) {
//                return s.age<30;
//            }
//        });
        System.out.println("===================================================================");
        info.testStudents(students2, s -> s.age < 30); // (Student s) ->{return s.age<30;} это тоже самое длинее
        info.testStudents(students2, (Student2 s) -> s.avdGrade < 8.3);
        info.testStudents(students2, s -> s.avdGrade > 8 && s.sex == 'f' && s.age < 30);

//        info.printStudentsOverGrade(students2, 8);
//        System.out.println("================================================================");
//        info.printStudentsUnderAge(students2, 30);
//        System.out.println("================================================================");
//        info.printStudentsMixConditions(students2, 20, 9.5, 'f');


        Collections.sort(students2, (stud1, stud2) -> stud1.course - st2.course);


    }
}

/* вместо интерфейса StudentChecks2 с методом boolean check(Student2 s)
 *  так просто быстрее, не нужно создавать свой интерфейс
 * используем Predicate<Student2> pr от метода boolean test(T t) интерфейса Predicate */

//interface StudentChecks2<T> {// это функциональный интерфейс - т.е. содержит тоько один абстрактный метод - метод без реализации
//
//    boolean check(T s);
//}
//
//class CheckOverGrade implements StudentChecks2 {
//
//    @Override
//    public boolean check(Student2 s) {
//        return s.avdGrade > 8;
//    }
//}

