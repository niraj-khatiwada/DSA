package StringManipulation;

import java.util.HashSet;
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
}
