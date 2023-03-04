package myLessons.lambda;

public interface Climb {
    boolean isTooHigh(int height, int limit);

}

 class Climber {
    public static void main(String[] args) {
 //       check((h, 1) -> h.append(1).isEmpty(), 5); // ЗДЕСЬ ОШИБКА

    }

    private static void check(Climb climb, int height) {
        if (climb.isTooHigh(height, 10))
            System.out.println("too high");
        else
            System.out.println("ok");
    }
}
