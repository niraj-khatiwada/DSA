package HashTables;

import java.util.HashSet;
import java.util.Set;

// green apple
// [g, r, e, ]

public class FirstRepeatedCharacter {

    public static Character firstRepeatedCharacter(String string) {
        Set<Character> set = new HashSet<>();

        Character value = null;
        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            if (set.contains(character)) {
                value = character;
                break;
            }
            set.add(character);
        }
        return value;
    }

}
