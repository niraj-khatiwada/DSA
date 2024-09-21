import java.util.*;

import Strings.KMP;

class Main {

    public static void main(String[] args) {
        var str = new KMP();
        System.out.println(str.hasSubstring("ababcababa", "abab"));
    }

}
