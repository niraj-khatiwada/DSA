import java.util.*;

import Strings.StringCompression;

class Main {

    public static void main(String[] args) {
        var str = new StringCompression();
        System.out.println(str.compress("aaabbcdddaaa"));
        System.out.println(str.decompress("a3b2cd3a3"));
    }

}
