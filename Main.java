import Stack.TwoStacks;

class Main {
    public static void main(String[] args) {
        var twoStacks = new TwoStacks(5);
        twoStacks.push1(1);
        twoStacks.push1(2);
        twoStacks.push2(3);
        twoStacks.push2(4);
        twoStacks.push2(5);
        twoStacks.print();
        twoStacks.pop1();
        twoStacks.pop1();
        twoStacks.pop2();
        twoStacks.print();
    }
}
