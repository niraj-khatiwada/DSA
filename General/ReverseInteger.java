package General;

public class ReverseInteger {
    public static void main(String[] args) {

        System.out.println(reverseInteger(-1234));
    }

    public static int reverseInteger(int num) {
        var sign = num < 0 ? -1 : 1;

        var number = Math.abs(num);
        var accumulator = 0;
        while (true) {
            var remainder = number % 10;
            accumulator = accumulator * 10 + remainder;
            number /= 10;
            if (number == 0) {
                break;
            }
        }

        return sign * accumulator;
    }
}
