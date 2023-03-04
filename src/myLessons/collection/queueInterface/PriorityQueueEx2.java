package myLessons.collection.queueInterface;

import java.util.Objects;
import java.util.PriorityQueue;

public class PriorityQueueEx2 {
    public static void main(String[] args) {
        Student3 st1 = new Student3("Ivan", 3);
        Student3 st2 = new Student3("Petr", 1);
        Student3 st3 = new Student3("Fedor", 2);
        Student3 st4 = new Student3("Katya", 4);

        PriorityQueue<Student3> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(st1);
        priorityQueue.add(st2);
        priorityQueue.add(st3);
        priorityQueue.add(st4);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.poll());// удаляет без исключения
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

}

class Student3 implements Comparable<Student3> {
    String name;
    int course;

    public Student3(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student3 student3 = (Student3) o;
        return course == student3.course && Objects.equals(name, student3.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }

    @Override
    public int compareTo(Student3 other) {
        return this.course - other.course;
    }


}
