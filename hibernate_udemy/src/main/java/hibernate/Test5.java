package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // try catch используется на случай, если вылетит исключение то factory точно закроется
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); // открытие транзакции

//            Удаление объекта:
//            сначала получаем, затем удаляем
//            Employee emp = session.get(Employee.class, 1);
//            session.delete(emp);

//            если мы не получили объект и нужны более узкие условия
//            то пишем запрос
//            session.createQuery("delete Employee " +
//                            "where name = 'Aleksandr'")
//                    .executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
