package hillel.ternaryOperation;

public class TernOper_Ex {
    public static void main(String[] args) {
        int a = -10;
        int b = 0;
        /*тернарный оператор. а<b если да, то выводится 1, если нет то выводится 2*/
        int result = a < b ? 1 : 2 ;
        System.out.println(result);
        System.out.println("Второй вариант: ");
        b = a < 0 ? -a : a; //в данном случае b<0 и тогда минус на минус дал + и вывод 10
        System.out.println(b);
    }
}
