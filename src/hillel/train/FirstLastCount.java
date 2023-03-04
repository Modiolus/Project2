package hillel.train;

public class FirstLastCount {
    public static void main(String[] args) {
        int number = 12345678;

        String n = String.valueOf(number);

        int a1 =Character.getNumericValue(n.charAt(0));
        int a2 = Character.getNumericValue(n.charAt(n.length()-1));
        int sum = a1 + a2;
        System.out.println(sum);

    }

}
