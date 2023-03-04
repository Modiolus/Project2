package myLessons.multithreading.synchron;

public class SynchronizedBlock1 {

    public static void main(String[] args) {
        MyRunnableIMpl2 runnable = new MyRunnableIMpl2();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

//        Thread thread1 = new Thread(new MyRunnableIMpl2());
//        Thread thread2 = new Thread(new MyRunnableIMpl2());
//        Thread thread3 = new Thread(new MyRunnableIMpl2());

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Counter2 {
    volatile static int count = 0;

}

class MyRunnableIMpl2 implements Runnable {
    //static
    public void doWork1() {
        //!!!! если метод не статичный, то идёт синхронизация на объекте this, при условии создания одного объекта
        // при этом если создается несколько объектов, то вывод будет кривой
        // this и static в методе вместе использоваться не могут(ошибка компилятора) и они оба обозачают использование одного монитора
        // а у наc используется несколько объектов и соответственно несколько мониторов
        /* это синтаксис написания синхронизированного блока
         * в скобках - объект чей монитор для синхронизации мы будем использовать
         * т.е лочить и анлочить(в конце кода)
         * монитор это сущность прикреплённая к объекту, и он может иметь статутс: свободен или занят
         * монитор может занять только один поток и в это время статус будет: занят
         * static в методе показыает, что используется монитор объекта класса MyRunnableIMpl2 в котром этот метод находится
         * MyRunnableIMpl2.class показывает, что можно использовать несколько мониторов
         * */
//        synchronized (this){
//
//        }
       synchronized (this) { // сихронизированный блок кода synchronized(объект ил класс чей монитор будем использовать) {логический код}
            Counter2.count++;
            System.out.print(Counter2.count + " ");
        }

//            Counter2.count++;
//            System.out.println(Counter2.count);

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork1();
        }

    }
}
