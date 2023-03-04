package myLessons.multithreading.callableFuture;

import java.util.concurrent.*;

public class RunnableFactorial {
    public static int factorialResult;

    /* задача по подсчету факториала числа. Решение с помощью ExecutorService и implements Runnable
     * недостаток в том что метод run() ничего не возвращает и приходится создавать класс RunnableFactorial
     * и в нем переменную factorialResult, которую возвращаем в run()
     * более оптимально решение в другом классе myLessons.multithreading.callableFuture.CallableFactorial*/
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        executorService.execute(factorial);

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(factorialResult);

        Thread thread = new Thread(new Factorial(5));

    }
}

class Factorial implements Runnable{
    int f;

    Factorial(int f) {
        this.f = f;
    }
    @Override
    public void run() {
        if (f <= 0) {
            System.out.println("You enter wrong number");
//return;
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
            RunnableFactorial.factorialResult = result;
        }
    }
}


