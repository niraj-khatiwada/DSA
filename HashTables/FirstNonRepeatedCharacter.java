package HashTables;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static Character firstNonRepeatedCharacter(String string) {
        string = string.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            map.put(character, map.containsKey(character) ? (map.get(character) + 1) : 1);
        }
        System.out.println(map);
        Character finalValue = null;
        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            if (map.get(character) == 1) {
                finalValue = character;
                break;
            }

        }
        return finalValue;
    }
}
