package myLessons.multithreading;

public class Ex8 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "; i = " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable());
        Ex8 thread2 = new Ex8();
        thread1.start();
        thread2.start();
        /*пример использования метода join()
        * поток В котором вызывается join() (В данном случае внутри потока main)
        * будет ждать тот поток НА котором вызван этот join()
        * иначе main сработает раньше*/
        thread1.join();
        thread2.join();
        System.out.println("Konec!");

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "; i = " + i);

        }

    }
}
