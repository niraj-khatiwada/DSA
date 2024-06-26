package Hashmap;

import java.util.HashMap;;

// First repeated count
// banana -> a is first repeated
public class FirstRepeatedCharacter {
    public Character find(String in) {
        var input = in.toLowerCase();
        var map = new HashMap<Character, Integer>();

        for (var c : input.toCharArray()) {
            map.put(c, (map.containsKey(c) ? map.get(c) : 0) + 1);
        }

        for (var i = 0; i < input.length(); i++) {
            var key = input.charAt(i);
            if (key != ' ') {
                var value = map.get(key);
                if (value > 1) {
                    return key;
                }
            }
        }
        return input.charAt(0);
    }
}
