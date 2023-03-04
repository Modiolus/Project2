package myLessons.multithreading;

public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        /* interrupt - это просто флаг, обозначающий, что поток нужно прервать.
         * при вызове метода interrupt() флаг устанавливается в true и в логике кода при проверке выдаст первый раз true, а
         * затем сбросится\переключится в false
         * если в логике кода нам нужно снова переключить флаг в true, то мы снова вызваем метод interrupt()
         * Если же мы находимся в блокирующей операции такой как wait join or sleep то InterruptedException переключит флаг в false
         * Один из спосоов обработки такого исключения это снова перевести флаг в true, вызвав interrupt(), если это нужно
         * Таким образом используя флаг interrupt() мы можем прервать поток там, где нам это необходимо
         * вставить проверку на этот флаг и, к примеру, сделать пустой return или break,
         * завершив тем самым выполнение метода run и потока.
         */
        System.out.println("main starts");

        InterruptedThread thread = new InterruptedThread();
        thread.start();

         Thread.sleep(1000);// !!! это спит main
        thread.interrupt();// сигнал от main потоку thread о том, что поток main хочет прервать поток thread

        //interrupt() посылает сигнал потоку thread, что я хочу тебя прервать. Может прервать поток, если его разраб хочет
        // прервать в run() методе через if (isInterrupted()) return в конце
        thread.join();
        System.out.println("main ends");
    }
}

class InterruptedThread extends Thread {
    double sqrtSum = 0;

    @Override
    public void run() {

        for (int i = 1; i <= 1000000000; i++) {
            System.out.println("Before condition i = " + i);
            //Thread.currentThread().interrupt();
            if (isInterrupted()) { // проверяет, хотят ли прервать работу потока. Если в main вызван interrupt() то хотят прервать и isInterrupted() будет true

                System.out.println("Potok xotyat prervat");
                System.out.println("Mi ubedilis chto sostoyanie vsex potokov" +
                        " normalnoe i reshili prervat rabotu potoka");

                sqrtSum += Math.sqrt(i);

                    //e.printStackTrace();
                   //  Thread.currentThread().interrupt();

                    System.out.println("sqrtSum 1 = " + sqrtSum + "; i = " + i);
//                    System.out.println(isInterrupted());
//                    System.out.println(isInterrupted());
//                    if (i == 5) { // прервать на 5-й итерации
//                         //Thread.currentThread().interrupt();
//                        break;
//                    }

                return; // прерывает работу потока или break;

            }
            else {
                System.out.println("Else i = " + i);
                sqrtSum += Math.sqrt(i);
                System.out.println("Second sqrtSum: " + sqrtSum);
                // System.out.println("isInterrupted() before try/catch: "+isInterrupted());
                try {
                    //!!!!! Если процесс попал в try то даже при isInterrupted() true он НЕ попадёт в if,
                    // т.е. будет захвачен try. И только если в мэйн слип будет очень минимальным, например 10 мсек
                    // то isInterrupted() будет true
                    // и процесс не успеет попасть с в try и отработает в if
                    sleep(100);
                    System.out.println("After sleep ->");
                    //   System.out.println("isInterrupted() after sleep: "+isInterrupted());
                } catch (InterruptedException e) {
                    System.out.println("After catch ->");
                    //   System.out.println("isInterrupted() after catch: "+isInterrupted());
                    //  Thread.currentThread().interrupt();
                    System.out.println("Potok xotyat prervat vo vremya sna" +
                            " davayte zavershim ego rabotu");
                    System.out.println("sqrtSum 2 = " + sqrtSum);
                    // System.out.println(isInterrupted());
                    return; // если не прописать этот пустой return, то программа отработает, но не завершится

                }
            }

        }
    }
}
