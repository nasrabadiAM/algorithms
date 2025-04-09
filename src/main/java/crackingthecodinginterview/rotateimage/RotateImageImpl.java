package crackingthecodinginterview.rotateimage;

/**
 * time complexity: O(n)
 * space complexity: O(1)
 * implementation time: 4 hours
 */
public class RotateImageImpl implements RotateImage {
    @Override
    public void rotate90(int[][] matrix, int size) {
        int squares = size / 2;
        for (int i = 0; i < squares; i++) {
            rotator(matrix, size, i, i, i);
        }
    }

    private void rotator(
            int[][] matrix,
            int size,
            int startIndexI,
            int startIndexJ,
            int offset
    ) {
        int i = startIndexI;
        int j = startIndexJ;
        if (size <= 1) return;
        int previousPixel = matrix[i][j];
        boolean firstRowVisited = false;
        boolean firstColVisited = false;
        boolean secondRowVisited = false;
        boolean secondColVisited = false;
        int lastIndex = size - 1 - offset;

        while (
                !firstRowVisited ||
                        !firstColVisited ||
                        !secondRowVisited ||
                        !secondColVisited
        ) {
            int temp = matrix[i][j];
            matrix[i][j] = previousPixel;
            previousPixel = temp;

            if (j == lastIndex) {
                firstRowVisited = true;
            }
            if (i == lastIndex) {
                firstColVisited = true;
            }
            if (firstRowVisited && j == startIndexJ) {
                secondRowVisited = true;
            }
            if (firstColVisited && i == startIndexI) {
                secondColVisited = true;
            }

            if (!firstRowVisited) {
                j++;
            } else if (!firstColVisited) {
                i++;
            } else if (!secondRowVisited) {
                j--;
            } else if (!secondColVisited) {
                i--;
            }
        }
    }
}
