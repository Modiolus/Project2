package myLessons.multithreading;

public class TestClass {
    public static void main(String[] args) {
//        при сложении двух чаров происходит преобразование в int
       String one = "aa", two = "bb", three = "cc";
       String s = " ";
        for (int i = 0; i < one.length(); i++) {
            s+= one.charAt(i)+two.charAt(i) + three.charAt(i);

        }

        System.out.println(one.charAt(1));
        System.out.println(s);

    }
}
