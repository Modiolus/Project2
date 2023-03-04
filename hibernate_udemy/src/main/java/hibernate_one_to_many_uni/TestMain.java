package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
//            внесение а табицы БД
//            session = factory.getCurrentSession();
//
//            Department dep = new Department("HR",
//                    500, 1500);
//
//            Employee emp1 = new Employee("Oleg",
//                    "Ivanov", 800);
//            Employee emp2 = new Employee("Andrey",
//                    "Sidorov", 1000);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//            session.save(dep); // прописывая dep сохранится и департамент и за ним работники т.к. CascadeType.ALL
//
//            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД

//===================================================================================================
//           получение данных из таблиц БД. Сначала департамент а потом всех работников в нём
//           Это возможно благодаря двустронней связи
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Department department = session.get(Department.class, 1);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД

//=================================================================================
//         получение данных из таблиц БД. Сначала работника а потом его департамент
//         Это возможно благодаря двустронней связи
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
////            System.out.println(employee.getDepartment()); // эта строка не имеесмысла т.к. класс работник не имеет ссылки на департамент
//
//            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД

//            =======================================================================
//          Удаление данных

            session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 2);
//            session.delete(employee); // удалится только работник и НЕ удалится его департамент т.к класс работник не имеет ссылки на департамент

            Department department = session.get(Department.class, 2);
            // удалит департамент и всех связанных с ним работников т.к. класс депарамент связан с классом работник связью @OneToMany
            session.delete(department);


            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД

        } finally {
            session.close();
            factory.close();

        }


    }
}
