package crackingthecodinginterview.zeromatrix;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */

public interface ZeroMatrix {
    void zeroIfRowOrColIsZero(int[][] matrix, int m, int n);
}