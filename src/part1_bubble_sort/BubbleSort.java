package part1_bubble_sort;

import java.util.Random;
import java.util.Scanner;

// Part 1. Bubble sort (with Part 3 and Part 4 optimisations)
public class BubbleSort {

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    // print array
    static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + "  ");
        }
        System.out.println();
    }

    // array of random values 0..99
    static int[] createRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(100);
        }
        return arr;
    }

    // array from user input
    static int[] createUserArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = readInt();
        }
        return arr;
    }

    // bubble sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            // Part 4. inner loop: last i elements are already sorted, skip them
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            // Part 3. outer loop: no swaps - array is sorted, stop
            if (!swapped) {
                break;
            }
        }
    }

    // read int until valid input
    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Not a number, try again: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // read y/n answer
    static boolean askYes(String msg) {
        System.out.print(msg + " (y/n): ");
        String ans = sc.next().trim().toLowerCase();
        return ans.startsWith("y");
    }

    public static void main(String[] args) {
        do {
            // 1. number of elements
            System.out.print("Enter number of elements: ");
            int n = readInt();
            while (n <= 0) {
                System.out.print("Must be > 0, try again: ");
                n = readInt();
            }

            // 2-3. random or manual input
            int[] arr;
            if (askYes("Generate random values?")) {
                arr = createRandomArray(n);
            } else {
                arr = createUserArray(n);
            }

            // 4. print given array
            System.out.print("Array: ");
            printArray(arr);

            // 5-6. sort and print
            bubbleSort(arr);
            System.out.print("Sorted array: ");
            printArray(arr);

            System.out.println();
        } while (askYes("Repeat?")); // 7. repeat
    }
}
