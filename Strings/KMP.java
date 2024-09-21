package Strings;

public class KMP {
    // O(n+m)
    public boolean hasSubstring(String str, String substr) {
        var lps = _constructLPS(str, substr);
        int i = 0, j = 0;
        while (i < str.length() && j < substr.length()) {
            if (str.charAt(i) == substr.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j == substr.length();

    }

    private int[] _constructLPS(String str, String substr) {
        var lps = new int[substr.length()];

        int prevLPS = 0, i = 1;

        while (i < lps.length) {
            if (substr.charAt(i) == substr.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            } else {
                if (prevLPS == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLPS = lps[prevLPS - 1];
                }
            }
        }

        return lps;
    }
}
