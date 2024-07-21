package StringManipulation;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Stack;

public class StringManipulation {
    public int findNumberOfVowels(String i) {
        var vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        String input = i.toLowerCase();

        var count = 0;

        for (var character : input.toCharArray()) {
            if (vowels.contains(character)) {
                count++;
                vowels.remove(character);
            }
        }

        return count;
    }

    // hello
    // olleh
    public String reverseAString(String input) {

        var reverse = new StringBuilder();

        for (var i = input.length() - 1; i >= 0; i--) {
            reverse.append(input.charAt(i));
        }

        return reverse.toString();
    }

    public String reverseAStringUsingStack(String input) {
        var stack = new Stack<Character>();

        for (var character : input.toCharArray()) {
            stack.add(character);
        }

        var reverse = new StringBuilder();
        while (!stack.isEmpty()) {
            reverse.append(stack.pop());
        }
        return reverse.toString();
    }

    // Hello world
    // world Hello
    public String reverseAWord(String phrase) {

        String[] words = phrase.trim().split(" ");

        var reversed = new StringBuilder();
        for (var i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i] + (i == 0 ? "" : " "));
        }

        return reversed.toString();
    }

    public String reverseAWordUsingStack(String phrase) {
        String[] words = phrase.trim().split(" ");

        var stack = new Stack<String>();
        for (var word : words) {
            stack.add(word);
        }

        var reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            var word = stack.pop();
            reversed.append(word + (stack.size() != 0 ? " " : ""));
        }
        return reversed.toString();
    }

    // Two like ABCD and BCDA are called rotated.
    // ABCD, DABC
    // ABCDABCD
    public boolean areStringsRotated(String a, String b) {
        if (a.length() != b.length() || a.length() == 0) {
            return false;
        }
        return (a + a).contains(b);
    }

    // This is a complex way. Use above method instead.
    public boolean _areStringsRotated(String a, String b) {
        if (a.length() != b.length() || a.length() == 0) {
            return false;
        }

        var length = a.length();

        // We find the position of last item of b in a and start making a new word after
        // that position from a.
        // Finally, we compare that with b
        var lastCharB = b.charAt(length - 1);
        var positionInA = -1;

        var charactersA = a.toCharArray();
        for (var i = 0; i < length; i++) {
            if (charactersA[i] == lastCharB) {
                positionInA = i;
            }
        }
        if (positionInA == -1) {
            return false;
        }
        var currentIndex = 0;
        var str = new StringBuilder();
        while (currentIndex < length) {
            positionInA++;
            if (positionInA >= length) {
                positionInA = 0;
            }
            str.append(charactersA[positionInA]);
            currentIndex++;
        }

        return b.equals(str.toString());
    }

    // Input: “Hellooo!!”
    // Output: “Helo!”
    public String removeDuplicateCharacters(String str) {
        var set = new HashSet<Character>();
        var unique = new StringBuilder();
        for (var character : str.toCharArray()) {
            if (!set.contains(character)) {
                set.add(character);
                unique.append(character);
            }
        }

        return unique.toString();
    }

    // helloo -> l (first one)
    public Character mostRepeatedCharacter(String str) {
        var map = new HashMap<Character, Integer>();

        for (var c : str.toCharArray()) {
            var value = map.get(c);
            map.put(c, value == null ? 1 : (value + 1));
        }
        var maxValue = Integer.MIN_VALUE;
        var character = '-';
        for (var ch : str.toCharArray()) {
            var count = map.get(ch);
            if (count > maxValue) {
                maxValue = count;
                character = ch;
            }
        }
        return character;
    }

    // Let's assume we cannot use HashMap in this case
    // Also assume that the string only
    // contains ASCII value. We have total 256 ASCII characters.
    public Character mostRepeatedCharacterASCII(String str) {
        var asciis = new int[256];
        for (var ch : str.toCharArray()) {
            var asciiValue = (int) ch - 0;
            asciis[asciiValue] += 1;
        }

        var maxValue = Integer.MIN_VALUE;
        var character = '-';
        for (var ch : str.toCharArray()) {
            var asciiValue = (int) ch - 0;
            if (asciis[asciiValue] > maxValue) {
                maxValue = asciis[asciiValue];
                character = ch;
            }
        }

        return character;
    }
}
