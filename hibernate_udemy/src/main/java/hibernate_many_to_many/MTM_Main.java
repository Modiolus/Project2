package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MTM_Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
//            внесение данных: в одну секцию несколько детей
//            session = factory.getCurrentSession();
//            Section section1 = new Section("Football");
//
//            Child child1 = new Child("Zaur", 5);
//            Child child2 = new Child("Masha", 7);
//            Child child3 = new Child("Vasya", 6);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.save(section1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//=====================================================================================

//          внесение данных: одного ребенка в несколько секций
//            session = factory.getCurrentSession();
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//
//            Child child1 = new Child("Igor", 10);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//====================================================================
//            получение данных по секции и детям в ней
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//=========================================================================
//           получение информации по ребенку и его секциям
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 4);
//
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//=========================================================================
//          удаление секции
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Section section = session.get(Section.class, 1);
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//======================================================================================
//======================================================================================
////           внесение данных когда cascade НЕ All
////           после beginTransaction сохранение сессии не приведет к каскадному добавлению детей(каскадного сохранения не будет)
////           поэтому после сохранения секции, необходимо добавить каждого ребенка и сохранить каждого
//            session = factory.getCurrentSession();
//            Section section1 = new Section("Football");
//
//            Child child1 = new Child("Zaur", 5);
//            Child child2 = new Child("Masha", 7);
//            Child child3 = new Child("Vasya", 6);
//
//            session.beginTransaction();
//            session.save(section1);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.save(child1);
//            session.save(child2);
//            session.save(child3);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//========================================================================================
//           внесение данных когда cascade НЕ All
//           ВСЁ-ТАКИ ЭТО ВОЗМОЖНО! Для этого код остается как при All и добавляется session.persist
//           после beginTransaction сохранение сессии не приведет к каскадному добавлению детей(каскадного сохранения не будет)
//           поэтому после сохранения секции необходимо добавить каждого ребенка и сохранить каждого
//            session = factory.getCurrentSession();
//            Section section1 = new Section("Dance");
//
//            Child child1 = new Child("Olya", 12);
//            Child child2 = new Child("Grisha", 8);
//            Child child3 = new Child("Pavlik", 9);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//            session.persist(section1);   // persist позволяет каскадно сохранить данные из двух таблиц при этом cascade НЕ All
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//=====================================================================================================
//            удаление секции когда cascade НЕ All
//            дети не удалятся при удалении секции т.к. cascade НЕ All
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 6);
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//=====================================================================================================================================
//            удаление ребенка когда cascade НЕ All
//            секция не удалится при удалении детей т.к. cascade НЕ All
            session = factory.getCurrentSession();

            session.beginTransaction();

            Child child = session.get(Child.class, 5);
            session.delete(child);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }

    }
}
