import java.util.Scanner;

/**
 * Find the peak (position in the 0 indexed array) in a 2D array
 * <p>
 * Peak - A number at a position (i, j) in array a is a peak iff a(i - 1, j) <= a(i, j) && a(i + 1, j) <= a(i, j)
 * && a(i, j + 1) <= a(i, j) && a(i, j - 1) <= a(i, j)
 */
public class PeakFinding2D {

    public static void main(String[] a) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int r = scan.nextInt();
        System.out.println("Enter the number of columns");
        int c = scan.nextInt();
        System.out.println("Enter the array elements");
        int[][] input = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                input[i][j] = scan.nextInt();
            }
        }
        System.out.println(findPeak(input, 0, input.length - 1));
    }

    public static String findPeak(int[][] input, int ir, int jr) {
        int diff = jr - ir;
        int mr = ir + diff;
        int max = findMax(input[mr]);
        if (mr > 0 && input[mr - 1][max] > input[mr][max]) {
            return findPeak(input, ir, mr - 1);
        } else if (mr < jr && input[mr + 1][max] > input[mr][max]) {
            return findPeak(input, mr + 1, jr);
        } else {
            return "(" + mr + ", " + max + ")";
        }
    }

    public static int findMax(int[] row) {
        int max = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] > row[max]) {
                max = i;
            }
        }
        return max;
    }

}
