import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnEx {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//пример проверки подключения к базе данных. В этом же пакете в Main всё тоже самое
        Class.forName("com.mysql.cj.jdbc.Driver");
        int i = 1;
       // while (true) {
            System.out.println(i++);
            System.out.println();
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/hillel?"
                            + "useSSL=false&user=root&password=root&serverTimezone=UTC");
        System.out.println(connection.getCatalog());
      //   }
    }
}
