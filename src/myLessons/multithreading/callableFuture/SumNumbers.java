package myLessons.multithreading.callableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumNumbers {
    /*Задача: найти сумму чисел от 1 до 1 млрд десятью потоками:
     * 1 поток от 1 до 100 млн
     * 2 поток от 100 000 001 до 200 000 000
     * 3 поток от 200 000 001 до ...
     * .
     * .
     * 10 поток от 900 000 001 до 1 млрд */
    private static long value = 1000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futureResults = new ArrayList<>();

        long valueDividedBy10 = value / 10;
        for (int i = 0; i < 10; i++) {
            long from = valueDividedBy10 * i + 1;
            long to = valueDividedBy10 * (i + 1);
            PartialSum task = new PartialSum(from, to);
            Future<Long> futurePartSum = executorService.submit(task);
            futureResults.add(futurePartSum);

        }

        for (Future<Long> result : futureResults) {
            sum += result.get();
        }
        executorService.shutdown();
        System.out.println("Total sum " + sum);
    }

}

class PartialSum implements Callable<Long> {
    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() {
        for (long i = from; i <= to; i++) {
            localSum += i;

        }
        System.out.println("Sum from " + from + " to " + to + " = " + localSum);
        return localSum;

    }
}

