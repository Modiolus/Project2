package hillel.lesson20.sync;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            System.out.println(">> TH-1 before loop : " + Count.getCount());
            for (int i = 0; i < 1000; i++) {
                Count.increment(1);
                // System.out.println("<< TH-1: " + Count.getCount());
                int j = Count.getCount();
                //  System.out.println(">> TH-1 : " + j);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                // j += 23;
                //  Count.setCount(j);
                //   System.out.println("<< TH-1 : " + Count.getCount());
            }
        };
//        Runnable task2 = () -> {
//            System.out.println(">> TH-2 before loop : " + Count.getCount());
//            for (int i = 0; i < 1000; i++) {
//                //  System.out.println(">> TH-2 : " + Count.getCount());
//                Count.increment(1);
//                //   System.out.println("<< TH-2: " + Count.getCount());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                // System.out.println("<< TH-2 : " + Count.getCount());
//            }
//        };
        Thread t1 = new Thread(task1);
        t1.start();
        Thread t2 = new Thread(task1);
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Count.getCount());

//        for (int i = 0; i < 10; i++) {
//            try {
//                System.out.println(Count.getCount());
//                Thread.sleep(500);
//                Count.increment(25);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Count.getCount());
//        }


//        System.out.println(Count.getCount());
    }
}
