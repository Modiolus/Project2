package myLessons.multithreading.synchron;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex12 {
    /*задача, чтобы начинался один звонок и пока он не закончится другой звонок не начинался
     * РЕШЕНИЕ:1. способ: прописать static synchronized в каждом методе
     * 2. способ: создать в каждом методе synchronized блок и прописать объект на которм будет синхронизация
     * предварительно создав объект static final Object lock т.е. на нем синхронизироваться используя один его монитор
     * второй способ является правилом "хорошего тона" и этот объект можно использовать в других местах данного проекта
     * а название lock хорошо читается для понимая кода всего проекта
     * ВЫВОДЫ ПО классам пакета synchron(У Заура лекция 71 и 72):
     * для синхронизации методов с которыми будут работать потоки необходимо синхоронизировать их
     * на ОДНОМ объекте используя ОДИН его монитор!!!!
     * Для этого во всех случаях:
     * Если в мэйн 1 экземпляр, то просто synchronized в методе, а при использовании блока synchronized(this)
     * Если в мэйн несколько экземпляров, то static synchronized в методе, а при использовании блока synchronized(имя класса.class)
     * для хорошего тона можно создать объект static final Object lock и lock использовать в блоке показав монитор какого объекта использовать
     * НО глобально это не меняет сути и происходит тоже самое lock/unlock на ОДНОМ мониторе ОДНОГО класса или экземпляра*/

public static final Object lock = new Object();

    void mobileCall() {

        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");
        }
    }

    void skypeCall() {

        synchronized (lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");
        }
    }

    void whatsAppCall() {

        synchronized (lock) {
            System.out.println("WhatsApp call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WhatsApp call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImlMobile());
        Thread thread2 = new Thread(new RunnableImlSkype());
        Thread thread3 = new Thread(new RunnableImlWhatsApp());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableImlMobile implements Runnable {
    @Override
    public void run() {
        new Ex12().mobileCall();
    }
}

class RunnableImlSkype implements Runnable {
    @Override
    public void run() {
        new Ex12().skypeCall();
    }
}

class RunnableImlWhatsApp implements Runnable {
    @Override
    public void run() {
        new Ex12().whatsAppCall();
    }
}


