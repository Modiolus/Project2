package myLessons.multithreading.synchron;

public class SynchronizedBlock2 {

//    static int counter = 0;
//    public
//    //synchronized
//    static
//    void increment(){
//        synchronized (SynchronizedBlock2.class) {
//            counter++;
//        }
//
//    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new YourRunnable2());
        Thread thread2 = new Thread(new YourRunnable2());
        Thread thread3 = new Thread(new YourRunnable2());
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.print(YourRunnable2.counter);

    }
}
//class YourCounter{
//    static int counter = 0;
//}
class YourRunnable2 implements Runnable{

    static int counter = 0;
    public
    //synchronized
    static
    void increment(){
        synchronized (YourRunnable.class) {// синхронизированный блок
            counter++;
        }
    }
    @Override
    public void run() {
        for(int i=0; i<10000; i++){
           // SynchronizedBlock2.increment();
            increment();
        }
    }
}
