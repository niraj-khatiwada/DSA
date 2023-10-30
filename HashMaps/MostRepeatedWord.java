package HashMaps;

import java.util.HashMap;

// For example "a green apple on green field."
// Output = "green"
public class MostRepeatedWord {
    public static String findMostRepeatedWord(String phrase) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : phrase.split(" ")) {
            String formattedString = word.trim().toLowerCase();
            map.put(formattedString, map.containsKey(formattedString) ? map.get(formattedString) + 1 : 1);
        }

        String result = "";
        for (String word : phrase.split(" ")) {
            String formattedString = word.trim().toLowerCase();
            if (map.get(formattedString) > 1) {
                result = formattedString;
                break;
            }
        }

        return result;
    }
}