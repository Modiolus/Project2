package myLessons.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx2 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

        for (int i = 0; i < 10; i++) {
            scheduledExecutorService.execute(new RunnableImpl200());
        }
//        scheduledExecutorService.schedule(new RunnableImpl200(),
//                3, TimeUnit.SECONDS);// выполни эту задачу через 3 секунды
//
//        scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl200(),
//                3, 1, TimeUnit.SECONDS);// планирует задачу для выполнения через 3 секунды с периодичностью выполнения 1 сек
//        // это периодичность между началом выполнения первой задачи до начала выполнения второй задачи
//        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl200(),// планирует задачу для выполнения через 3 секунды с периодичностью выполнения 1 сек
                // это периодичность между концом одной и началом выполнения другой задачи(т.е. между задачами)
//                3, 1, TimeUnit.SECONDS);

        Thread.sleep(20000);
        scheduledExecutorService.shutdown();

        /*newCachedThreadPool() создаёт новые потоки по надобности, т.е. создает потоки под пришедшую задачу и если в какой-то момент
        * какой-то созданный поток освободился, а пришла новая задача, то этой задачей займётся свободный поток
        * если все потоки заняты, а приходит ещё одна задача, то создаётся еще один новый поток.
        * НО если через 60 сек, после того как использовался последний поток, он
        * не получает новую задачу - кэшированный ThreadPool удалит этот поток
        *  */
        ExecutorService executorService = Executors.newCachedThreadPool();

    }
}

class RunnableImpl200 implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}
