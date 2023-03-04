package myLessons.multithreading;

public class VolatileEx extends Thread {

    volatile
    boolean b = true;// благодаря слову volatile переменная хранится в main memory, а не в кэш мемори
    // !!!!! volatile используется когда один поток может изменять пременную, а остальные потоки только читать
    // в данном случае main меняет в строке thread.b = false, а поток класса VolatileEx - читает в цикле while (b)

    @Override
    public void run() {
        long counter = 0;

        while (b) {
            counter++;
            /* !! НО если в цикле обратиться к переменной то происходит обращение из главной памяти без кэша.
             * Поэтому в таком случае volatile не нужен*/
            // System.out.println("Loop is continue, counter = " + " " + counter + "; b = " + b);
        }
        System.out.println("Loop is finished, counter = " + counter + "; b = " + b);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileEx thread = new VolatileEx();
        thread.start();
        Thread.sleep(3000);// в этом случае спит поток main, а не поток thread
        System.out.println("After 3 seconds it's time to wake up!");
        thread.b = false;
        thread.join();
        System.out.println("End of program");

    }
}
