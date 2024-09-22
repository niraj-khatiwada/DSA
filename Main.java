import java.util.*;

import Strings.StringCompression;

class Main {

    public static void main(String[] args) {
        var str = new StringCompression();
        System.out.println(str.compress("aaaaaaaaaabbc"));
        System.out.println(str.decompress(str.compress("aaaaaaaaaabbc")));

    }

}
