package MainDirectory;

import java.util.HashMap;
import java.util.Map;

public class SharedDictionary {
    private final Map<String, Object> sharedMap = new HashMap();

    public SharedDictionary() {
    }

    public void addDict(String key, Object value) {
        this.sharedMap.put(key, value);
    }

    public Object readDict(String key) {
        return this.sharedMap.get(key);
    }

    public boolean containsKey(String key) {
        return this.sharedMap.containsKey(key);
    }

    public void clearDictionary() {
        this.sharedMap.clear();
    }
}