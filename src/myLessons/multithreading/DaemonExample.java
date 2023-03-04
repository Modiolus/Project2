package myLessons.multithreading;

public class DaemonExample {
    public static void main(String[] args) {
        /*daemon это поток для выполнения фоновых задач или оказания различных сервисов User потокам.
        * После завершения User птоков программа завершает свою работу
        * не дожидаясь окончания работы daemon потока и daemon будет прерван досрочно
        * чтобы поток объявить демоном нужно к потоку после точки написать setDaemon(true)
        * и объявлять поток демоном нужно строго после объявления потока, но перед запуском
        * если объявить после старта то вылетит IllegalThreadStateException
        * метод isDaemon() спрашивает является ли поток демоном и возвращает true или false соответственно*/
        System.out.println("Main thread starts");
        UserThread userThread = new UserThread();
        userThread.setName("user_thread");

        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("daemon_thread");

        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

        System.out.println("Main thread ends");
    }
}
class UserThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " is daemon " + isDaemon());
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class DaemonThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " is daemon " + isDaemon());
        for (int i = 1; i < 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
