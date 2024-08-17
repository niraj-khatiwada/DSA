package Backtracking;

import java.util.*;

public class Backtracking {
    // TC: O(n * 2^n)
    // SC: O(n): Requires n callstack for n length string
    public List<String> findSubsets(String str) {
        var list = new ArrayList<String>();
        this._findSubsets(str, new StringBuilder(), 0, list);
        return list;
    }

    private void _findSubsets(String str, StringBuilder ans, int i, List<String> list) {
        if (i >= str.length()) {
            list.add(ans.toString());
            return;
        }
        var ansRef = new StringBuilder(ans);
        _findSubsets(str, ans.append(str.toCharArray()[i]), i + 1, list);
        _findSubsets(str, ansRef, i + 1, list);

    }

    // TC: O(n * n!)
    // SC: O(n)
    public List<String> findPermutations(String str) {
        var list = new ArrayList<String>();
        this._findPermutations(new StringBuilder(str), new StringBuilder(), list);
        return list;
    }

    private void _findPermutations(StringBuilder str, StringBuilder ans, List<String> list) {
        if (str.length() == 0) {
            list.add(ans.toString());
            return;
        }
        var chars = str.toString().toCharArray();
        for (var i = 0; i < chars.length; i++) {
            _findPermutations(new StringBuilder(str.substring(0, i) + str.substring(i + 1)),
                    new StringBuilder(ans.toString() + chars[i]), list);
        }
    }
}
