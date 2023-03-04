package hillel.HW12lesson13;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {
//Task 1
        List<Integer> numbers = List.of(1, 2, 5, 4, 10);

        System.out.println(numbers);
        Double average = numbers.stream().mapToDouble(e -> e).average().getAsDouble();
        System.out.println("Average: " + average(numbers));

//Task 2
        List<String> str = List.of("one", "two", "three", "four");
        for (String j : str)
            System.out.print(j + ", ");

        System.out.println();
        Map<String, String> map = str
                .stream()
                .collect(Collectors.toMap(i -> i, i -> i.toUpperCase()));
        //  for (Map.Entry i : map.entrySet()) System.out.print(i.getKey() + " - " + i.getValue() + "; ");
        System.out.println("Map: " + toUpper(str));

        //Task3=============================================
        System.out.println();
        List<String> listStr = List.of("Green", "Grey", "orange", "blue", "Black", "white", "Red", "pink");
        listStr.stream()
                .filter(e -> e.contains(e.toLowerCase()) && e.length() == 4)
                //.filter(e -> e.length() == 4)
                .collect(Collectors.toList());
        //.forEach(e -> System.out.print(e + " ")); // вывод через операции стримов
        System.out.println("Filter: " + filter(listStr)); // вывод через метод

    }

    public static List<String> filter(Collection<String> s) {
        return s.stream()
                .filter(e -> e.contains(e.toLowerCase()) && e.length() == 4)
                .collect(Collectors.toList());


    }

    public static Map<String, String> toUpper(List<String> s) {
        //  Map<String, String> map = s.stream()
        //          .collect(Collectors.toMap(i -> i, i -> i.toUpperCase()));
        Map<String, String> map = s.stream()
                .collect(Collectors.toMap(i -> i, i -> i.toUpperCase()));
        // // for (Map.Entry i : map.entrySet()) System.out.print(i.getKey() + " - " + i.getValue() + "; ");
        return map;
    }


    public static double average(List<Integer> n) {
        return n.stream().mapToDouble(e -> e).average().getAsDouble();

    }

}
