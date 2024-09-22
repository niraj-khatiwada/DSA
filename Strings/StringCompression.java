package Strings;

public class StringCompression {
    // aaabbc
    // aaaaaaaaaabbc. Remember count can be greater than 9 as well.
    public String compress(String str) {
        var rs = new StringBuilder();
        var last = '.';
        var count = 0;
        for (var ch : str.toCharArray()) {
            if (ch == last) {
                if (count > 1) {
                    var c = count;
                    while (c != 0) {
                        rs.deleteCharAt(rs.length() - 1);
                        c = c / 10;
                    }
                }
                rs.append((count + 1) + "");
                count++;
            } else {
                rs.append(ch);
                count = 1;
            }
            last = ch;
        }
        return rs.toString();
    }

    // aaaaaaaaaabbc. Remember count can be greater than 9 as well.
    public String decompress(String str) {
        var rs = new StringBuilder();
        var last = '.';
        var i = 0;
        while (i < str.length()) {
            var ch = str.charAt(i);
            if (ch > 48 && ch < 58) {
                var p = ch - 48;
                while ((i + 1) < str.length() && str.charAt(i + 1) >= 48 && str.charAt(i + 1) < 58) {
                    p = (p * 10) + (str.charAt(i + 1) - 48);
                    i++;
                }
                while (p > 1) {
                    rs.append(last);
                    p--;
                }
            } else {
                rs.append(ch);
                last = ch;
            }
            i++;
        }
        return rs.toString();
    }
}
