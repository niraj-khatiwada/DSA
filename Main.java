import Strings.Strings;
import java.util.*;

class Main {

    public static void main(String[] args) {
        var string = new Strings();
        System.out.println(string.isAnagram("listen", "silent"));

        _fibonacci(-1, 1, 5);

    }

    public static void _fibonacci(int a, int b, int target) {
        if (b >= target) {
            return;
        }
        var sum = a + b;
        System.out.println(sum);
        _fibonacci(b, sum, target);
    }

}
