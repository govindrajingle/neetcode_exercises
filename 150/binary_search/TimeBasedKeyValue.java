import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValue {

    Map<String, List<Pair>> map;

    public TimeBasedKeyValue() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        String result = "";
        List<Pair> list = map.get(key);
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                // R: Save result and move to right
                result = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

class Pair {
    String value;
    int timestamp;

    Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}