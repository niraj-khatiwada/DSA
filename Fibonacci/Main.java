package Fibonacci;

public class Main {
    public static void main(String[] args) {
        fibonacci(5);
    }

    public static void fibonacci(int num) {
        if (num < 0) {
            return;
        }
        System.out.println(0);
        int n1 = 0;
        int n2 = 1;
        while ((n1 + n2) <= num) {
            System.out.println(n1 + n2);
            var k = n1;
            n1 = n2;
            n2 = k + n2;
        }

    }
}