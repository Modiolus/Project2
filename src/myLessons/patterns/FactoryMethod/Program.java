package myLessons.patterns.FactoryMethod;

public class Program {
    public static void main(String[] args) {
//        DeveloperFactory developerFactory = new JavaDeveloperFactory();
        DeveloperFactory developerFactory = createDeveloperBySpecialty("php");

        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();

// TODO: 10.12.2021 Сулейманов https://www.youtube.com/watch?v=TwIjjTC5g7g&t=3s

    }

    static DeveloperFactory createDeveloperBySpecialty(String specialty) {
        if (specialty.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (specialty.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        } else {
          throw new RuntimeException(specialty + " is unknown specialty.");
        }
    }
}
