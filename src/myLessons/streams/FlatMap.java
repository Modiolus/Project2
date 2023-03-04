package myLessons.streams;

import myLessons.lambda.predicate.Student2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        Student2 st1 = new Student2("Ivan", 'm', 22, 3, 8.3);
        Student2 st2 = new Student2("Nikolay", 'm', 28, 2, 6.4);
        Student2 st3 = new Student2("Elena", 'f', 19, 1, 8.9);
        Student2 st4 = new Student2("Petr", 'm', 35, 4, 7);
        Student2 st5 = new Student2("Mariya", 'f', 23, 3, 7.4);

        Faculty f1 = new Faculty("Economics");
        Faculty f2 = new Faculty("Applied mathematics");
        f1.addStudentToFaculty(st1);
        f1.addStudentToFaculty(st2);
        f1.addStudentToFaculty(st3);
        f2.addStudentToFaculty(st4);
        f2.addStudentToFaculty(st5);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);
        System.out.println("Total facultyList-->\n"+facultyList);
        /*flatMap используется когда нужно поработать не с самими элементами
         * а с элементами элементов коллекции*/
        System.out.println("===================================");
        facultyList.stream()
                .flatMap(faculty -> faculty.getStudentsOnFaculty() // получаем лист студентов определенного факультета
                        .stream())
                .forEach(e -> System.out.println(e.name)); // выводим имена всех студентов
        System.out.println("===================================");
        facultyList.stream()
                .map(faculty -> faculty.getStudentsOnFaculty())
                .forEach(System.out::println);

//        ArrayList<Student2> student2List = (ArrayList<Student2>) f1.addStudentToList(st1, st2, st3, st4, st5);
//        ArrayList<Student2> superList = new ArrayList<>();
//        superList.addAll(student2List);
//        student2List.stream().flatMap(Faculty::getStudentsOnFaculty).forEach();

    }
}

class Faculty {
    String name;
    List<Student2> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        studentsOnFaculty = new ArrayList<>();
    }

    public List<Student2> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }

    public void addStudentToFaculty(Student2 st) {
        studentsOnFaculty.add(st);
    }

//    public List<Student2> addStudentToList(Student2 st1, Student2 st2, Student2 st3, Student2 st4, Student2 st5) {
//        ArrayList<Student2> studList = (ArrayList<Student2>) List.of(st1, st2, st3, st4, st5);
//        return studList;
//    }

    @Override
    public String toString() {
        return "Faculty {" +
                "name='" + name + '\'' +
                ", studentsOnFaculty=" + studentsOnFaculty +
                '}';
    }
}
