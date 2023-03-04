package myLessons.multithreading.multithrTrain;

public class CreateThread {
    public static void ascend() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    public static void descend() {
        for (int i = 100; i > 0; i--) {
            System.out.println(i);
        }
    }

    public static void negativeNumbers() {
        for (int i = 0; i > -50; i--) {
            System.out.println(i);
        }
    }

    /*для создания потока:
     * Все потоки создаются через Thread, исключение только клас ЭКСТЕНДЯЩИЙ Thread. Можно содавать напрямую экземпл класса
     * 1. нужно вызвать метод start(), который есть у класса Thread или нашего класса, наследующего Thread
     * 2. должен быть метод run(), либо переопределённый/имплементящий в нашем созданном классе, либо, если нам на ходу нужно создать поток,
     * то должен быть в параметрах Thread-а, в любом виде Runnable(лямбда, или new экземпляр класса имплементящий или
     * экстендящий Runnable, или new Runnable - анонимный),
     * чтобы можно было вызвать метод run()
     * */
    public static void main(String[] args) {
//        CreateThread createThread = new CreateThread();
//        TestImpl t = new TestImpl(createThread);
//        Thread th = new Thread(t);
//        th.start();

        TestExt testExt = new TestExt();
        Thread testImpl = new Thread(new TestImpl()); // new экземпляр класса имплементящий Runnable
        Thread thread = new Thread(CreateThread::negativeNumbers);
        Runnable runnable1 = new TestExt();
        Runnable runnable2 = new TestImpl();
        Runnable runnable3 = CreateThread::ascend;// не имплементит и не экстендит, но содержит метод как у Runnable void run()(пусто на вход и ничего не возвращает)

        testExt.start();
        testImpl.start();
        thread.start();

        new Thread(runnable1).start();// можно сослать ссылку на new и на ней вызвть start() - что тоже самое
        new Thread(runnable2).start();
        new Thread(runnable3).start();
        new Thread(() -> System.out.println("sout")).start();
        new Thread(new Runnable() { // анонимный
            @Override
            public void run() {

            }
        }).start();

    }
}

class TestExt extends Thread {
    @Override
    public void run() {
        CreateThread.ascend();
    }
    // TODO: 24.10.2021
   // Thread t = new Thread().start();
}

class TestImpl implements Runnable {
    //    CreateThread createThread;
//    public TestImpl(CreateThread cr){
//        this.createThread = cr;
//    }
    @Override
    public void run() {
        CreateThread.descend();
    }
}
