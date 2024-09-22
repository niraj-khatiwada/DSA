package Strings;

public class StringCompression {
    // aaabbc
    public String compress(String str) {
        var rs = new StringBuilder();
        var last = '.';
        var count = 0;
        for (var ch : str.toCharArray()) {
            if (ch == last) {
                if (count > 1) {
                    rs.deleteCharAt(rs.length() - 1);
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

    public String decompress(String str) {
        var rs = new StringBuilder();
        var last = '.';
        for (var ch : str.toCharArray()) {
            if (ch > 48 && ch < 57) {
                var p = ch - 48 - 1;
                while (p > 0) {
                    rs.append(last);
                    p--;
                }
            } else {
                rs.append(ch);
                last = ch;
            }
        }
        return rs.toString();
    }
}
