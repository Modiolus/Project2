package hillel.lesson4;

public class Stack {
    public static void main(String[] args) {

        int k = 0;
        for (int i = 0; i < 5; i++) {
            fr(i);
            for (int j = 0; j < 5; j++) {
                sec(j);
            }
            int s = 9;
        }
    }
    private  static  void fr(int i) {
        System.out.println(i);
    }
    private  static  void sec(int j) {
        System.out.println(j);
    }
}
