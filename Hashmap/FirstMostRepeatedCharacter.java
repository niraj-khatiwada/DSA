package Hashmap;

import java.lang.Character;
import java.util.HashMap;

// First least repeated count
// banana -> a is first repeated thrice.
public class FirstMostRepeatedCharacter {
    public Character find(String in) {
        var map = new HashMap<Character, Integer>();
        var input = in.toLowerCase();
        for (var c : input.toCharArray()) {
            map.put(c, (map.containsKey(c) ? map.get(c) : 0) + 1);
        }

        char mostCharacter = input.charAt(0);
        int maxCount = map.get(mostCharacter);
        for (var i = 1; i < input.length(); i++) {
            var key = input.charAt(i);
            if (key != ' ') {
                var value = map.get(key);
                if (value > maxCount) {
                    mostCharacter = key;
                    maxCount = value;
                }
            }
        }
        return mostCharacter;
    }
}
