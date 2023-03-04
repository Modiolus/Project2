package hillel.train;

public class NumberReverse {
    public static void main(String[] args) {
        int number = 1234;

        String str = String.valueOf(number);

        StringBuilder sb = new StringBuilder(str).reverse(); // перевли в String и развернули
        int i = Integer.parseInt(sb.toString());

       // int i = Integer.valueOf(String.valueOf(sb)); //перевели в int (valueOf(String) возвращает объект)
       // int i = Integer.parseInt(String sb); //перевели в int (parseInt возвращает примитив)
        System.out.println(i);
        System.out.println("==========================================");

        /*второй способ*/
//        String str = String.valueOf(number);
//
//        StringBuilder result = new StringBuilder(str);
//       result.reverse();
//        int j = Integer.valueOf(String.valueOf(result));
//                System.out.println(j);


    }
}
