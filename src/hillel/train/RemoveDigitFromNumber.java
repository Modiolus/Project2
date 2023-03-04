package hillel.train;

public class RemoveDigitFromNumber {
    public static void main(String[] args) {
        /*убрать цифру 2 из числа*/
        int rem = 2;
        int number = 123242526;

        //  String[] split = String.valueOf(number).split("");
        String[] split = String.valueOf(number).split("");
//        String str = String.valueOf(number);
//
        StringBuilder result = new StringBuilder();

//        result.reverse();
//        System.out.println(result);
        for (String s : split) {
            if (Integer.parseInt(s) != rem) {
                result.append(s);
            }
        }

        System.out.println(result);

    }
}
