package myLessons.multithreading;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueEx2 {
    public static void main(String[] args) {
        /*Методы BlockingQueue можно разделить на 4 группы, по-разному реагирующие на невозможность выполнения операции в текущий момент
         и откладывающие их выполнение на время :
         - первые вызывают Exception, вторые возвращают определенное значение (null или false),
         - третьи блокируют поток на неопределенное время до момента выполнения операции,
         - четвертые блокируют поток на определенное время.
         Эти методы представлены в следующей таблице :

       Вызывает   | Чтение    |              |    Чтение
       Exception	значения	Блокировка	 |    с задержкой
Insert	 add(e)	    offer(e)	put(e)	     |   offer(e, time, unit)
Remove	 remove()	poll()	    take()	     |   poll(time, unit)
Проверка element()	peek()	    не применимый|	не применимый

*/
/*Задача: Producer добавляет в конец очереди, а Consumer забирает с начала очереди */
        ArrayBlockingQueue<Integer> arrayBlockingQueue =
                new ArrayBlockingQueue<>(4);

       // Producer
        new Thread (() ->{
           int i = 0;
           while (true){
               try {
                   arrayBlockingQueue.put(++i);
                   System.out.println("Producer dobavil: " + i + " "+ arrayBlockingQueue);
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();
       // Consumer
        new Thread (() ->{
            while (true){
                try {
                    Integer j = arrayBlockingQueue.take();
                    System.out.println("Consumer zabral: " + j + " " + arrayBlockingQueue);
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
