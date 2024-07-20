import Search.BinarySearch;

class Main {

    public static void main(String[] args) {
        var search = new BinarySearch();

        System.out.println(search.find(new int[] { 3, 6, 7, 8, 11 }, 8));
        System.out.println(search.findUsingRecursion(new int[] { 3, 6, 7, 8, 11 }, 8));
    }

}
