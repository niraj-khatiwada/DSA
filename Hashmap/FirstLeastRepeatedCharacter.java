package Hashmap;

import java.lang.Character;
import java.util.HashMap;

// First least repeated count
// nanana -> n is first repeated thrice.
public class FirstLeastRepeatedCharacter {
    public Character find(String in) {
        var map = new HashMap<Character, Integer>();
        var input = in.toLowerCase();
        for (var c : input.toCharArray()) {
            map.put(c, (map.containsKey(c) ? map.get(c) : 0) + 1);
        }

        char minCharacter = input.charAt(0);
        int minCount = map.get(minCharacter);
        for (var i = 1; i < input.length(); i++) {
            var key = input.charAt(i);
            if (key != ' ') {
                var value = map.get(key);
                if (value < minCount) {
                    minCharacter = key;
                    minCount = value;
                }
            }
        }
        return minCharacter;
    }
}
