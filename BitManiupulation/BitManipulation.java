package BitManiupulation;

// Clear Bit = 0
// Set Bit = 1
public class BitManipulation {
    public void oddOrEven(int num) {
        var bitMask = 1;
        var op = num & bitMask;
        if (op == 0) { // Always check for 0 bit instead of 1
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    public int getIthBit(int num, int i) {
        var bitMask = (1 << i);
        var op = num & bitMask;
        if (op == 0) { // Always check for 0 bit instead of 1
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

    // Count number of 1 bits
    // Since, number of bits for a number = log(n) + 1
    // Time complexity will be (log(n) + 1) ~ log(n)
    public int countSetBits(int num) {
        var current = num;
        var count = 0;
        while (true) {
            if (current == 0) {
                break;
            }
            if ((current & 1) != 0) {
                count++;
            }
            current = current >> 1;
        }
        return count;
    }

    // O(log(n)). log(n) + 1 to be exact.
    // 3^5 =( log(5) + 1) = (~2 + 1) = 3
    public int fastExponentiation(int a, int n) {
        var ans = 1;

        while (n > 0) {
            if ((n & 1) != 0) {
                ans *= a;
            }
            a = (int) Math.pow(a, 2);
            n = n >> 1;
        }
        return ans;
    }
}
