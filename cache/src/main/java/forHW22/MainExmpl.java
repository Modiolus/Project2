package forHW22;

import org.ehcache.Cache;
import org.ehcache.core.PersistentUserManagedEhcache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class MainExmpl {

    public static void main(String[] args) throws InterruptedException {

//        Map<String, Object> mp1 = new HashMap<String, Object>();
//       // Map<String, Object> mp2 = new HashMap<String, Object>();
//        mp1.put("Petrov", 987);
//        mp1.put("Ivanov", 324);
//        Map<String, Object> mpMaps = new HashMap<String, Object>();
//        mpMaps.put("cache_1", mp1);
//        mpMaps.put("cache_2", mp1);
//        System.out.println(mpMaps);
//        System.out.println(mpMaps.get("cache_1"));
//        System.out.println(mp1.get("Petrov"));

        System.out.println("=====================================");
        CacheCreator cacheCreator = new CacheCreator();
        // System.out.println(cacheCreator.sum(3, 6));
        // cacheCreator.put("cache_1", "Ivanov", 0234);

        cacheCreator.put("cache_1", "Ivanov", "034");
        cacheCreator.put("cache_2", "Petrov", "125");
        cacheCreator.put("cache_3", "Sidorov", "567");
        cacheCreator.put("cache_4", "Dmitriev", "321");

        cacheCreator.get("cache_2", "Petrov");

//        System.out.println(cacheCreator.get("cache_3", "Sidorov"));
//        System.out.println(cacheCreator.get("cache_5", "Sidorov"));
//        System.out.println(cacheCreator.get("cache_3", "Dmitriev"));

        cacheCreator.clear("cache_2");
        cacheCreator.get("cache_2", "Petrov");

        cacheCreator.clear();
        System.out.println("Give all the elements of the map: "+cacheCreator.mpMaps);
        cacheCreator.get("cache_3", "Sidorov");


    }
}
