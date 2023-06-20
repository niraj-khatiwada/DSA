package StackDSA;

public class DoubleStack {
    private int[][] stack = new int[2][2];
    private int rowIndex = -1;
    private int columnIndex = -1;

    public void push1(int item) {
        if (rowIndex == stack.length - 1) {
            throw new StackOverflowError();
        }
        this.rowIndex++;
        stack[this.rowIndex][0] = item;
    }

    public void push2(int item) {
        if (columnIndex == stack.length - 1) {
            throw new StackOverflowError();
        }
        this.columnIndex++;
        stack[this.columnIndex][1] = item;
    }

    public int pop1() {
        int lastRowValue = this.stack[this.rowIndex][0];
        this.stack[this.rowIndex][0] = 0;
        this.rowIndex--;
        return lastRowValue;
    }

    public int pop2() {
        int lastColumnValue = this.stack[this.columnIndex][1];
        this.stack[this.columnIndex][1] = 0;
        this.columnIndex--;
        return lastColumnValue;
    }

    public boolean isEmpty1() {
        return this.rowIndex == -1;
    }

    public boolean isEmpty2() {
        return this.columnIndex == -1;
    }

    public boolean isFull1() {
        return this.rowIndex == this.stack.length - 1;
    }

    public boolean isFull2() {
        return this.columnIndex == this.stack.length - 1;
    }

    public int[] toArray1() {
        int[] array = new int[this.rowIndex + 1];

        for (int i = 0; i < this.rowIndex + 1; i++) {
            array[i] = this.stack[i][0];
        }
        return array;
    }

    public int[] toArray2() {
        int[] array = new int[this.columnIndex + 1];

        for (int i = 0; i < this.columnIndex + 1; i++) {
            array[i] = this.stack[i][1];
        }
        return array;
    }
}
