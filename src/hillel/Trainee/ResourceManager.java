package hillel.Trainee;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceManager {
   // INSTANCE;
//    ENGLISH,
//    BELARUS;
    private static ResourceBundle resourceBundle;
    private static final String resourceName = "hillel.Trainee.text";

//    private ResourceManager() {
//        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
//    }
    public static void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }
    public static String getString(String key) {
        return resourceBundle.getString(key);
    }
}
