import crackingthecodinginterview.rotateimage.RotateImage;
import crackingthecodinginterview.rotateimage.RotateImageImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateImageTest {

    RotateImage rotator = new RotateImageImpl();

    @Test
    void shouldNotRotateWhenImageIsEmpty() {
        int size = 0;
        int[][] matrix = new int[][]{};
        rotator.rotate90(matrix, size);
        int[][] expected = {};
        assertArrayEquals(expected, matrix, getLog(expected, matrix, size));
    }

    @Test
    void shouldNotRotateWhenImageIsOnePixel() {
        int size = 1;
        int[][] matrix = new int[][]{{1}};
        rotator.rotate90(matrix, size);
        int[][] expected = {{1}};
        assertArrayEquals(expected, matrix, getLog(expected, matrix, size));
    }

    @Test
    void shouldRotateWhenImageIs4PixelOr2X2() {
        int size = 2;
        int[][] matrix = new int[][]{
                {1, 2},
                {4, 3}
        };
        rotator.rotate90(matrix, size);
        int[][] expected = new int[][]{
                {4, 1},
                {3, 2}
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, size));
    }

    @Test
    void shouldRotateWhenImageIs9PixelOr3X3() {
        int size = 3;
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotator.rotate90(matrix, size);
        int[][] expected = new int[][]{
                {4, 1, 2},
                {7, 5, 3},
                {8, 9, 6}
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, size));
    }

    @Test
    void shouldRotateWhenImageIs16PixelOr4X4() {
        int size = 4;
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        rotator.rotate90(matrix, size);
        int[][] expected = new int[][]{
                {5, 1, 2, 3},
                {9, 10, 6, 4},
                {13, 11, 7, 8},
                {14, 15, 16, 12},
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, size));
    }

    @Test
    void shouldRotateWhenImageIs25PixelOr5X5() {
        int size = 5;
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        rotator.rotate90(matrix, size);
        int[][] expected = new int[][]{
                {6, 1, 2, 3, 4},
                {11, 12, 7, 8, 5},
                {16, 17, 13, 9, 10},
                {21, 18, 19, 14, 15},
                {22, 23, 24, 25, 20},
        };

        assertArrayEquals(expected, matrix, getLog(expected, matrix, size));
    }

    @Test
    void shouldRotateWhenImageIs36PixelOr6X6() {
        int size = 6;
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36},
        };
        rotator.rotate90(matrix, size);
        int[][] expected = new int[][]{
                {7, 1, 2, 3, 4, 5},
                {13, 14, 8, 9, 10, 6},
                {19, 20, 21, 15, 11, 12},
                {25, 26, 22, 16, 17, 18},
                {31, 27, 28, 29, 23, 24},
                {32, 33, 34, 35, 36, 30},
        };
        assertArrayEquals(expected, matrix, getLog(expected, matrix, size));
    }

    private String getLog(int[][] expected, int[][] actual, int size) {
        return "\nexpected=\n" + toString(expected, size) +
                "actual=\n" + toString(actual, size);
    }

    private String toString(int[][] matrix, int size) {
        StringBuilder matrixString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixString.append(matrix[i][j]);
                matrixString.append(", ");
            }
            matrixString.append("\n");
        }
        return matrixString.toString();
    }
}
