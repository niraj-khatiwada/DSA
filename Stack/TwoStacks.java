package Stack;

import java.util.Arrays;

/* 
Implement two stacks in one array. Support these operations:
    push1() // to push in the first stack
    push2() // to push in the second stack
    pop1()
    pop2()
    isEmpty1()
    isEmpty2()
    isFull1()
    isFull2()
Make sure your implementation is space efficient. (hint: do not allocate
the same amount of space by dividing the array in half.)
-> So, this question is saying you cannot allocate half space for each array at the initialization of array. 
For example, if the size of array is 6, you cannot allocate 3 for stack 1 and 3 for stack 2. Because, if you try to push to stack 1 6 times, it'll fail. You should be able to push to stack 1 6 times if you don't push anything to stack2.
*/
public class TwoStacks {
    private int[] array;

    private int head1Index;
    private int head2Index;

    public TwoStacks(int size) {
        this.array = new int[size];
        this.head1Index = -1;
        this.head2Index = size;
    }

    public void push1(int value) {
        if (this.isFull()) {
            throw new IllegalStateException("Stack 1 is full.");
        }
        this.head1Index++;
        this.array[this.head1Index] = value;
    }

    public void push2(int value) {
        if (this.isFull()) {
            throw new IllegalStateException("Stack 2 is full.");
        }
        this.head2Index--;
        this.array[this.head2Index] = value;
    }

    public int pop1() {
        if (this.head1Index == -1) {
            throw new IllegalStateException("Stack 1 is empty.");
        }
        var value = this.array[this.head1Index];
        this.array[this.head1Index] = 0;
        this.head1Index--;
        return value;
    }

    public int pop2() {
        if (this.head2Index == this.array.length) {
            throw new IllegalStateException("Stack 2 is empty.");
        }
        var value = this.array[this.head2Index];
        this.array[this.head2Index] = 0;
        this.head2Index++;
        return value;
    }

    public boolean isFull() {
        return (this.head1Index + (this.array.length - this.head2Index)) >= (this.array.length - 1);
    }

    public boolean isEmpty1() {
        return this.head1Index == -1;
    }

    public boolean isEmpty2() {
        return this.head2Index == this.array.length;
    }

    public void print() {
        System.out.println(Arrays.toString(this.array));
    }
}