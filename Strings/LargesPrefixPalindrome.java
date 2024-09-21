package Strings;

public class LargesPrefixPalindrome {
    // LPP.
    // For example, LPP of "abcd" is "a", "aba" is "aba", "abbad" is "abba"
    public String lpp(String str) {
        int i = 0, j = str.length() - 1;
        while (j >= 0) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
            }
            j--;
        }
        if (i == str.length()) {
            return str;
        }
        return lpp(str.substring(0, i));
    }
}
