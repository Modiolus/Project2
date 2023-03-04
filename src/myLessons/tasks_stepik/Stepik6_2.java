package myLessons.tasks_stepik;

import java.util.HashSet;
import java.util.Set;

public class Stepik6_2 {
/*Реализуйте метод, вычисляющий симметрическую разность двух множеств.

Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

Пример:

Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
*/

    /*   ==================Для справки некоторые подкапотные методы сетов===================================
    s1.containsAll(s2) - возвращает true, если s2 - подмножество s1. (s2 является подмножество s1, если множество s1 содержит все элементы из s2.)

s1.addAll(s2) - преобразует s1 в объединение s1 и s2. (The объединение двух множеств - это множество, содержащее все элементы, содержащиеся в любом наборе.)

s1.retainAll(s2) - преобразует s1 в пересечение s1 и s2. (сохранит все общее.)

s1.removeAll(s2) - Удалит всё общее! преобразует s1 в (асимметричный) набор разность s1 и s2. (Например, заданное различие s1 минус s2 - это множество, содержащее все элементы, найденные в s1, но не в s2.)

==============================================================================================================
*/
    public static void main(String[] args) {
//====================Решение частное с рименением реальных сетов, в отличие от универсального метода осованного на этих реальных сетах==================
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        Set<Integer> s2 = new HashSet<>();
        s2.add(0);
        s2.add(1);
        s2.add(2);

        Set<Integer> temps1 = new HashSet<>();
        temps1.addAll(s1);
        Set<Integer> temps2 = new HashSet<>();
        temps2.addAll(s2);

        Set<Integer> result = new HashSet<>();

        result.addAll(s2);
        result.removeAll(s1);
        temps1.removeAll(s2);
        result.addAll(temps1);
//==================================================================================
        System.out.println("Результат унивесального меода-> " + symmetricDifference(s1, s2)); // непосредственная проверка метода

        System.out.println("result-> " + result);

    }

    //    ниже универсальный метод
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> temps1 = new HashSet<>();
        temps1.addAll(set1);
        Set<T> temps2 = new HashSet<>();
        temps2.addAll(set2);
        Set<T> res = new HashSet<>();
        res.addAll(set2);
        res.removeAll(set1);
        temps1.removeAll(set2);
        res.addAll(temps1);

        return res;
    }

    public static <T> Set<T> symmetricDifference1(Set<? extends T> set1, Set<? extends T> set2) {
        return new HashSet<>() {
            {
                addAll(new HashSet<T>(set1) {{
                    removeAll(set2);
                }});
                addAll(new HashSet<T>(set2) {{
                    removeAll(set1);
                }});

            }
        };
    }

}
