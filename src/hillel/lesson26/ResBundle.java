package hillel.lesson26;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResBundle {
    public static void main(String[] args) throws InterruptedException {
//     List<Locale> localeList = List.of(new Locale("de"), new Locale("ru"), new Locale("ua"),
//               new Locale("fr"), new Locale("us"));
//        Locale.setDefault(Locale.CHINA);
//        Locale locale = new Locale("ru");
//        ResourceBundle r = ResourceBundle.getBundle("Day", locale);
//        System.out.println(r);

        ResourceBundle
                resourceBundle = ResourceBundle.getBundle("hillel.lesson26.messagesBundle.Day",
                new Locale("uk")); //new Locale("ua")
        ResourceBundle
                resourceBundle1 = ResourceBundle.getBundle("hillel.lesson26.messagesBundle.MessagesBundle",
                new Locale("ua"));
//
////    //  System.out.println("monday");
        System.out.println(resourceBundle.getString("day1"));
        System.out.println(resourceBundle1.getString("hello"));

//        System.out.println(resourceBundle.getString("day1"));
//        System.out.println(resourceBundle.getString("day2"));


//        while (true) {
//
//            Locale locale = localeList.get((int) (Math.random() * 5));
//            ResourceBundle
//                    resourceBundle = ResourceBundle.getBundle("hillel.lesson26.messagesBundle.MessagesBundle", locale);
//            System.out.print("Lang: " + locale.getLanguage() + "  >>> ");
//            System.out.println(resourceBundle.getString("hello));
//            Thread.sleep(2000);
//        }
    }

}
