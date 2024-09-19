package Array;

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        var transpose = new int[matrix[0].length][matrix.length];
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        _print(transpose);
        return transpose;
    }

    private void _print(int[][] matrix) {
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                System.out.printf("%5s", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
