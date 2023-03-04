package hillel.lesson20.singleTone;

public class Main {
    public static void main(String[] args) {
        // lesson 16
        Singleton singleton = Singleton.getInstance("foo");
        Singleton anotherSingleton = Singleton.getInstance("bar");
        System.out.println(singleton.value);
        System.out.println(singleton.hashCode());
        System.out.println(anotherSingleton.value);
        System.out.println(anotherSingleton.hashCode());
        Singleton s =  Singleton.getInstance("test");
        System.out.println(s.value);
        System.out.println(s.hashCode());

    }
}
