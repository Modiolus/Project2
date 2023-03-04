package myLessons.multithreading;

public class WaitNotifyExample {

    public static void main(String[] args) {
        /*в данном примере используется один экземпляр market поэтому методы синхронизируются на одном мониторе
         * и соответственно в методе используется просто synchronized БЕЗ static*/
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}

class Market {
    /* wait() и notify() используются для общения потоков между собой
     * wait() и notify() вызываются на объекте Market и используют его монитор this
     * !!! на том объекте на котором мы делаем синхроизацию, на том объекте
     * и вызываются методы wait() и notify()
     * если создать объект public static final Object lock = new Object()
     * то тогда lock.wait() и lock.notify()
     * !!! wait() освобождает монитор
     * !!! notify() НЕ освобождает монитор
     * в праметрах wait() можно указать в мсек сколько ждать
     * java doc рукомендует условие писать в while а не в if т.к в некоторых случаях поток может проснуться */
    private int breadCount = 0;
    public final Object lock = new Object();

    public synchronized void getBread() {
        //synchronized (lock){}; //для синхронизированного блока
        while (breadCount < 1) {

            try {
                wait(); // будет вызван при соблюдении условий и освободит монитор
                // lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("Потребитель купил 1 хлеб");
        System.out.println("Количество хлеба в магазине = " + breadCount);
        notify(); // в даном случае вызывается на объекте this
        // lock.notify(); // в этом случае вызовается на объекте lock
    }

    public synchronized void putBread() {
        //synchronized (lock){};
        while (breadCount >= 5) {
            try {
                wait(); // будет вызван при соблюдении условий и освободит монитор
                   // lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину 1 хлеб");
        System.out.println("Количество хлеба в магазине = " + breadCount);
        notify(); // в даном случае вызывается на объекте this
        // lock.notify(); // в этом случае вызовается на объекте lock
    }

}

class Producer implements Runnable {
    Market market;

    Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            market.putBread();
            System.out.println("Producer I = " + i);
        }
    }
}

class Consumer implements Runnable {
    Market market;

    Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
            System.out.println("Consumer I = " + i);
        }
    }
}
