package myLessons.streams;

import java.util.Arrays;
import java.util.Optional;

public class ChainingTest {
    public static void main(String[] args) {
//chaining это значит несколько методов или цепочка методов
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        /*задача: отфильтровать стрим так чтобы остались только нечетные числа
         * затем поделить на 3 только те числа, которые делятся без остатка
         * и подсчитать сумму оставшихся измененных чисел */

        int res=  Arrays.stream(array)
                .filter(p -> p % 2 == 1)
                .map(p -> {
                         if (p % 3 == 0) {
                                p = p / 3;
                            }
                            return p;
                        }
                )
                .reduce(Integer::sum)
                .getAsInt();


        int result = Arrays.stream(array)
                .filter(e -> e % 2 == 1)
                .map(e -> {
                    if (e % 3 == 0) {
                        e = e / 3;
                    }

                    return e;
                })
                .reduce((a, e) -> a + e)
                .getAsInt();

        System.out.println("result :" + result);

    }
}
