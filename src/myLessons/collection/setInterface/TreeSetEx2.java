package myLessons.collection.setInterface;

import java.util.TreeSet;

public class TreeSetEx2 {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();
        Student st1 = new Student("Zaur", 5);
        Student st2 = new Student("Misha", 1);
        Student st3 = new Student("Igor", 2);
        Student st4 = new Student("Marina", 3);
        Student st5 = new Student("Olya", 4);

        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);
        System.out.println(treeSet);

        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println("headSet-> " + treeSet.headSet(st4)); // выведутся все до st4(в данном случае до 3 курса)
        System.out.println("tailSet-> " + treeSet.tailSet(st3, true));// true включая, false исключая st3
        System.out.println(treeSet.subSet(st2, st5)); // подмножество в диапазоне, исключая последний

        // System.out.println(treeSet);
    }
}

/*обязательно нужен Comparable или Comparator т.к treeSet(в основе treeMap) должен отсортировать
 * equals и hashCode переопределять НЕ нужно т.к. это НЕ hasMap*/
class Student implements Comparable<Student> {
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public int compareTo(Student other) {
        return this.course - other.course;

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
