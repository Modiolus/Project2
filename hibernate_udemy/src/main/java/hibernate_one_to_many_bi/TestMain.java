package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;

import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        // try catch используется на случай, если вылетит исключение то factory точно закроется
        try {
////            внесение а табицы БД
//            session = factory.getCurrentSession();
//
//            Department dep = new Department("Sales",
//                    800, 1500);
//
//            Employee emp1 = new Employee("Zaur",
//                    "Tregulov", 800);
//            Employee emp2 = new Employee("Elena",
//                    "Smirnova", 1500);
//            Employee emp3 = new Employee("Anton",
//                    "Sidorov", 1200);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//            session.save(dep); // прописывая dep сохранится и департамент и за ним работники
//
//            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД
//===================================================================================================
//           получение данных из таблиц БД. Сначала департамент а потом всех работников в нём
//           Это возможно благодаря двустронней связи
            session = factory.getCurrentSession();

            session.beginTransaction();

            Department department = session.get(Department.class,
                    3);
            System.out.println(department);
            System.out.println(department.getEmps());
//            System.out.println("->> " + department.getEmps().get(0));
//          =========================================================
// !!!! Ещё один способ внесения человека в департамент(способ у Алышева, похоже минуя метод addEmployeeToDepartment, кторый создавал в Employee Заур)
//      При этом конечно же создаётся соотвутствующий конструктор
//            Employee employee = new Employee("Taras", "Topolya", 700, department);
//            session.save(employee);
//          =========================================================
            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД
//            System.out.println(department.getEmps());
//=================================================================================
//         получение данных из таблиц БД. Сначала работника а потом его департамент
//         Это возможно благодаря двустронней связи
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД
//            =======================================================================
//          Удаление данных

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee); // если так сделать то удалятся абсолютно все и работники и департаменты из-за cascade = CascadeType.ALL
//            // для этого переписываем в обоих классах Cascade
//            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД

        } finally {
            session.close();
            factory.close();

        }

    }
}
