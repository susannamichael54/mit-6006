import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = s.nextInt();
        System.out.println("Enter the elements to sort");
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        System.out.println(Arrays.toString(sort(input)));
    }

    public static int[] sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int j = i - 1;
            int k = i;
            while (j >= 0 && input[k] < input[j]) {
                int temp = input[k];
                input[k] = input[j];
                input[j] = temp;
                k = j;
                j--;
            }
        }
        return input;
    }
}
