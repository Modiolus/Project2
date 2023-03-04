package myLessons.patterns.singleton;

public class SingletonEx {
    /* Одиночка определяет метод getInstance который возвращает единственный экземпляр своего класса
     * конструктор одиночки должен быть скрыт от клиентов.
     * Вызов метода getInstance должен быть единственным способом получить объект этого класса
     * В методе -> если экземпляр есть то метод возвращает его, а если экземпляра нет то метод его создаёт*/

    private static SingletonEx instance;
    public String value;

    // public
    private SingletonEx(String value) {
        this.value = value;
    }

    public static SingletonEx getInstance(String value) { //при многопоточной программе нужно этот метод синхронизировать(synchronized)
        if (instance == null) {
            instance = new SingletonEx(value);
        }
        return instance;
    }
}

class SingletonExMain {
    public static void main(String[] args) {
        SingletonEx singletonEx1 = SingletonEx.getInstance("Foo");
        SingletonEx singletonEx2 = SingletonEx.getInstance("Frog");

        System.out.println(singletonEx1.value);
        System.out.println(singletonEx2.value);
    }
}
