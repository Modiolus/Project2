package myLessons.multithreading;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {
    public static void main(String[] args) throws InterruptedException {
        /* ConcurrentHashMap имплементирует интерфейс ConcurrentMap, который в свою очередь происходит от интерфейса Map
         * в ConcurrentHashMap любое количество потоков может читать и вставлять элементы не блокируя его
         * в ConcurrentHashMap, благодаря его сегментриованию, при изменении какого-либо элемента блокируется только bucket, в котором он находится
         * поэтому синхронизировать Iterator не нужно т.к остальные бакеты не затрагиваются
         * в ConcurrentHashMap ни key ни value не могут быть null
         * Если использовать обычный HashMap, то будет выведено исключение*/

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Zaur");
        map.put(2, "Oleg");
        map.put(3, "Sergey");
        map.put(4, "Ivan");
        map.put(5, "Igor");

        System.out.println(map);

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + ":" + map.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "Elena");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map);
    }
}
