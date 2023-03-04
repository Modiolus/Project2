package myLessons.multithreading;

public class VolatileAlishev {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("After start");
        Thread.sleep(3500);

       myThread.shutDown();
//myThread.running=false;
        myThread.join();

        System.out.println("Program finished");

    }
}

class MyThread extends Thread {
    //  volatile
    public boolean running = true;
    int count = 0;

    @Override
    public void run() {
        while (running) {
          //  count++;
            System.out.println("Hello");
//            try {
//                Thread.sleep(2500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("Loop is end. Count = " + count);
    }

    public void shutDown() {
        this.running = false;
    }
}
