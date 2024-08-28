package Greedy;

import java.util.*;

public class ChocolaProblem {

    public int minimalCost(int[] costRows, int[] costColumns) {
        // costRows.length = (x-1)
        // costColumns.length = (y-1)

        var rowCuts = 0;
        var colCuts = 0;

        Arrays.sort(costRows);
        Arrays.sort(costColumns);

        // Descending
        var pr = costRows.length - 1;
        var pc = costColumns.length - 1;

        var total = 0;

        while (pr >= 0 || pc >= 0) {
            var rowCost = pr < 0 ? -1 : costRows[pr];
            var colCost = pc < 0 ? -1 : costColumns[pc];
            if (rowCost > colCost) {
                total += (colCuts + 1) * rowCost;
                rowCuts++;
                if (pc >= 0) {
                    total += (rowCuts + 1) * colCost;
                    colCuts++;
                }
            } else {
                total += (rowCuts + 1) * colCost;
                colCuts++;
                if (pr >= 0) {
                    total += (colCuts + 1) * rowCost;
                    rowCuts++;
                }
            }
            pr--;
            pc--;
        }

        return total;
    }
}