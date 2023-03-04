package myLessons.multithreading.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        new Employee("Zaur", lock);
        new Employee("Oleg", lock);
        new Employee("Elena", lock);
        Thread.sleep(5000);
        new Employee("Viktor", lock);
        new Employee("Marina", lock);
    }
}

class Employee extends Thread {

    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start(); // при таком написании созданный объект в main будет вызывать конструктор и сразу запускаться
    }
    @Override
    public void run() {
        if (lock.tryLock()) {
            // tryLock() позволяет делать лок когда монитор свободен. А если монитор занят то выводить else.
            // с НЕ ReentrantLock вариантом синхронизации, если поток занят, то другой поток будет ждать и ничего не выводить
            try {
//            System.out.println(name + " ждёт..");
//            lock.lock();
                System.out.println(name + " пользуется банкоматом");
                Thread.sleep(2000);
                System.out.println(name + " работник завершил(а) свои дела");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        else {
            System.out.println(name + " не хочет ждать очереди");
        }
    }
}
