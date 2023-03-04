package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //создает сессии на основе конфиг файла
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
//==================Второй способ создания factory, как пример======================================
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class);
        SessionFactory factory1 = configuration.buildSessionFactory();
//=================================================================================

        // try catch используется на случай, если вылетит исключение то factory точно закроется
        try {
            // Session - это обертака для подключения к базе с помощью JDBC
            Session session = factory.getCurrentSession(); // получает текущую сессию
// factory испольузется многоразово, а вот сессия используется на момент подключения к БД, а потом закрывается
            Employee emp = new Employee("Aleksandr", "Smirnov"
                    , "Sales", 700);
            session.beginTransaction(); // открытие транзакции

            session.save(emp); // здесь hibernate инсертит данные в БД
            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД
//        session.getTransaction().rollback(); // откатывает назад то что было заведено в save
        } finally {
            factory.close();
        }

    }
}
