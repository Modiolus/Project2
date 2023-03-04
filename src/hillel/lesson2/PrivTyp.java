package hillel.lesson2;

public class PrivTyp {
    public static void main(String[] args) {
        byte b = 100;
        int i = 200;

        b = (byte) i;
        System.out.println(b);

    }
}
