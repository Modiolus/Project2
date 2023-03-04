package myLessons.collection.queueInterface;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListEx {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("Zaur");
        queue.add("Oleg");
        queue.add("Ivan");
        queue.add("Maria");
        queue.add("Aleksandr");

        System.out.println(queue);
        System.out.println(queue.remove()); // удаляет первый в очереди. Принцип FIFO. Если вызвать больше раз чем есть элементов - то выбросится исключение
        System.out.println(queue);
        System.out.println("Poll " + queue.poll());//удаляет первый в очереди. Если вызвать больше раз чем есть элементов - то НЕ выбросится исключение
        System.out.println(queue);
        System.out.println(queue.element());// показывает первый элемент в очереди. Если вызвать больше раз чем есть элементов - то выбросится исключение
        System.out.println(queue.peek()); //показывает первый элемент в очереди. Если вызвать больше раз чем есть элементов - то НЕ выбросится исключение

    }
}
