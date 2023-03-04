package hillel.HW16.p.service;

import hillel.HW16.p.Main;

public class ThreadPause {


    private Thread initThread;

    public ThreadPause(Thread initThread) {
        this.initThread = initThread;
        threadIterator();
    }

    private void threadIterator() {
        Main.atmArrayList.stream().peek(e ->{
            if (e != initThread) pause(initThread);
        });
    }

    private void pause(Thread o) {
        try {
            o.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
