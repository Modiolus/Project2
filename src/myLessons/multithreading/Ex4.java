package myLessons.multithreading;

public class Ex4 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Privet");
            }
        }).start();

        Runnable r= ()-> System.out.println("Privet");
        Thread t = new Thread(r);
        t.start();
        new Thread(()-> System.out.println("Privet")).start();
    /*в скобках вместо new Runnable() можем записать лямбда выражение т.к. интерфейс new Runnable() является
    функциональным и содержит метод void run()
    */
    }
}
