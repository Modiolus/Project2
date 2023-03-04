import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/hillel";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager
//                .getConnection("jdbc:mysql://localhost:3306/hillel?"
//                        + "useSSL=false&user=root&password=root&serverTimezone=UTC");

        Connection connection = DriverManager
                .getConnection(URL, USER, PASS);

        System.out.println(connection.getCatalog());
//
//
        Statement statement = connection.createStatement();
        // ResultSet rs = statement.executeQuery("select * from user where active = 1 and age > 18 and age <= 28 order By age, last_name");
        ResultSet rs = statement.executeQuery("select * from user");
        System.out.println("Table name : " + rs.getMetaData().getTableName(1));
        System.out.println("------------");
        int columnCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print("column name : " + rs.getMetaData().getColumnName(i) + ", ");
            System.out.print("column size : " + rs.getMetaData().getColumnDisplaySize(i) + ", ");
            System.out.println("column type : " + rs.getMetaData().getColumnTypeName(i));
        }
        List<User> students = new ArrayList<>();
      //  List<Map<String, String>> userMap = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String fn = rs.getString("first_name");
            String ln = rs.getString("last_name");
            String pn = rs.getString("pasport_number");
            String phone = rs.getString("phone");
            String sex = rs.getString("sex");

            students.add(new User(id, age, fn, ln, pn, phone, sex));

        }
        System.out.println("Size: " + students.size());
        System.out.println("Users -->>");
        // students.forEach(System.out::println); // вывод через лямбду Consumer
        for (User user : students)
            System.out.println(user);


        System.out.println("=============================================");
        // ниже способ завода в мапу и потом в лист userMap. Колонки и их значения снала заводяся в мапу, а затем мапа заводится
        // в линкедлист userMap. Но в таком случае вывод в перемешку т.к. мапа не хранит  порядок
        // вывод выше красивее и нагляднее.
//            Map<String, String> uMap = new HashMap<>();
//            for (int i = 1; i <= columnCount; i++) {
//                String name = rs.getMetaData().getColumnName(i);
//                String value = rs.getString(rs.getMetaData().getColumnName(i));
//
//                uMap.put(name, value);
//            }
//            userMap.add(uMap);

        // Выводил мапу на экран просто, чтобы промежуточно посмотреть корректность замапенных объектов в ней
//            System.out.println("uMap: ");
//            for (Map.Entry<String, String> m : uMap.entrySet()) {
//                System.out.println(m.getKey() + " : " + m.getValue());
//
//            }
//            uMap.forEach((q,w)-> System.out.println(q + " : "+ w)); // способ вывода через лямбду
//            System.out.println("=======================================================");
//        }

//        System.out.println("UserMap -->> ");
//        for (Map map : userMap) {
//            System.out.println(map);// вывод листа userMap
//        }
        //System.out.println(userMap);

// Если нужно создать несколько запросов, то целесообразно использовать PreparedStatement
// ниже разные варианты выводов с листами и с мапой
//        PreparedStatement preparedStatement = connection.prepareStatement("insert into address(city, country) values (?, ?)");
//        List<String> cities = List.of("Berlin", "London", "Paris", "Madrid");
//        List<String> countries = List.of("Germany", "Great Britain", "France", "Madrid");
//
//        Map<String, String> map = new HashMap<>();
//        map.put("Dresden", "Germany");
//        map.put("Manchester", "Great Britain");
//        map.put("Marcel", "France");
//        map.put("Barcelona", "Spain");
//        for (Map.Entry<String, String> entry : map.entrySet()){
//            preparedStatement.setString(1, entry.getKey());
//            preparedStatement.setString(2, entry.getValue());
//            preparedStatement.executeUpdate();
//        }
//        for (int i = 0; i < cities.size(); i++) {
//            preparedStatement.setString(1, cities.get(i));
//            preparedStatement.setString(2, countries.get(i));
//            preparedStatement.executeUpdate();
//        }
//
//        for (String city : cities) {
//            preparedStatement.setString(1, city);
//            preparedStatement.setString(2, "Europe");
//            preparedStatement.executeUpdate();
//        }
//
//        Statement st = connection.createStatement();
//        st.executeQuery("insert into address(country) value ('Spain') ");
//
        connection.close();
    }
}
