package myLessons.multithreading.thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionEx1 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            source.add(i);
        }
        ArrayList<Integer> target = new ArrayList<>();
        // если использовать этот несинхронизованный лист а не synchList то вывод будет не предсказуемый

        List<Integer> synchList =
                Collections.synchronizedList(new ArrayList<>());

        // синхронизированная обертака для нового ArrayList или вью для нового ArrayList. Она синхронизирует ArrayList
        Runnable runnable = () -> {
//            target.addAll(source);
            synchList.addAll(source); //этот метод блокирует поток и с ресурсом может работать только один поток
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("synchList ->> " + synchList);
//        System.out.println(target);

    }
}
