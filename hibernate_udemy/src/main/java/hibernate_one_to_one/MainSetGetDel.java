package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainSetGetDel {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        // try catch используется на случай, если вылетит исключение то factory точно закроется
        try {
//            вставка в базу
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Zaur", "Tregolov", "IT", 500);
//
//            Detail detail = new Detail("Baku", "1232323", "zaurtregulov@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction(); // открытие транзакции
//
//            session.save(employee);
//
//
//            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД
////        session.getTransaction().rollback(); // откатывает назад то что было заведено в save
//        } finally {
//            factory.close();
//        }
// ===============================================================================
//            вставка в базу
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
//
//            Detail detail = new Detail("Moscow", "9555675", "olejka@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction(); // открытие транзакции
//
//            session.save(employee);
//
//            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД
////        session.getTransaction().rollback(); // откатывает назад то что было заведено в save
// ===========================================================================================
//            получение из базы
            Session session = factory.getCurrentSession();
            session.beginTransaction(); // открытие транзакции
        //получение из базы
            Employee emp = session.get(Employee.class, 2);
//            System.out.println(emp.getEmpDetail());

//            удаление из базы
            session.delete(emp);

            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД
//        session.getTransaction().rollback(); // откатывает назад то что было заведено в save

        } finally {

            factory.close();
        }

    }
}
