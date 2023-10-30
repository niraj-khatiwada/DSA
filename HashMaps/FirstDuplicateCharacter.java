package HashMaps;

import java.util.HashMap;
import java.util.Stack;

public class FirstDuplicateCharacter {

    // example : "a green apple"
    // output should be 'e'
    public static Character findFirstAdjacentDuplicateCharacter(String string) {

        Stack<Character> stack = new Stack<>();

        char result = ' ';
        for (Character character : string.toCharArray()) {
            char c = Character.toLowerCase(character);
            if (stack.size() > 0 && stack.peek() == c) {
                result = c;
                break;
            }
            stack.push(c);
        }

        return result;
    }

    // Using HashMap
    // example : "a green apple"
    // output should be 'a'
    public static Character findFirstDuplicateCharacterUsingHashMap(String string) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (Character character : string.toCharArray()) {
            Character c = Character.toLowerCase(character);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        char result = ' ';
        for (Character character : string.toCharArray()) {
            Character c = Character.toLowerCase(character);
            if (map.get(c) > 1) {
                result = c;
                break;
            }
        }
        return result;
    }
}