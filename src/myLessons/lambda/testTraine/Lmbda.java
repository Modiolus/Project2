package myLessons.lambda.testTraine;

import java.util.function.BiFunction;

public class Lmbda {
    public static void main(String[] args) {
        Sq sq1 = a -> Math.sqrt(a);
        double res1 = sq1.koren(16);

        Sq sq2 = Math::sqrt;
        double res2 = sq2.koren(4);

        System.out.println(res1);
        System.out.println(res2);

        Sq2 sq21 = (q, w) -> Integer.sum(q, w);
        double res3 = sq21.summa(2, 3);
        Sq2 sq22 = Integer::sum;
        double res4 = sq22.summa(3, 5);

        System.out.println(res3);
        System.out.println(res4);
        // TODO: 19.09.2021
      // BiFunction<T, U, R> bf =(r, t, u) -> Integer.sum(u);

    }
}

interface Sq {
    double koren(double a);
}

interface Sq2 {
    double summa(int a, int b);
}
