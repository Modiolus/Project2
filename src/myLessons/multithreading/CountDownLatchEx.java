package myLessons.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    // CountDownLatch(обратный отсчёт) - это синхронизатор, позволяющий любому количеству потоков ждать пока не завершится определенное количество операций
    // В конструктор нужно передавать количество операций(counter), которые должны завершиться, чтобы потоки продолжили свою работу
    // Как только все операции закончатся и их количество (counter) станет равно 0, то все потоки приступят к своей работе
    static CountDownLatch countDownLatch = new CountDownLatch(3);// количество операций(counter)

    private static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market staff came to work");
        countDownLatch.countDown();// уменьшает счетчик на 1
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready, so let's open market");
        countDownLatch.countDown();// уменьшает счетчик на 1
        System.out.println("countDownLatch = " + countDownLatch.getCount());

    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is open");
        countDownLatch.countDown();// уменьшает счетчик на 1
        System.out.println("countDownLatch = " + countDownLatch.getCount());

    }

    public static void main(String[] args) throws InterruptedException {
        // все 5 потоков приступят к работе, когда counter станет равен 0
        new Friend("Zaur", countDownLatch);
        new Friend("Oleg", countDownLatch);
        new Friend("Elena", countDownLatch);
        new Friend("Viktor", countDownLatch);
        new Friend("Marina", countDownLatch);
        // все 5 потоков будут ждать пока не пройдут все операции и соответственно счетчик не станет равен counter = 0
        // каждый метод ниже уменьшит counter на 1
        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();
    }
}

class Friend extends Thread {
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
        //  new Friend(name, countDownLatch).start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();//блокирует потоки пока counter не станет равен 0, т.е. пока не отработают все операции(методы)
            System.out.println(name + " приступил(а) к закупкам");// это типа поток, который разблокирован в случае counter = 0
        } catch (InterruptedException e) {

        }
    }
}
