package lekce_310;

import java.util.HashMap;
import java.util.Map;

public class MultitonLazy {
    private static final Map<String, MultitonLazy> instances = new HashMap<>();

    public static synchronized MultitonLazy getInstance(String key) {
        if (!instances.containsKey(key)) instances.put(key, new MultitonLazy());
        return instances.get(key);
    }

    private MultitonLazy(){}
}
