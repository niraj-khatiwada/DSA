package BitManiupulation;

public class BitManipulation {
    public boolean isEven(int num) {
        return (num & 1) == 0;
    }

    // You have 2 ways to do.
    // 1. Right Shift the exact ith bit to LSB position and perform BIT AND with 1
    // 2. Left Shift 1 to the ith position and perform BIT AND with num
    public int getIthBit(int num, int i) {
        var bitMask = (num >> i);
        if ((bitMask & 1) == 0) {
            return 0;
        }

        return 1;
    }

    public int getIthBitMethod2(int num, int i) {
        var bitMask = (1 << i);
        if ((num & bitMask) == 0) {
            return 0;
        }

        return 1;
    }

    public int setIthBit(int num, int i) {
        var bitMask = (1 << i);

        return bitMask | num;
    }

    public int clearIthBit(int num, int i) {
        var bitMask = ~(1 << i);
        return bitMask & num;
    }

    public int updateIthBit(int num, int i, int val) {
        if (val == 1) {
            return this.setIthBit(num, i);
        }
        return this.clearIthBit(num, i);
    }

    // Makes all bits from ith position to LSB
    // Remember, i is count here not index value
    // If i = 3, we need to clear last 3 values.
    public int clearIBitsFromLSB(int num, int i) {
        var bitMask = (~0 >> i) << i;
        return bitMask & num;
    }

    public int clearRangeBits(int num, int i, int j) {
        var bitMask = (~0 << (j + 1)) | ((1 << i) - 1);
        // ((1 << i) - 1)
        // -> Math.pow(2, i) - 1
        // -> (1 * Math.pow(2, i)) - 1 // a * (2 ^ i) Formula of left shift
        // -> (1 << i) -1
        return bitMask & num;
    }

    // A number will be power of 2 if first bit is 1 and rest is 0.
    // If we do AND operation with first bit 0 and rest bit 1, we'll get output as
    // 0.
    public boolean isPowerOf2(int num) {
        var bitMask = num - 1;
        return (bitMask & num) == 0;
    }

    // Count number of 1 bits
    // Since, number of bits for a number = log(n) + 1
    // Time complexity will be (log(n) + 1) ~ log(n)
    public int countSetBits(int num) {
        var n = num;
        var count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    // O(log(n)). log(n) + 1 to be exact.
    // 3^5 =( log(5) + 1) = (~2 + 1) = 3
    public int fastExponentiation(int num, int i) {
        var a = num;
        var ans = 1;
        while (i != 0) {
            if ((i & 1) != 0) {
                ans *= a;
            }
            a = (int) Math.pow(a, 2);
            i = i >> 1;
        }

        return ans;

    }
}
