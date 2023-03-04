package myLessons.multithreading;

public class InterruptedEx {
//    TRAIN TRAIN TRAIN TRAIN TRAIN
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts");
        InterThread interThread = new InterThread();
        interThread.start();

        //Thread.sleep(2000);
        interThread.interrupt();
        interThread.join();

        System.out.println("Main ends");
    }
}
class InterThread extends Thread{
    double sqrt = 0;
    @Override
    public void run() {
        for (int i = 0; i <=1000000000; i++) {
            if (isInterrupted()){
                System.out.println("Potok xotyat prervat");
                System.out.println("After if "+sqrt);
                return;
            }
            sqrt +=Math.sqrt(1);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Potok xotyat prervat vo vremya sna, davayte zavershim ego rabotu");
                System.out.println("After try: "+sqrt);
            return;
            }
        }

    }
}