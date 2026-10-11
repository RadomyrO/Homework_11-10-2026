package part2_snapshots;

import java.util.Random;

// Part 2. Iteration snapshots of bubble sort for random 5-element array
// swapped pair is shown in [ ]
public class Snapshots {

    // array to string, pair a,b (if any) in brackets
    static String arrToString(int[] arr, int a, int b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == a) sb.append("[");
            sb.append(arr[i]);
            if (i == b) sb.append("]");
            sb.append("  ");
        }
        return sb.toString();
    }

    // array of random values 0..99
    static int[] createRandomArray(int n) {
        Random rnd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(100);
        }
        return arr;
    }

    // same bubble sort (optimised), but prints every iteration
    static void bubbleSortSnapshots(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Outer loop, iteration " + (i + 1) + ":");
            System.out.println(arrToString(arr, -1, -1));
            System.out.println("Inner loop:");

            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                int a = -1, b = -1;
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                    a = j;
                    b = j + 1;
                }
                System.out.println("iteration " + (j + 1) + ":  " + arrToString(arr, a, b));
            }
            System.out.println();

            if (!swapped) {
                System.out.println("No swaps - array is sorted");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = createRandomArray(5);

        System.out.println("Initial array:");
        System.out.println(arrToString(arr, -1, -1));
        System.out.println();

        bubbleSortSnapshots(arr);

        System.out.println("Sorted array:");
        System.out.println(arrToString(arr, -1, -1));
    }
}
