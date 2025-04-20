package crackingthecodinginterview.zeromatrix;

import kotlin.Pair;

import java.util.ArrayList;

/**
 * time complexity: O(mxn x (m+n))
 * space complexity: O(mxn)
 * implementation time: 1 hour
 */
public class ZeroMatrixImpl implements ZeroMatrix {

    @Override
    public void zeroIfRowOrColIsZero(int[][] matrix, int m, int n) {
        ArrayList<Pair<Integer, Integer>> zeros = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeros.add(new Pair<>(i, j));
                }
            }
        }
        for (int i = 0; i < zeros.size(); i++) {
            Pair<Integer, Integer> zero = zeros.get(i);
            int rowIndex = zero.getFirst();
            int colIndex = zero.getSecond();
            for (int row = 0; row < m; row++) {
                matrix[row][colIndex] = 0;
            }
            for (int col = 0; col < n; col++) {
                matrix[rowIndex][col] = 0;
            }
        }
    }
}