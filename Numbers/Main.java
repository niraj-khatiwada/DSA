package Numbers;

public class Main {
    public static void main(String[] args) {

        System.out.println(Main.isPrime(3));
        System.out.println(Main.sumOfNaturalNumbers(3));

    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return true;
        }
        var current = 2;
        var count = 2;
        while (current <= (num / 2)) {
            if (num % current == 0) {
                count++;
            }
            current++;
        }

        return count == 2;
    }

    public static int sumOfNaturalNumbers(int num) {
        return Main._sumOfNaturalNumbers(num);
    }

    private static int _sumOfNaturalNumbers(int num) {
        if (num == 0) {
            return 0;
        }
        return num + _sumOfNaturalNumbers(num - 1);
    }

}
