package hillel.HW16.ATM;

public class MainATM {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread1 = new AtmThread("thread-1");
        Thread myThread2 = new AtmThread("thread-2");
        Thread myThread3 = new AtmThread("thread-3");

        myThread1.start();
        Thread.sleep(1000);
        myThread2.start();
        Thread.sleep(1000);
        myThread3.start();


    }
}

