package myLessons.tasks_stepik;

import java.util.*;

/*Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
*/
public class Stepik6_22 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Введите числа: ");
//
//        List<Integer> list = new ArrayList<>();
//        if (scanner.hasNext()){
//            String[] a = scanner.nextLine().split(" ");
//            for (int i = 0; i < a.length; i++) {
//                if (i%2 ==0){
//                    list.add(Integer.parseInt(a[i]));
//
//
//                }
//            }
//        }
//        System.out.println("First-->> "+list);
////        Collections.sort(list, Collections.reverseOrder());
//        for (int i = list.size()-1; i >=0 ; i--) {
//            if (i==0){
//                System.out.println(list.get(i));
//            }else{
//                System.out.println(list.get(i) + " ");
//            }
//
//        }
//        System.out.println("Reverse-->> " + list);
//
//
//
//
//
////        List<Integer> list = new ArrayList<>(list1) ;
//
////        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//
//        ListIterator<Integer> iterator = list.listIterator();
//        List<Integer> res = new ArrayList<>();
////        ========================================================
////        for (int i = 0; i < list.size(); i++) {
////            System.out.println(list.get(i) % 2);
//
////            if (i%2 == 0) {
////                res.add(list.get(i));
////            }
////            System.out.println("res-->> " + res);
////        }
//
////        Collections.sort(res, Collections.reverseOrder());
////        System.out.println("Reverse-->> " + res);
////        ========================================================
////        for (Integer element:list) {
////            if (element%2==0){
////                res.add(element);
////            }
////        }
////        Collections.sort(res, Collections.reverseOrder());
////        System.out.println("res-->> " + res);
//
////        while (iterator.hasNext()) {
////            System.out.println("List-->> " + iterator.next());
////            if (iterator.next() % 2 == 1) {
////                res.add(list.get(iterator.nextIndex()));
////
////
////                System.out.println("Next-->> " + iterator);
////                res.add(iterator.next());
////
////            }
////
////        }
////        System.out.println(res);
////        System.out.println("Res-->> " + res);
////        System.out.println(res);
////        Collections.sort(list, Collections.reverseOrder());
////        System.out.println(res);
//
//
////        System.out.println(Arrays.asList(list));
//
//
//    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        if (scan.hasNext()){
            String[] a = scan.nextLine().split(" ");
            for (int i = 0; i < a.length; i++) {
                if (i%2 ==1){
                    list.add(Integer.parseInt(a[i]));

// 1 2 3 4 5 6 7
// 0 1 2 3 4 5 6 последовательность
                }
            }
        }
        for (int i = list.size()-1; i >=0 ; i--) {
            if (i==0){
                System.out.println(list.get(i));
            }else{
                System.out.print(list.get(i) + " ");
            }

        }

    }

}
