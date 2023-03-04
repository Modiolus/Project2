package hillel.lesson26;

import java.text.DateFormat;
import java.util.Locale;

public class SystemLocale {
    public static void main(String[] args) {

        Locale curr = Locale.getDefault();

        System.out.println(curr.getCountry());
        System.out.println(curr.getLanguage());

        System.out.println("--------------------------------------------");
        Locale.setDefault(Locale.KOREA);

        Locale[] supportedLocales = DateFormat.getAvailableLocales();

        for (Locale locale : supportedLocales){
            System.out.println(locale.getDisplayName());
        }

    }
}
