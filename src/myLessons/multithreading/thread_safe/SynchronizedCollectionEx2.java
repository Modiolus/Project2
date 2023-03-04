package myLessons.multithreading.thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedCollectionEx2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        List<Integer> synchList =
                Collections.synchronizedList(arrayList);
        /* несмотря на то что мы использовали синхронизацию коллекции, ввод может быть некорректным
         * потому что Iterator в многопоточности може давать сбои потому что никакого лока в нем не ставится
         * в отличие от remove, где будет лок и другие потоки не смогут ничего сделать. Т.к. remove это метод синхр коллекции synchList
         * посему лок в Iterator нужно прописать в ручную. Это просто нужно прописать synchronized (synchList)
         * по сути мы используем синхрониацию блока и пока перебор в Iterator не закончится, то метод remove( не вызовется)
         * т.е. помимо синхронизированных коллекций небходимо синхронизировать блок кода с итератором(если он есть)*/

        Runnable runnable1 = () -> {
            synchronized (synchList) {// синхронизирует блок кода в котором находится Iterator
                Iterator<Integer> iterator = synchList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };
        Runnable runnable2 = () ->
                synchList.remove(10); // не сработает пока не будет окончена работа итератора
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(synchList);
    }
}
