package BitManiupulation;

public class BitManipulation {
    public void oddOrEven(int num) {
        var bitMask = 1;
        var op = num & bitMask;
        if (op == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
