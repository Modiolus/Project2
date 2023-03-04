package myLessons.multithreading.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {

        Call call = new Call();
        /*ниже способ создания потоков через анонимные классы интерфейса Runnable
         * чтобы не создавать отдельно классы в котрых будет переопределяться run() и
         * вызываться метод MobileCall
         * В данном коде поток сможет вызвать метод только после того как другой поток освободит монитор*/
        //new Thread(()-> call.MobileCall()); // пример через лямбду - реализация run()

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                call.MobileCall();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.SkypeCall();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.WhatsAppCall();
            }
        });

        thread.start();
        thread2.start();
        thread3.start();
    }
}

class Call {
    /* Пример из multithreading.Ex12 только используется не synchronized, а Lock и ReentrantLock
     * Lock интерфейс который имплементируется классом ReentrantLock. Lock нужен для синхронизации потоков так же как и слово synchronized
     * и тогда на объекте lock нужно обязательно вызывать метод unlock() для того чтобы открыть замок(освободить монитор)
     * и обязательно прописывается в блоке finally чтобы в любом случае открывался замок даже при срабатывании исключения
     * synchronized (Call.class) вариант синхронизации как и раньше через synchronized блок*/
    private Lock lock1 = new ReentrantLock();

    void MobileCall() {
        lock1.lock();
        // synchronized (Call.class) {

        try {
            System.out.println("Mobile call starts");
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }

    }

    void SkypeCall() {
        lock1.lock();
        // synchronized (Call.class) {

        try {
            System.out.println("Skype call starts");
            Thread.sleep(5000);
            System.out.println("Skype call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }

    }

    void WhatsAppCall() {
        lock1.lock();
        // synchronized (Call.class) {

        try {
            System.out.println("WhatsApp call starts");
            Thread.sleep(7000);
            System.out.println("WhatsApp call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }

    }


}

