package Strings;

public class ShortestPathToReachDestination {
    // WNEENESENNN;
    public double findShortestDistance(String dir) {
        var coord = new int[] { 0, 0 };
        for (var ch : dir.toCharArray()) {
            if (ch == 'E') {
                coord[0] += 1;
            } else if (ch == 'S') {
                coord[1] += 1;
            } else if (ch == 'W') {
                coord[0] -= 1;
            } else if (ch == 'N') {
                coord[1] -= 1;
            } else {
                throw new IllegalArgumentException("Invalid direction supplied.");
            }
        }
        return Math.sqrt(coord[0] * coord[0] + coord[1] * coord[1]);
    }
}
