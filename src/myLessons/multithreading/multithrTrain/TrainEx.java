package myLessons.multithreading.multithrTrain;

public class TrainEx {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Thread11());
        MyThread12 myThread12 = new MyThread12();

        t.start();
        myThread12.start();
        t.join();
        myThread12.join();

        System.out.println("Finish");
        /*для создания потока */
        //======================================================
        // еще способ через ExecutorService
        // ExecutorService executorService = Executors.newFixedThreadPool(3);
        // executorService.execute(new MyThread12());
        // можно еще через executorService.submit(new MyThread12());
        // но тогда класс должен был имплементировать Callable, а не Runnable
        //=======================================================
        //=======================================================
        // еще способ
        // прописать в классе конструктор и в нём непосредственно вызвать метод start
        // и тогда в мэйне просто new MyThread12();
        // public MyThread12(){
        //        this.start();
        //    }
        //===================================================================
        // еще способ
        // через лямбда выражения(по сути это способ прописания метода run() и его логики)
//         Runnable runnable = () -> {
//         TrainEx.account();
//          };
//         Runnable runnable1 = TrainEx::account;
//       //  можно и так  потом в мэйне
//        Thread thread = new Thread(runnable1);
//         thread.start();
//        можно и так
         new Thread(()->TrainEx.account());// в параметрах реализация Runnable посредством лямбда
//        или
        new Thread(TrainEx::account); // в параметрах реализация Runnable посредством лямбда
        //=============================
        // еще способ через анонимный класс
//        Thread worker = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//          worker.start();
        //=============================================

        Thread thread11 = new Thread(new Thread11());

    }
    public static void account() {

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
/*итак у нас есть два основных способа создания потоков через наследование класса Thread
и через реализацию интерфейса Runnable. В случае если наш класс уже наследовал какой-то класс то мы не сможем
ещё унаследовать и Thread, т.к. множественное наследование невозможно. И тогда используем вариант с implements Runnable*/
class Thread11 implements Runnable {

    @Override
    public void run() {
        TrainEx.account();
    }
}

class MyThread12 extends Thread {
    @Override
    public void run() {
        TrainEx.account();
    }
}