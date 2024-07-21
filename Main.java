import Search.JumpSearch;

class Main {

    public static void main(String[] args) {
        var search = new JumpSearch();

        System.out.println(search.find(new int[] { 1, 2, 3, 4, 4, 6, 7, 8, 9, 10 }, 5));

    }

}
