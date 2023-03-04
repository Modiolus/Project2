package myLessons.multithreading;

public class DeadLockEx {
    /*Deadlock - ситуация, когда 2 или более потоков залочены (захватили мониторы) навсегда
     * ожидают друг друга и ничего не делают. Иногда отрабатывает до завершения, но НЕ всегда. ЗАПУСКАТЬ несколько раз!!
     * Стоит только в одном из методов вызвать Thread.sleep(10); как зависание происходит очень часто!
     * Это происходит, когда потоки исполнения имеют циклическу зависимость от пары синхронизованных объектов
     * чтоб этого не было нужно чтобы второй поток лочил в таком же порядке как и первый*/
// !!! НЕ забывай! Что лочить можно также через name.class или Lock lock = new reentrantLock();
//    Разницы нет никакой - главное, что лочиться нужно на мониторе какого-то объекта!
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
}

class Thread10 extends Thread {
    public void run() {
        System.out.println("Thread10: Попытка захватить монитор объекта lock1");
        synchronized (DeadLockEx.lock1) {
            System.out.println("Thread10: Монитор объекта lock1 захвачен");
            System.out.println("Thread10: Попытка захватить монитор объекта lock2");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLockEx.lock2) {
                System.out.println("Thread10: Мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}

class Thread20 extends Thread {
    public void run() {
        System.out.println("Thread20: Попытка захватить монитор объекта lock2");
        synchronized (DeadLockEx.lock2) {
            System.out.println("Thread20: Монитор объекта lock2 захвачен");
            System.out.println("Thread20: Попытка захватить монитор объекта lock1");
            try {
                  Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLockEx.lock1) {
                System.out.println("Thread20: Мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}