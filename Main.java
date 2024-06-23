import Stack.StackUsingLinkedList;

class Main {
    public static void main(String[] args) {
        var stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        // System.out.println(stack.peek());
        stack.print();
    }
}
