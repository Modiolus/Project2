package myLessons.multithreading;

import java.util.concurrent.*;

public class ThreadPoolEx1 {
    public static void main(String[] args) throws InterruptedException {
        /* ThreadPool - это множество потоков, каждый из которых предназначен для выполнения той или иной задачи
         * в Java мы работаем с тредпулами посредством объектов интерфейса Executor
         * (ExecutorService это интерфейс который наследует интерфейс Executor)
         * его потомок это executorService, которым удобнее всего работать с тредпулами
         * для создания ThreadPool чаще всего используют factory методы класса Executors:
         * Executors.newFixedThreadPool(int count) создаст pool, где count это то количество потоков которое мы хотим создать
         * Executors.newSingleThreadExecutor() создаст pool с одним потоком
         * т.е мы создаем ThreadPool не с помощью конструктора, а с помощью factory методов
         * поэтому и называется factory - фабрика по производству объектов
         * */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImpl100());//метод execute передает наше задание в thread pool, где оно выполняется одним из потоков

        }
        executorService.shutdown(); //shutdown() завершает программу когда все потоки выполнили полученные задания
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        // работает по типу метода join и заставляет ждать поток в котором вызывается. В данном случае ждать будет main
        // пока или executorService не закончит работу или пройдет время указанное в awaitTermination
        System.out.println("Main ends");
    }
}

class RunnableImpl100 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}
