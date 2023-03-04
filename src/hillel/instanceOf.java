package hillel;

public class instanceOf {


    public static void main(String[] args) {

        Integer x = new Integer(22);
        System.out.println(x instanceof Integer);
        // был ли объект на который ссылается Х создан на основе класса Integer ?
        // ВАЖНО!! instanceof проверяет именно происхождение объкта, а не переменной !


    }
}

