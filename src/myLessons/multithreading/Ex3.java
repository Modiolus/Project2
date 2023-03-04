package myLessons.multithreading;

public class Ex3 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Mythread3());
        Thread thread2 = new Thread(new Mythread4());
        thread1.start();
        thread2.start();

    }
}

class Mythread3 implements Runnable {
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}
class Mythread4 implements Runnable {
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}
