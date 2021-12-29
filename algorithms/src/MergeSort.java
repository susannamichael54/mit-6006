import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = scan.nextInt();
        System.out.println("Enter the array elements");
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(mergeSort(input, 0, input.length - 1)));

    }

    public static int[] mergeSort(int[] input, int l, int r) {
        if (l != r) {
            int m = (r + l) / 2;
            mergeSort(input, l, m);
            mergeSort(input, m + 1, r);
            merge(l, m, r, input);
        }
        return input;
    }

    public static void merge(int l, int m, int r, int[] input) {

        int[] la = new int[m - l + 1];
        int[] ra = new int[r - m];
        for (int i = l, j = 0; i <= m; i++, j++) {
            la[j] = input[i];
        }
        for (int i = m + 1, j = 0; i <= r; i++, j++) {
            ra[j] = input[i];
        }
        int k = 0, n = 0, i = l;
        while (k < la.length && n < ra.length) {
            if (la[k] < ra[n]) {
                input[i] = la[k];
                k++;
            } else {
                input[i] = ra[n];
                n++;
            }
            i++;
        }
        while (k < la.length) {
            input[i] = la[k];
            i++;
            k++;
        }
        while (k < ra.length) {
            input[i] = ra[n];
            i++;
            n++;
        }
    }
}
