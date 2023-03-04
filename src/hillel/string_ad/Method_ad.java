package hillel.string_ad;

public class Method_ad {
    public static void main(String[] args) {
        /*некоторые обновленные методы в String */
        String str1 = " ";
        String str2 = "work" + "" + "hard";

        System.out.println(str1.isEmpty()); //выводит, true если в стринге ничего нет
        System.out.println(str2.isBlank()); //проверяет на наличие пробелов(true, false)

        String s = "Welcome";
        String s4 = "Presto";
        System.out.println(s4);

        String s2 = "Drink";
        char[] s3 = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(s.concat(s2));
        System.out.println(s.concat(", ").concat(s2)); // объединяет строки

        System.out.println(String.valueOf(s3));//строковое представление любого передаваемого аргумента
        System.out.println(String.join(", ", s, s2, str2)); // объединяет через, указанный разделитель

        System.out.println(s.compareTo(s2));// сравнивает лексически. Если аргумент меньше,
        // то возвращает больше 0 и наоборот. Если равны, то 0
        System.out.println(s.charAt(2));
        System.out.println(s.equals(s2));

        System.out.println(s.regionMatches(1, s4, 2, 1));// Производит сравнение: с 1 элемента
        //одного стринга, 2 элемента вторго стринга  указываем количество сравниваемых элементов.
        // также есть возможность игнорировать большие буквы
        System.out.println(s.indexOf('e')); // находит индекс первой буквы e
        System.out.println(s.lastIndexOf('e')); // находит индекс последней буквы e




    }
}
