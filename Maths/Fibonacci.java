package Maths;

public class Fibonacci {

    public void fibonacci(int upto) {
        _fibonacci(-1, 1, upto);
    }

    public void _fibonacci(int a, int b, int target) {
        if (b >= target) {
            return;
        }
        var sum = a + b;
        System.out.println(sum);
        _fibonacci(b, sum, target);
    }
}
