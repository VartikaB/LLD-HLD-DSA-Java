import java.util.HashMap;

public class Logger {

    HashMap<String, Integer> mp = new HashMap<>();

    public boolean couldPrintMessage(int timestamp, String message) {

        if (!mp.containsKey(message)) {
            mp.put(message, timestamp);
            return true;
        }
        else {
            if (timestamp - mp.get(message) < 10) {
                return false;
            }

            mp.put(message, timestamp);
            return true;
        }
    }
}
