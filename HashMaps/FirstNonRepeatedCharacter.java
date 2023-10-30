package HashMaps;

import java.util.HashMap;

public class FirstNonRepeatedCharacter {
    public static char findFirstNonRepeatedCharacter(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character character : string.toCharArray()) {
            Character c = Character.toLowerCase(character);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        char value = ' ';
        for (Character character : string.toCharArray()) {
            if (map.get(Character.toLowerCase(character)) == 1) {
                value = character;
                break;
            }
        }
        return value;
    }
}