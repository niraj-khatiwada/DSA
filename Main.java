import Search.TernarySearch;

class Main {

    public static void main(String[] args) {
        var search = new TernarySearch();

        System.out.println(search.find(new int[] { 3, 6, 7, 8, 11 }, -3));
        System.out.println(search.findUsingRecursion(new int[] { 3, 6, 7, 8, 11 },
                -3));
    }

}
