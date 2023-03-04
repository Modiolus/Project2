package hillel.lesson4;

public class StrIntern {
    public static void main(String[] args) {
        String st1 = "St1";
        String st2 = new String("St1");

        System.out.println(st1 == st2);
        st2 = st2.intern(); // метод переносит значение стринга из Heap в пул https://www.javatpoint.com/methods-of-string-class

        System.out.println(st1 == st2);

    }
}
