
class Main {

    public static void main(String[] args) {
        System.out.println(_fibonacci(4));

    }

    public static int _fibonacci(int target) {
        if (target == 0 || target == 1) {
            return target;
        }
        return _fibonacci(target - 1) + _fibonacci(target - 2);
    }

}
