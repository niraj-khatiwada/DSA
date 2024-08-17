package Strings;

import java.util.*;

public class Strings {
    // O(n)
    public int numberOfVowels(String str) {
        var set = new HashSet<Character>();
        for (var s : str.toCharArray()) {
            if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
                set.add(s);
            }
        }
        return set.size();
    }

    // O(n)
    public String reverse(String str) {
        var l = 0;
        var r = str.length() - 1;
        var chars = str.toCharArray();
        while (l < r) {
            var ref = chars[l];
            chars[l] = chars[r];
            chars[r] = ref;
            l++;
            r--;
        }
        return new String(chars);
    }

    // O(n)
    public String reverseWords(String phrase) {
        var words = phrase.split(" ");
        var l = 0;
        var r = words.length - 1;
        while (l < r) {
            var ref = words[l];
            words[l] = words[r];
            words[r] = ref;
            l++;
            r--;
        }
        var reversed = new StringBuilder();
        for (var i = 0; i < words.length; i++) {
            reversed.append(String.format("%s%s", words[i], i != (words.length - 1) ? " " : ""));
        }
        return reversed.toString();
    }

    // O(1)
    public boolean isRotation(String a, String b) {
        return String.format("%s%s", a, a).contains(b);
    }

    // O(n)
    public String removeDuplicates(String str) {
        var set = new HashSet<Character>();
        var unique = new StringBuilder();
        for (var s : str.toCharArray()) {
            if (!set.contains(s)) {
                unique.append(s);
                set.add(s);
            }
        }
        return unique.toString();
    }

    // O(n)
    // If you try to use heap, it'll run in O(nlog(n)) so for strings, hash map is
    // better.
    public char mostRepeatedCharacer(String str) {
        var map = new HashMap<Character, Integer>();

        for (var s : str.toCharArray()) {
            map.put(s, (map.get(s) == null ? 0 : map.get(s)) + 1);
        }
        var max = Integer.MIN_VALUE;
        var maxChar = ' ';
        for (var entry : map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (value > max) {
                max = value;
                maxChar = key;
            }
        }
        return maxChar;
    }

    // O(n)
    public String capitalizeFirstLetter(String phrase) {
        var words = phrase.split(" ");
        var str = new StringBuilder();
        for (var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            str.append(String.format("%s%s", words[i], i != (words.length - 1) ? " " : ""));
        }
        return str.toString();
    }

    // O(1) in best case
    // O(n)
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        var map = new HashMap<Character, Integer>();

        for (var ch : a.toCharArray()) {
            map.put(ch, (map.get(ch) == null ? 0 : map.get(ch)) + 1);
        }
        for (var ch : b.toCharArray()) {
            map.put(ch, (map.get(ch) == null ? 0 : map.get(ch)) - 1);
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    // O(n)
    public boolean isPalindrome(String str) {
        var l = 0;
        var r = str.length() - 1;
        var chars = str.toCharArray();
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
