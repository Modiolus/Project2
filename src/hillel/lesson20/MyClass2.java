package hillel.lesson20;

import java.util.Arrays;
import java.util.List;

public class MyClass2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = Arrays.asList("one", "two", "three");

        for (String s : list){
            Thread.sleep(2000);
            System.out.println(s);
        }
        Thread.sleep(2000);
        System.out.println("HI !!");
    }
}
