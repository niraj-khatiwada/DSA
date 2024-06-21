import Array.Array;

class Main {
    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        array.insert(5);
        array.insert(6);
        array.removeAt(5);
        array.removeAt(4);
        array.removeAt(0);
        array.removeAt(2);
        array.print();
        System.out.println(array.indexOf(100));
        System.out.println(array.indexOf(2));
        System.out.println(array.indexOf(3));
    }
}
