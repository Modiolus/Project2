package hillel.lesson20;

public class HelloWorld {
    public static void main(String[] args) {
        Runnable task = () -> { // т.к. Runnable это функциональный интерфейс с методом run
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        int i = 0;
        while (true) {
            Thread t = new Thread(task);
            t.setName("TH - " + i++);
            t.start();
            System.out.println("start thread # " + i);
        }

    }
}
