package myLessons.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        /* Semaphore - это синхронизатор, позволяющий ограничить доступ к какому-то ресурсу.
         * Он синхронизирует потоки на более высоком уровне имея на более низком уровне те же synchronise и lock
         * В конструктор Semaphore нужно
         * передавать количество потоков, которым Semaphore будет разрешать одновременно использовать этот ресурс
         * В задаче есть две телеф будки и соотв только два человека одновременно могут пользоваться телефоном
         * след человек не сможет пользоваться телефоном пока не освободится хотябы один телефон*/
        Semaphore callBoxMain = new Semaphore(2); // происходит синхронихация потоков и к ресурсу получат доступ 2 потока.
        // permits- разрешения(пер анг). Это счетчик который позволит указанному количеству потоков зыниматься ресурсом и быть синхронизированным
        new Person("Zaur", callBoxMain);
        new Person("Oleg", callBoxMain);
        new Person("Elena", callBoxMain);
        new Person("Viktor", callBoxMain);
        new Person("Marina", callBoxMain);
    }
}

class Person extends Thread {
    String name;
     private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start(); // при создании Person поток сразу будет запускаться
    }
    @Override
    public void run() {

        try {
            System.out.println(name + " ждёт...");
            // после получения доступа поток занимается ресурсом, а каунтер соответственно уменьшается на 1
            /* метод acquire() дает сигнал семафору, что поток хочет получить доступ к ресурсу
             * и если в семафоре есть место поток начинает работать с русурсом иначе поток блокируется
             * и ждет пока семафор не станет доступен*/
            callBox.acquire();// acquire - приобретать(пер с англ)
            System.out.println(name + " пользуется телефоном"); // здесь уже доступ получен
            sleep(2000);// каждый человек будет пользоваться телефоном 2 сек
            System.out.println(name + " завершил(а) звонок");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // release разрешает высвобождение семафора тем самым увеличивается каунтер семафора на 1. Рекомендовано вызывать именно в finally
            // вызываем здесь release именно потому что выше в пределах run() логика ресурса выполнилась(попользовались телефоном)
            callBox.release();// release - высвобождение(пер с англ)
        }
    }
}
