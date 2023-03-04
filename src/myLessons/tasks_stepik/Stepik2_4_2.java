package myLessons.tasks_stepik;

import java.util.Arrays;

public class Stepik2_4_2 {

    public static void main(String[] args) {
        int[] array1 = {3, 8, 10, 18, 23, 50, 206};
        int[] array2 = {10, 12, 20, 23, 30};

        System.out.println(Arrays.toString(mergeArrays(array1, array2)));


//        int[] result = new int[array1.length + array2.length];
//
//        int i = 0;
//        int j = 0;
//        int idx = 0;
//
//        while (i < array1.length && j < array2.length) {
//
//            if (array1[i] < array2[j]) {
//                result[idx] = array1[i];
//                i++;
//                idx++;
//
//            } else {
//                result[idx] = array2[j];
//                j++;
//                idx++;
//            }
//
//        }
//        for (int ar1Part = i; ar1Part < array1.length; ar1Part++) {
//            result[idx++] = array1[ar1Part];
//        }
//        for (int ar2Part = j; ar2Part < array2.length; ar2Part++) {
//            result[idx++] = array2[ar2Part];
//        }
//
//        System.out.println("Result" + Arrays.toString(result));

    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < a1.length && j < a2.length) {

            if (a1[i] < a2[j]) {
                result[index] = a1[i];

                i++;
                index++;

            } else {
                result[index] = a2[j];
                j++;
                index++;

            }

        }
        for (int a1Rem = i; a1Rem < a1.length; a1Rem++) {
            result[index++] = a1[a1Rem];

        }
        for (int a2Rem = j; a2Rem < a2.length; a2Rem++) {
            result[index++] = a2[a2Rem];

        }

        return result;
    }


}
