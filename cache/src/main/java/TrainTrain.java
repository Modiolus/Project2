import java.util.HashMap;
import java.util.Map;

public class TrainTrain {

    public static void main(String[] args) {
        String s = String.format("Как дела у %s", "Андрей");
        String s1 = String.format("Как дела у %s", "Андрей");

        System.out.println(s);

        Map<String, Object> map = new HashMap<>();
        map.put("Test_1", "234");
        map.put("Test_2", "654");
        System.out.println(map.isEmpty());
    }
}
