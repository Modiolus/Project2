package myLessons.multithreading;

public class Ex2 {

    public static void main(String[] args) {
        Mythread1 mythread1 = new Mythread1();
        Mythread2 mythread2 = new Mythread2();
        /*два потока борятся за ресурс процессора и какой из них вырвтся вперед никто не знает
        * эти потоки не синхронизированы*/
        mythread1.start();// start() вызывает метод run()
        mythread2.start();

    }
}

class Mythread1 extends Thread {
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class Mythread2 extends Thread {
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}
