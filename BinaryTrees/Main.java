package BinaryTrees;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(0);
        tree.insert(-1);
        tree.insert(-2);
        tree.insert(3);


        System.out.println(tree.getAncestors(1));

    }

    public static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }


}