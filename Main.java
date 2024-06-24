import Stack.MinStack;

class Main {
    public static void main(String[] args) {
        var minStack = new MinStack();
        minStack.push(1);
        minStack.push(3);
        minStack.push(2);
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());

    }
}
