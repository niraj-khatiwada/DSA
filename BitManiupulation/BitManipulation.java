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

    public int getIthBit(int num, int i) {
        var bitMask = (1 << i);
        var op = num & bitMask;
        if (op == 0) {
            return 0;
        }
        return 1;
    }

    // Set mean set 1 at i position.
    public int setIthBit(int num, int i) {
        var bitMask = 1 << i;
        return num | bitMask;
    }

    // Clear means set 0 at i position
    public int clearIthBit(int num, int i) {
        var bitMask = ~(1 << i);
        return num & bitMask;
    }

    public int updateIthBit(int num, int i, int value) {
        if (value != 0 && value != 1) {
            throw new IllegalArgumentException("Invalid value");
        }
        return value == 0 ? this.clearIthBit(num, i) : this.setIthBit(num, i);
    }

    // Makes all bits from ith position to LSB
    // Remember, i is count here not index value
    // If i = 3, we need to clear last 3 values.
    public int clearLastIBits(int num, int i) {
        // var bitMask = (~0) << i; // ~0 = -1
        var bitMask = -1 << i;
        return num & bitMask;
    }

    // i =smaller position from LSB;
    // j = greater position from LSB
    public int clearRangeBits(int num, int i, int j) {
        var bitMask = (-1 << (j + 1)) | (1 << (i - 1));
        return num & bitMask;
    }

    // A number will be power of 2 if first bit is 1 and rest is 0.
    // If we do AND operation with first bit 0 and rest bit 1, we'll get output as
    // 0.
    public boolean isPowerOf2(int num) {
        var bitMask = num - 1;
        return (num & bitMask) == 0;
    }
}
