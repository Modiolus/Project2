package hillel.lesson26;

import java.util.Locale;

public class Localization {
    public static void main(String[] args) {

        Locale locale = new Locale("ru", "UA");
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayName());

        Locale defaultLocale = Locale.getDefault();

//        System.out.println(defaultLocale.getDisplayName());
//        System.out.println(defaultLocale.getDisplayLanguage());

        Locale.setDefault(Locale.ITALIAN);
        System.out.println(defaultLocale.getDisplayName());
        System.out.println(defaultLocale.getDisplayLanguage());




    }

}
