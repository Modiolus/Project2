package hillel.paintingForHW13;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Scanner;

public class ImportantIntToStringToInt {
    public static void main(String[] args) {
        char a = 'y';
        int code = (int) a;
        char[] cc = String.valueOf(a).toCharArray();
        System.out.println(Arrays.toString(cc));

        char[] c = String.valueOf(Integer.valueOf(a)).toCharArray();
        System.out.println(Arrays.toString(c));

        System.out.println(code);

        String[][] letter ={
                {"Вы ввели не число! "},
        };
        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i].length; j++) {
                System.out.print(letter[i][j]);
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(letter));
//        int a = 5;
//        int x = Integer.valueOf(a);
//        Integer x1 = Integer.valueOf(a);
//        System.out.println(x);
//        System.out.println(x1);
//        Integer i = 1100001001;
//        Integer j = 33332;
//        System.out.println(Integer.min(i, j));
//        Integer d = Integer.max(i, j) - Integer.min(i, j);
//        String s = Integer.toString(d, 3);
//        System.out.println(s);
//        System.out.println(Integer.valueOf(s, 3));
//
//        Scanner scan = new Scanner(System.in);
//       // int e = scan.nextInt();
//
//      //  char[] c = Integer.toString(e).toCharArray(); // инты в массив чаров(сначала в стринг,потом в массив чаров)
//       // System.out.println(Arrays.toString(c));
//
//        String st = scan.nextLine();
//        Integer in = Integer.valueOf(st, 8); // стринг с консоли переводим в инт
//        char[] ch =Integer.toString(in).toCharArray(); // инт переводим обратно в стринг, а потом в массив чаров
//        System.out.println(Arrays.toString(ch));
    }
}
