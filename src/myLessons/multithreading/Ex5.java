package myLessons.multithreading;

public class Ex5 {
    public static void main(String[] args) {
        /*методы потоков
         *если не указать setName() то getName() выведет дефолтное название
         *getPriority() выводит приоритет от 1 до 10  */
        Mythred5 mythred5 = new Mythred5();
        mythred5.setName("Moy potok");
        mythred5.setPriority(9);
        System.out.println(mythred5.getPriority());

        mythred5.setPriority(Thread.MIN_PRIORITY); // приритет 1
        //   mythred5.setPriority(Thread.NORM_PRIORITY);// приоритет 5
        System.out.println("Name of mythread5 = " +
                mythred5.getName() + "; Priority of mythread5 = " +
                mythred5.getPriority());

    }

}

class Mythred5 extends Thread {
    @Override
    public void run() {
        System.out.println("privet");
    }
}