package myLessons.multithreading.synchron;

public class Ex10 {
    public static void main(String[] args) {
        /* один экземпляр myRunnableIMpl. В параметрах ссылка на один экземляр*/

//        MyRunnableIMpl myRunnableIMpl = new MyRunnableIMpl();
//        Thread thread1 = new Thread(myRunnableIMpl);
//        Thread thread2 = new Thread(myRunnableIMpl);
//        Thread thread3 = new Thread(myRunnableIMpl);

        /*три экземпляра new MyRunnableIMpl(). В параметрах каждый раз новый экземпляр*/
        Thread thread1 = new Thread(new MyRunnableIMpl());
        Thread thread2 = new Thread(new MyRunnableIMpl());
        Thread thread3 = new Thread(new MyRunnableIMpl());

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

//class Counter {
//    static int count = 0;
//}

class MyRunnableIMpl implements Runnable {
    /* если в мейне несколько экземпляров то обязательно ставить static т.к. без него synchronized не поможет
     * если же экземпляр один то можно метод оставить без static и достаточно только synchronized
     * потому что при создании одного экземпляра используется один монитор, а при создании нескольких - используется
     * отдельный монитор для каждого экземпляра
     * ВАЖНО: если мотод не статичный, то идет синхронизация на объекте this т.е. объекте того класса в котором он вызван*/
    // происходит синхронизация метода increment и с ним может работать только один поток
    // synchronized лочит метод для остальных потоков, во время работы одного потока
    static int count = 0;

    static
    synchronized
    void increment() {
        count++;
        System.out.print(count + " ");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}
