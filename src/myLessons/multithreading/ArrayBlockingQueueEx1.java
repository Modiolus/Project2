package myLessons.multithreading;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueEx1 {
    public static void main(String[] args)  {
 // ArrayBlockingQueue - потокобезопаснная очередь с ограниченны размером(capacity restricted)
 // обычно один или несколько потоков добавляют элементы в конец очереди, а другой или другие потоки забирают элементы из начала очереди
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.offer(5);// используется вместо add и не выбрасывает исключенние если добавление эелемета сверх capacity
        System.out.println(queue);

    }
}
