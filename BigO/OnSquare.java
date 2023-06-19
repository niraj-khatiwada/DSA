package BigO;

public class OnSquare {
    // O(n^2) -> runtime complexity
    // Quadratic Runtime Complexity
    public static void log(int[] numbers) {
        for (var i = 0; i < numbers.length; i++) {
            for (var __ : numbers) {
                System.out.println(numbers[i]);
            }
        }
    }
}

// 1 -> 1
// 2 -> 2^2
// 3 -> 3^2
// 4 -> 4^2