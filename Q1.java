import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int array_f[] = {1, 2, 3, 4, 5, 6};

        System.out.println("Enter part to get the solution");
        char part = console.next().charAt(0);

        switch (part) {
            case 'a':
                Display6I(array_f);
                break;
            case 'b':
                ET8(array_f);
                break;
            case 'c':
                float[] anssum = EnternSum();
                System.out.println("The sum of array is: " + anssum[0]);
                break;
            case 'd':
                int[] copiedArray = Copied();
                Display(copiedArray);
                break;
            default:
                System.out.println("Invalid part number");
        }
    }

    public static void Display6I(int[] array1) {
        System.out.println("The element at index 6 is: " + array1[5]);
    }

    public static void Display(int[] array1) {
        System.out.println("The array is: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }

    public static void ET8(int[] array_g) {
        for (int i = 0; i < array_g.length; i++) {
            array_g[i] = 8;
            System.out.println(array_g[i]);
        }
    }

    public static float[] EnternSum() {
        Scanner console = new Scanner(System.in);
        float[] array_c = new float[100];
        float[] resultArray = new float[1];
        float sum = 0;

        System.out.println("Enter 100 elements for the array");
        for (int i = 0; i < array_c.length; i++) {
            sum += console.nextInt();
        }
        resultArray[0] = sum;
        return resultArray;
    }

    public static int[] Copied() {
        Scanner console = new Scanner(System.in);
        int[] array_a = new int[34];
        System.out.println("Enter 34 elements for the array A");
        for (int i = 0; i < array_a.length; i++) {
            array_a[i] = console.nextInt();
        }

        int[] array_b = new int[34];
        System.out.println("Copying the first 11 elements from array A to array B");
        for (int i = 0; i < 11; i++) {
            array_b[i] = array_a[i];
        }

        return array_b;
    }
}
