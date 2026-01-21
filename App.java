import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("\n=== Array and sort testing ===");
            System.out.print("Array size: ");
            int size = scanner.nextInt();
            
            if (size <= 0) {
                System.err.println("Size should be positive number!");
                scanner.close();
                return;
            }
            
            int[] array = new int[size];
            generateArray(array, size);
            
            System.out.println("\n=== Operations on array ===");
            int max = array[0], min = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                } else if (array[i] > max) {  
                    max = array[i];
                }
            }
            System.out.println("Max and min: " + max + ", " + min);

            int allNum = 0, midNum;
            for (int i = 0; i < array.length; i++) {
                allNum += array[i];
            }
            midNum = allNum / array.length;
            System.out.println("Sum and arithmetic mean " + allNum + ", " + midNum);

            System.out.println("\n=== Sort methods ===");
            generateArray(array, size);
            Arrays.sort(array);
            System.out.println("Sorting an array: " + Arrays.toString(array) + "\n");

            generateArray(array, size);
            System.out.println("Array sort (Bubble): " + Arrays.toString(bubbleSort(array)) + "\n"); 

            generateArray(array, size);
            System.out.println("Array sort (Selection): " + Arrays.toString(selectionSort(array)) + "\n"); 

            generateArray(array, size);
            System.out.println("Array sort (Quick): " + Arrays.toString(quickSort(array, 0, array.length - 1)) + "\n"); 
        } catch (Exception asException) {
            System.err.println(asException);
        }
    }

    // Generate new array
    public static int[] generateArray(int[] array, int size) {
        Random random = new  Random();

        for (int i = 0; i < size; i++) {
            if (random.nextInt(101) < 50){
                array[i] = -random.nextInt(50);
            } else {
                array[i] = random.nextInt(50);
            }
        }
        System.out.println("Generated array: " + Arrays.toString(array));

        return array;
    }

    // Bubble sort method
    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; i < n - i - 1; i++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array; 
    }

    // Selection sort method
    public static int[] selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }

    // Quick sort method
    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int par = partition(array, low, high);

            quickSort(array, low, par - 1);
            quickSort(array, par + 1, high);
        }

        return array;
    }
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        return i + 1;
    }
}
