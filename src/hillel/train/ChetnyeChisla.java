package hillel.train;

import java.util.Arrays;

public class ChetnyeChisla {
    public static void main(String[] args) {
        /*посчитать сумму чётных цифр числа*/
        int i = 1234;

        String val = String.valueOf(i); // переводим int в String

        char[] chars = val.toCharArray(); // переводим String в набор символов и загоняем в массив чаров
        System.out.println(Arrays.toString(chars));

        int sum = 0;
        for (char c : chars) {
            //int in = Integer.valueOf(String.valueOf(c));
            int in = Integer.parseInt(String.valueOf(c));
          //  int in = Character.getNumericValue(c); // второй вариант
            if (in % 2 == 0) sum += in;

        }
        System.out.println(sum);

        /* ещё вариант*/
//        String[] strs = val.split(""); // разрезаем по одно1 символу и загонят в массив String
//        int sum = 0;
//        for (String s : strs){
//            int in = Integer.parseInt(s); // переводим String в int
//            if (in % 2 == 0) {
//                sum+= in;
//            }
//        }
//        System.out.println(sum);

//
//        String[] split = "2222".split("");
//        for (String s : split){
//            System.out.println(s);
//        }
    }
}
