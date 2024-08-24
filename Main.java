import java.util.*;

import Greedy.ActivitySelection;

class Main {

    public static void main(String[] args) {
        var greedy = new ActivitySelection();
        System.out.println(greedy.maxNumberOfJobs(new int[] { 1, 3, 0, 5, 8, 5 },
                new int[] { 2, 4, 6, 7, 9, 9 }));

    }
}
