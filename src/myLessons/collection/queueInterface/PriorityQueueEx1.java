package myLessons.collection.queueInterface;

import java.util.PriorityQueue;

public class PriorityQueueEx1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        /*наибольший приоритет у наименьшего элемента
        * при выводе не обязательно элемнеты будут отсортированы
        * но при манипуляции с элементами вывод будет чётко по сортировке*/

        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(7);
        priorityQueue.add(1);
        priorityQueue.add(9);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.poll());// //удаляет первый в очереди. Если вызвать больше раз чем есть элементов - то НЕ выбросится исключение
        System.out.println(priorityQueue.element()); // типа get - показывает первый элемент
        System.out.println(priorityQueue.peek()); //показывает первый элемент в очереди. Если вызвать больше раз чем есть элементов - то НЕ выбросится исключение

    }
}
