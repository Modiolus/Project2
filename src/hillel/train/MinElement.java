package hillel.train;

import java.util.Arrays;

public class MinElement {
    public static void main(String[] args) {
//        int[] array = {12, 8, 2, 1, 1, 14, 5};
//        for (int i = 0; i < array.length; i++) {
//            int minValue = array[i];
//            int minIndex = i;
//            for (int j = i + 1; j < array.length; j++) {
//
//                if (array[j] < minValue) {
//                    minValue = array[j];
//                    minIndex = j;
//
//                } else if (array[i] == minValue) {
//                    System.out.println(minValue);
//                }
//                System.out.println(minValue);
//            }

        //           }
        //  System.out.println(minValue);
        //      System.out.println(array[minIndex]);
//            int temp = array[i];
//            array[i] = array[minIndex];
//            array[minIndex] = temp;
        int[] array = {-1, 12, -1, 8, -1, 2, 14, 5};

        int min = array[0];
        int minIndex = 0;
        System.out.println("Минимальное значение в массиве: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }

            else if (array[i] == array[minIndex] && array[i] != array[0]) {

                System.out.println("TEst 1: " + array[minIndex]);

            }

            else if (array[i] == array[minIndex] && array[i] == array[minIndex]) {
                System.out.println("TEst 2: " + array[i]);

            }

        }
        System.out.println(min);


    }
}
