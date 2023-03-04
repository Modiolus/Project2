package forHW22;

import lombok.AllArgsConstructor;
import org.ehcache.Cache;

@AllArgsConstructor
public class EmployeeOne {
    private CacheCreator cache;

//    public Employee getUserById(int id) throws InterruptedException {
//
//        Cache ch = cache.getEmployeeCache();
//        if (ch.containsKey(id)) {
//            System.out.println("get value from cache");
//            return (Employee) ch.get(id);
//        } else {
//            System.out.println(String.format("value not found in cache with id : %s", id));
//        }
//
//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(1000);
//            System.out.print("#");
//        }
//        System.out.println();
//        System.out.println("get value from DB");
//        Employee user = new Employee(id, "Ivan", "Ivanov", 27, "phone", "email");
//        ch.put(id, user);
//
//        return user;
//    }



}
