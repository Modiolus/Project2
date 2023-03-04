package myLessons.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedTest {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        int[] arraySort = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(arraySort));
//        Object[] arrayString = {"Privet", "Poka", "Kak dela", "Ok"};
//        arrayString = Arrays.stream(arrayString).sorted().toArray();
//        System.out.println(Arrays.toString(arrayString));
        /*или так  Object[] */
        String[] arrayString = {"Privet", "Poka", "Kak dela", "Ok"};
        Object[] arrayString1 = Arrays.stream(arrayString).sorted().toArray();
        System.out.println(Arrays.toString(arrayString1));

        /*также можно сортировать более сложные листы через компаратор см.-> lambda.predicate.StudentInfo2*/
    }
}
