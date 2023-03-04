package hillel.Trainee;

import java.util.Locale;
import java.util.Scanner;

public class ResourceManagerRun {
    public static void main(String[] args) {
     //   ResourceManager manager = ResourceManager.INSTANCE;

      //  System.out.println(manager.getString("str1"));
        System.out.println("1 — английский /n 2 — белорусский \n любой — русский ");
        Scanner scan = new Scanner(System.in);
        int in = scan.nextInt();
        switch (in){
            case 1 : ResourceManager.changeResource(new Locale("en"));
                System.out.println(ResourceManager.getString("str1"));
                break;
            case 2:  ResourceManager.changeResource(new Locale("be"));
                System.out.println(ResourceManager.getString("str1"));
                break;
        }
    }
}
