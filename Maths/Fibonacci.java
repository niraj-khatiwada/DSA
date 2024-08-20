package Maths;

public class Fibonacci {
    public int main(String[] args) {
        return _fibonacci(4);

    }

    public int _fibonacci(int target) {
        if (target == 0 || target == 1) {
            return target;
        }
        // f(n-1) + f(n-2)
        return _fibonacci(target - 1) + _fibonacci(target - 2);
    }

    public void fibonacciPattern(int upto) {
        _fibonacciPattern(-1, 1, upto);
    }

    public void _fibonacciPattern(int a, int b, int target) {
        if (b >= target) {
            return;
        }
        var sum = a + b;
        System.out.println(sum);
        _fibonacciPattern(b, sum, target);
    }
}
