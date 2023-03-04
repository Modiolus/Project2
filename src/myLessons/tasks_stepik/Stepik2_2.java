package myLessons.tasks_stepik;

public class Stepik2_2 {

    public static char charExpression(int a) {
        char c = '\\';

        return (char) (c + a);
    }


    public static void main(String[] args) {

        int i1 = (char) 'a';
        int i2 = (char) 'b';

        System.out.println(Stepik2_2.charExpression(1));



        char c1 = '\\';
        char c2 = ']';
        System.out.println((int) c1);
        System.out.println((int) c2);
    }

}
