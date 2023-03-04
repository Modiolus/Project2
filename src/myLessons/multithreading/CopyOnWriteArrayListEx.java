package myLessons.multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListEx {
    public static void main(String[] args) throws InterruptedException {
        /* CopyOnWriteArrayList имплементирует интерфейс List
         * CopyOnWriteArrayList следует использовать тогда когда нам нужно добиться потокобезопасности,
         * у нас небольшое количество операций по изменению и большое количество операций по их чтению*/

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Zaur");
        list.add("Oleg");
        list.add("Sergey");
        list.add("Ivan");
        list.add("Igor");

        System.out.println("Original list: " + list);

        Runnable runnable1 = () -> {
            Iterator<String> iterator = list.iterator();
            System.out.println("Iterator output: ");
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(4); // в этом и методе ниже кажды йраз будет создаваться новая коллекция
            list.add("Elena");
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Change list: " + list);

    }
}
