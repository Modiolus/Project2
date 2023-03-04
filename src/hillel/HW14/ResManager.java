package hillel.HW14;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResManager {
    private static ResourceBundle resourceBundle;
    private static final String resourceName = "hillel.HW14.languages.lang";

    public static void changeResource (Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public static String getString(String key) {
        return resourceBundle.getString(key);
    }
}
