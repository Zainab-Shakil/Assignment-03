import java.util.Scanner;
public class Main{
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the size of the array: ");
        int size = console.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = console.nextInt();
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Count occurrences of a number");
            System.out.println("2. Partition the array");
            System.out.println("3. Calculate and display element frequencies");
            System.out.println("4. Circular transformation");
            System.out.println("5. Shift array circularly left by two positions");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = console.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number to count occurrences: ");
                    int numToCount = console.nextInt();
                    count(arr, numToCount);
                    break;
                case 2:
                    partition(arr);
                    break;
                case 3:
                    duplicates(arr);
                    break;
                case 4:
                    circular(arr);
                    break;
                case 5:
                    shiftCircular(arr);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private static void count(int[] arr, int x) {
        int count = 0;
        for (int num : arr) {
            if (num == x) {
                count++;
            }
        }
        System.out.println("Occurrences of " + x + ": " + count);
    }

    private static void partition(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array too small for partitioning.");
            return;
        }

        int pivot = arr[0];
        int low = 1;
        int high = arr.length - 1;

        while (low <= high) {
            while (low <= high && arr[low] < pivot) {
                low++;
            }

            while (low <= high && arr[high] > pivot) {
                high--;
            }

            if (low <= high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }

        arr[0] = arr[high];
        arr[high] = pivot;

        System.out.println("Array after partitioning:");
        printArray(arr);
    }

    private static void duplicates(int[] arr) {
        int[] frequency = new int[101]; // Assuming elements are between 0 and 100

        for (int num : arr) {
            frequency[num]++;
        }

        System.out.println("Element frequencies:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + ": " + frequency[i] + " times");
            }
        }
    }

    private static void circular(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[(i + 1) % arr.length] + arr[(i + 2) % arr.length]) % 100; // Circular array transformation
        }

        System.out.println("Array after circular transformation:");
        printArray(arr);
    }

    private static void shiftCircular(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array too small for circular shift.");
            return;
        }

        int temp = arr[0];
        arr[0] = arr[2];

        for (int i = 1; i < arr.length - 1; i++) {
            int temp2 = arr[i];
            arr[i] = temp;
            temp = temp2;
        }

        arr[arr.length - 1] = temp;

        System.out.println("Array after circular shift:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
