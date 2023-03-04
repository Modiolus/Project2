package hillel.lesson20;

public class InteruptMet {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thr();
//        thread.start();
//
//        while (true) {
//            System.out.println("isAlive: " + thread.isAlive());// метод показывающий живой поток или нет. True или false соответственно
//            Thread.sleep(1300);
//            int rez = Count.getCount();
//            System.out.println(rez + " >> " + rez % 3);
//
//            if (rez % 3 == 0) {
//                //thread.interrupt();
//                break;
//            }
//            System.out.println("finish main thread");
//            Thread.sleep(2000);
//            System.out.println(thread.isAlive());
//        }
//    }
//}
//
//class Thr extends Thread {
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//
//            try {
//                Thread.sleep(233);
//                Count.increment();
//            } catch (InterruptedException e) {
//                System.out.println("programm finish");
//            }
//        }
//    }
//}
//
//class Count {
//    private static volatile int count = 0;
//
//    public static synchronized void increment() {
//        count++;
//    }
//
//    public static synchronized int getCount() {
//        return count;
        //========================================
        Thread thread = new Thr();
        thread.start();

        //  while (true) {
        System.out.println("isAlive: " + thread.isAlive());// метод показывающий живой поток или нет. True или false соответственно
         Thread.sleep(2000);
        // int rez = Count.getCount();
        //  System.out.println(rez + " >> " + rez % 3);

        // thread.interrupt();
        Thr.interruptMethod();
        thread.join();
        System.out.println("finish main thread");
      //  Thread.sleep(1000);
        System.out.println("isAlive: " + thread.isAlive());
        // }
    }
}

class Thr extends Thread {
    public static int rez = 0;

    public static synchronized void interruptMethod() {
        for (int i = 0; i < 100; i++) {
            Count.increment();
            rez = Count.getCount();
            System.out.println(Thr.rez + " >> " + Thr.rez % 3);
            if (Thr.rez % 3 == 0) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        if (Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(233);

            } catch (InterruptedException e) {
                //  if (Thr.rez % 3 == 0) {
                //  Thread.currentThread().interrupt();
                //     break;
                //    }
                System.out.println("programm finish");
                //  break;
            }
            // break;

        }

    }

    @Override
    public void run() {
//        for (int i = 0; i < 100; i++) {
//            Count.increment();
//            rez = Count.getCount();
//            System.out.println(Thr.rez + " >> " + Thr.rez % 3);
//            if (Thr.rez % 3 == 0) {
//                interrupt();
//
//            }
//        if (isInterrupted()) {
//            try {
//                Thread.sleep(233);
//
//            } catch (InterruptedException e) {
//                //  if (Thr.rez % 3 == 0) {
//                //  Thread.currentThread().interrupt();
//                //     break;
//                //    }
//                System.out.println("programm finish");
//                //  break;
//            }
//            // break;
//
//        }
    }
}

class Count {
    private static volatile int count = 0;

    public static synchronized void increment() {
        count++;
    }

    public static synchronized int getCount() {
        return count;
    }
}
