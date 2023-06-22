package HashTables;

import java.util.HashMap;
import java.util.Map;

public class MostRepeatedElement {
    Map<Integer, Integer> map = new HashMap();

    // O(n)
    public int mostRepeatedElement(int[] array) {
        for (int item : array) {
            this.map.put(item, this.map.containsKey(item) ? this.map.get(item) + 1 : 1);
        }
        int highestOccurrence = array[0];
        int highestOccurrenceCount = 0;
        for (var entry : this.map.entrySet()) {
            if (entry.getValue() > highestOccurrenceCount) {
                highestOccurrence = entry.getKey();
                highestOccurrenceCount = entry.getValue();
            }
        }
        return highestOccurrence;
    }

}
