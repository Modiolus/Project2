package myLessons.nestedClasses.anonymousClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnonymousClass {
    private int x = 5;
//Анонимные классы используютя когда нужно создать класс ЕДИНОРАЗОВО на ходу
    // это полноценный внутренний класс, имеющий доступ к переменным внешнего класса в том числе к статическим и приватным
    // анонимный класс не может содержать статические переменные и методы
    static int slojenie(TrTest trTest) {
        return trTest.methodTest(2, 5);
        //  System.out.println(trTest.methodTest(2, 5)); // если метод void
    }

    public static void main(String[] args) {
        // после этого -> знака идёт реализация метода интерфейса

        System.out.println(slojenie((f, g) -> f * g));
        System.out.println(slojenie(Integer::sum)); // второй вариант написания предидущей строки но действие сумма
        System.out.println(slojenie(Math::multiplyExact));// а здесь уже умножение

        /*так изображается анонимный класс от интерфейса*/
        TrTest tr = new TrTest() {
            @Override
            public int methodTest(int c, int d) {
                return c * d;
            }
        };
        TrTest trTest = (c, d) -> c * d; // Это лямбда - сокращенное написание анонимного класса от интерфейса

        /*также изображается анонимный класс от класса(см. пример под текстом ниже)
         * т.е. некий неизвестный класс объект котрого m, симплементировал интерфейс Math. Вместо интерефейса может быть просто класс -->
         * --> и в таком случае будет тоже самое только не имплементация, а переопределение метода!
         * таким образом не нужно создавать отдельный класс и его экземпляр
         * Анонимный класс используется когда мы хотим на ходу создать объект класса не создавая отдельный класс и его экземпляр. И позволяет
         * воспользоваться объектом один раз. Если необходимо вопсользоваться объектом несколько раз, то лучше создать отдельный класс,
         * затем его экземляр и от экземпляра уже оверрайдиться как обычно
         * У анонимных классов не может быть конструктора т.к. для создания констр нужно название класса, а его нет у анонимного класса!
         * Lambda выражения - является сокращенной версией написания анонимных классов
         * понятие анонимный интерфейс - не существует!*/

        Math2 m = new Math2() {
            @Override
            public int doOperation(int a, int b) {
                AnonymousClass ac = new AnonymousClass(); // так анонимный клас может обратиться к private переменнй внешнего класса
                 //  return a + b + ac.x;
                return a * b; // на самом деле сюда можно плюсовать или умножать все что угодно даже метод + doOperation(3, 8)

            }

        };


//            // в этом месте можно писать переменнные или методы


        // так анонимный клас может обратиться к private переменнй внешнего класса
//                AnonymousClass ac = new AnonymousClass();
//                return a + b + ac.x;

        //       System.out.println(m.doOperation(3, 6));

    }
}

class Math2 implements TrTest {

    int doOperation(int a, int b) {
        return a / b;
    }

    @Override
    public int methodTest(int c, int d) {
        return 0;
    }
}

interface TrTest {
    int methodTest(int c, int d);
}
