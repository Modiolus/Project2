package hillel.lesson20;

public class MyClass {
    public static void main(String[] args) {
        /*Алышев Udemy*/
        MyThread myThread = new MyThread();
        myThread.start();

//        MyThread myThread1 = new MyThread();
//        myThread1.start();
        Thread thread = new Thread(new Runner());
        thread.start();
        System.out.println(Thread.currentThread().getName()+"Start main");

    }
}

class Runner implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"Hello from MyThread 1_" + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"Hello from MyThread 2_" + i);
        }
    }
}
