package myLessons.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {
    //  static int counter = 0;
    static AtomicInteger counter = new AtomicInteger();

    /*AtomicInteger - это класс, который предоставляет возможность работать с целочисленным значением int, используя атомарные операции*/
    /* в методе ниже происходит не атомарная операция т.е. при прописании synchronized сначала блокируется монитор, потом чтение потом +1 потом запись
     * т.е. не атомарная операция и вывод можт быть не всегда правильный и приходится использовать synchronized в методе increment() ,
     * но это достаточно тяжелая операция, поэтому java предлагает в таких случаях пользоваться классом AtomicInteger(есть также Double, Boolean ...)
     * в нём все операции происходят атомарно - т.е. целиком*/
    public static
    // synchronized // не нужен, если мы используем AtomicInteger и его методы
    void increment() {// если не синхронизировать то вывод будет не всегда правильный т.к. наблюдается data race
        //  counter++;
//        counter.incrementAndGet();// увеличивает на 1 и даёт (метод класса атомикинтеджер)
        counter.addAndGet(5); // увеличивает на 5 и даёт  (метод класса атомикинтеджер)

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImp118());
        Thread thread2 = new Thread(new MyRunnableImp118());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class MyRunnableImp118 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            AtomicIntegerEx.increment();
        }
    }
}
