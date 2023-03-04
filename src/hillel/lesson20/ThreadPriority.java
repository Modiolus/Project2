package hillel.lesson20;

public class ThreadPriority {
    public static void main(String[] args) {
        ThrPrior t1 = new ThrPrior();
        ThrPrior t2 = new ThrPrior();

       // t1.setPriority(Thread.MAX_PRIORITY);
        t1.setName("TH1MAX");
       // t2.setPriority(Thread.MIN_PRIORITY);
        t2.setName("TH2MIN");
        t1.start();
        t2.start();
    }
}
class ThrPrior extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " iter : " + i);
        }
    }
}
