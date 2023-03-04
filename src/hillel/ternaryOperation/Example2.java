package hillel.ternaryOperation;

public class Example2 {

    public static void main(String[] args) {
        int a = 15;
        int b = 20;
        if (a < b) {
            System.out.println("a < b");
        } else if (a == b) {
            System.out.println("a == b");
        } else if (a > b) {
            System.out.println("a > b");
        }
        /*тернарный аператор используя результаты метода compare при true выдаст 1 при false выдаст 0*/
        System.out.println(compare(a, b) ? 1 : 0);
        System.out.println(compare(b, a) ? 1 : 0);
    }
    /*содаем метод котрый возвращает логический результат */
    static boolean compare(int a, int b) {
        return a < b;
    }

}
