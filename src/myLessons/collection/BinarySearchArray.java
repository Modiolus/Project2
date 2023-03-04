package myLessons.collection;

import java.util.Arrays;
import java.util.Collections;

public class BinarySearchArray {

    public static void main(String[] args) {
        /*binarySearch также можно применять в массивах*/

        Integer[] array ={3, 8, 12, -8, 0, 5, 10, 1, 150, -30, 19};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int index =Arrays.binarySearch(array, 150);
        System.out.println(index);

        Arrays.sort(array, Collections.reverseOrder());
        System.out.println(Arrays.toString(array));

    }
}
