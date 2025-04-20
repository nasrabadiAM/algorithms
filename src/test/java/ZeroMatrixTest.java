import crackingthecodinginterview.zeromatrix.ZeroMatrix;
import crackingthecodinginterview.zeromatrix.ZeroMatrixImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ZeroMatrixTest {

    ZeroMatrix zeroMatrix = new ZeroMatrixImpl();

    @Test
    void shouldNotMakeZeroIfMatrixIs1x1() {
        int rows = 1;
        int cols = 1;
        int[][] matrix = new int[][]{{1}};
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {{1}};
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldNotMakeZeroIfMatrix1x2HasNoZero() {
        int rows = 1;
        int cols = 2;
        int[][] matrix = new int[][]{{1, 2}};
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {{1, 2}};
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldNotMakeZeroIfMatrix2x1HasNoZero() {
        int rows = 2;
        int cols = 1;
        int[][] matrix = new int[][]{{1}, {2}};
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {{1}, {2}};
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldMakeZeroIfMatrix2x1HasOneZero() {
        int rows = 2;
        int cols = 1;
        int[][] matrix = new int[][]{{0}, {2}};
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {{0}, {0}};
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldMakeZeroIfMatrix1x2HasOneZero() {
        int rows = 1;
        int cols = 2;
        int[][] matrix = new int[][]{{0, 2}};
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {{0, 0}};
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldMakeZeroIfMatrix1x2HasOneZeroInSecondIndex() {
        int rows = 1;
        int cols = 2;
        int[][] matrix = new int[][]{{1, 0}};
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {{0, 0}};
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldNotMakeZeroIfMatrix2x2HasNoZero() {
        int rows = 2;
        int cols = 2;
        int[][] matrix = new int[][]{{2, 3}, {1, 2}};
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {{2, 3}, {1, 2}};
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldMakeZeroIfMatrix2x2HasOneZeroInFirstIndex() {
        int rows = 2;
        int cols = 2;
        int[][] matrix = new int[][]{
                {0, 3},
                {1, 2}
        };
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {
                {0, 0},
                {0, 2}
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldMakeZeroIfMatrix2x2HasOneZeroInLastIndex() {
        int rows = 2;
        int cols = 2;
        int[][] matrix = new int[][]{
                {2, 3},
                {1, 0}
        };
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {
                {2, 0},
                {0, 0}
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldMakeZeroIfMatrix2x2HasOneZeroInLastIndexOfFirstRow() {
        int rows = 2;
        int cols = 2;
        int[][] matrix = new int[][]{
                {2, 0},
                {1, 3}
        };
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {
                {0, 0},
                {1, 0}
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldMakeZeroIfMatrix3x2HasOneZeroInLastIndexOfFirstRow() {
        int rows = 3;
        int cols = 2;
        int[][] matrix = new int[][]{
                {2, 0},
                {1, 3},
                {1, 3},
        };
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {
                {0, 0},
                {1, 0},
                {1, 0},
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldNotMakeZeroIfMatrix2x3HasNoZero() {
        int rows = 3;
        int cols = 2;
        int[][] matrix = new int[][]{
                {2, 2},
                {1, 3},
                {1, 3},
        };
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {
                {2, 2},
                {1, 3},
                {1, 3},
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldMakeZeroIfMatrix3x3HasOneZeroInTheMiddle() {
        int rows = 3;
        int cols = 3;
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {1, 0, 3},
                {1, 2, 3},
        };
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {
                {1, 0, 3},
                {0, 0, 0},
                {1, 0, 3},
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    @Test
    void shouldMakeZeroIfMatrix3x3HasOneZeroInLastIndex() {
        int rows = 3;
        int cols = 3;
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 0},
        };
        zeroMatrix.zeroIfRowOrColIsZero(matrix, rows, cols);
        int[][] expected = {
                {1, 2, 0},
                {1, 2, 0},
                {0, 0, 0},
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, rows, cols));
    }

    private String getLog(int[][] expected, int[][] actual, int rows, int cols) {
        return "\nexpected=\n" + toString(expected, rows, cols) +
                "actual=\n" + toString(actual, rows, cols);
    }

    private String toString(int[][] matrix, int rows, int cols) {
        StringBuilder matrixString = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixString.append(matrix[i][j]);
                matrixString.append(", ");
            }
            matrixString.append("\n");
        }
        return matrixString.toString();
    }
}
