package Hashmap;

import java.lang.Character;
import java.util.HashMap;

// No repeat at all.
// banana -> b is not repeated
public class FirstNonRepeatedCharacter {
    public Character find(String in) {
        var map = new HashMap<Character, Integer>();
        var input = in.toLowerCase();
        for (var c : input.toCharArray()) {
            map.put(c, (map.containsKey(c) ? map.get(c) : 0) + 1);
        }
        for (var i = 1; i < input.length(); i++) {
            var key = input.charAt(i);
            if (key != ' ') {
                var value = map.get(key);
                if (value == 1) {
                    return key;
                }
            }
        }

        return input.charAt(0);
    }
}
