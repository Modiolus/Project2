package forHW22;

public interface CacheHW {

    boolean put(String cache, String kay, Object o);

    Object get(String cache, String key);

    void clear();

    void clear(String cache);

}
