package myLessons.multithreading.synchron;

public class Ex11 {
//    static int counter = 0;
//    public synchronized static void increment(){
//        counter ++;
//    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new YourRunnable());
        Thread thread2 = new Thread(new YourRunnable());
        Thread thread3 = new Thread(new YourRunnable());
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.print(YourRunnable.counter); // выводит counter с логикой прописанной в YourRunnable
       // System.out.print(Ex11.counter); // выводит counter с логикой прописанной в Ex11
    }
}
//class YourCounter{
//    static int counter = 0;
//}
class YourRunnable implements Runnable{
    static int counter = 0;

    public synchronized static
    void increment(){
        counter ++;
    }
    @Override
    public void run() {
        for(int i=0; i<10000; i++){
            //Ex11.increment();
            increment();
        }
    }
}
