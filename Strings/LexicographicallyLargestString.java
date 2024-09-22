package Strings;

public class LexicographicallyLargestString {
    public String findShortestString(String[] strs) {
        var rs = strs[0];
        for (var i = 1; i < strs.length; i++) {
            if (rs.compareTo(strs[i]) < 0) { // Remember, if comparision gives positive, we've to swap. But if it gives
                                             // negative, we preserve the position.
                                             // See working of sorting notes
                rs = strs[i];
            }
        }
        return rs;
    }
}
