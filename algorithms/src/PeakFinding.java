import java.util.Scanner;

/**
 * Find a peak (position in the 0 indexed array) in the input array of numbers.
 *
 * Peak - Any number is a peak if the numbers before and after are <= the number
 */

public class PeakFinding {

    public static void main(String [] a) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = scan.nextInt();
        scan.nextLine();
        int [] input = new int [n];
        System.out.println("Enter array. Type each number and press enter");
        for(int i = 0; i < n; i++) {
            input[i] = scan.nextInt();
        }
        System.out.println(findPeak(input, 0, input.length - 1));

    }

    public static int findPeak(int [] input, int i, int j) {
        int n = j - i;
        int mid = i + n/2;
        if(mid > 0 && input[mid] < input[mid - 1]) {
            return findPeak(input, i, mid - 1);
        } else if(mid < j && input[mid] < input[mid + 1]) {
            return findPeak(input, mid + 1, j);
        } else {
            return mid;
        }
    }

}
