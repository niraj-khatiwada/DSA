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

    // We can swap 2 variables without creating a third variable
    // If you perform XOR operation 3 times, the values will be swapped.
    public int[] swap(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        return new int[] { x, y };
    }

    // Adding one to any integer can be done in Bit Manipulation using Compliment
    // Remember, ~a = - (a + 1) -> ~5 = -4
    // And, ~(-a) = + (a - 1) -> ~(-5) = 4
    public int addOne(int a) {
        return ~a * -1;
    }

    // Unicode int of ' ' = 32
    // Let's say ch = 'A' = 65
    // Now, ch | ' ' = 65 | 32 = 97
    // So adding 32 to the uppercase value changes it to lower case value
    public char toLowerCase(char ch) {
        return (char) (ch | ' ');
    }

    // Let's say ch = a = 97
    // Now ch & ~' ' = 97 & ~32 = 65
    public char toUpperCase(char ch) {
        return (char) (ch & ~' ');
    }

    // Detect if the character is lower or upper cased
    public String detectCase(char ch) {
        var toLower = (char) (ch | ' ');
        if ((toLower - ch) == 0) {
            return "lower";
        }
        return "UPPER";
    }

    // Convert upper cased to lower and lower to upper cased of a string
    // O(n)
    public String flipCase(String str) {
        var newStr = new StringBuilder();
        for (var ch : str.toCharArray()) {
            var casing = this.detectCase(ch);
            newStr.append(casing == "lower" ? this.toUpperCase(ch) : this.toLowerCase(ch));
        }

        return newStr.toString();
    }

    // We need to know what is the fixed size of the bits like 2, 4, 8, 16, 32, etc.
    // It'll be given in the question. Most common one is 32.
    // 1010 -> 0101

    // Interesting:
    // Reverse of 1 is Integer.MIN_VALUE i.e. -2147483648
    // So, check if reverse(1) == Integer.MIN_VALUE;
    public int reverse(int num) {
        var r = 0;
        for (var i = 0; i < 32; i++) {
            var lsb = (num & 1);
            r = (r << 1) | lsb;
            num = num >> 1;
        }
        return r;
    }
}
