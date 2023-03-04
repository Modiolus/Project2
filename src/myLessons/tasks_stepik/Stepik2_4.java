package myLessons.tasks_stepik;

import java.math.BigInteger;

public class Stepik2_4 {

    public static BigInteger factorial(int value) {

        int[] array = new int[value];

        BigInteger res = BigInteger.valueOf(1);
        for (int i = 0; i < value; i++) {
            array[i] = i + 1;
        }

        for (int i = 0; i < array.length - 1; i++) {

            res = res.multiply(BigInteger.valueOf(array[i + 1]));

        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println("--> " + Stepik2_4.factorial(4));

    }
}
