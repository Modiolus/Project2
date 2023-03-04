package hillel.Trainee;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HamletInternational {
    public static void main(String[ ] args) {
   //     for (int i = 0; i < 3; i++) {
            System.out.println("1 — английский /n 2 — белорусский \n любой — русский ");
         //   char i = 0;
//            try {
//                i =  System.in.read(); //(char)
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            Scanner scan = new Scanner(System.in);
            int in = scan.nextInt();

           // String country = "";
            String language = "";
            switch (in) {
                case 1:
                   // country = "US";
                    language = "EN";
                    break;
                case 2:
                  //  country = "BY";
                    language = "BE";
                    break;
            }
            Locale current = new Locale(language); //country,
            ResourceBundle rb = ResourceBundle.getBundle("hillel.Trainee.text", current);
            String s1 = rb.getString("str1");
            System.out.println(s1);
            String s2 = rb.getString("str2");
            System.out.println(s2);
        }
  //  }
}
