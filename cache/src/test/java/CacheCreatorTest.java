import forHW22.CacheCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CacheCreatorTest {
    Map<String, Object> map = new HashMap<>();
    private CacheCreator cacheCreator;

    @BeforeEach
    public void newEx() {
        cacheCreator = new CacheCreator();
        cacheCreator.put("cache_1", "Ivanov", "034");
        cacheCreator.put("cache_2", "Petrov", "125");
        cacheCreator.put("cache_3", "Sidorov", "567");
        cacheCreator.put("cache_4", "Dmitriev", "321");
    }

    @Test
    public void putTest() {
        Assertions.assertTrue(cacheCreator.put("cache_1", "Ivanov", "342"));
    }

    @Test
    public void PutTestNeg() {
        Assertions.assertNotEquals(false, cacheCreator.put("cache_1", "Ivanov", "342"));
    }

    @Test
    public void getTest() {
        Assertions.assertEquals("034", cacheCreator.get("cache_1", "Ivanov"));
    }

    @Test
    public void getTestNeg() {
        Assertions.assertNotEquals(null, cacheCreator.get("cache_1", "Ivanov"));
    }

    @Test
    public void clearTest() {
        cacheCreator.clear();
        Assertions.assertEquals(null, cacheCreator.get("cache_3", "Sidorov"));

    }
    @Test
    public void clearTestNeg(){
        cacheCreator.clear();
        Assertions.assertNotEquals("321", cacheCreator.get("cache_4", "Dmitriev"));
    }

//    @Test
//    public void checkMapIsEmpty() {
//        // cacheCreator.clear();
//        int result;
//
////        Map<String, Object> map = new HashMap<>();
////
////        map = (Map<String, Object>) cacheCreator;
//
//        System.out.println(map);
//        cacheCreator.clear();
//        if (map.isEmpty()) {
//    result = 1;
//        }
//        else result = -1;
//        Assertions.assertEquals(1, result);
//    }

    @Test
    public void clearCacheTest() {
        cacheCreator.clear("cache_2");
        Assertions.assertEquals(null, cacheCreator.get("cache_2", "Petrov"));
    }
    @Test
    public void clearCacheTestNeg() {
        cacheCreator.clear("cache_2");
        Assertions.assertNotEquals("125", cacheCreator.get("cache_2", "Petrov"));
    }
}
