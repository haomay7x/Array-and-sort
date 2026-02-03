import java.util.Random;
import java.util.Scanner;

public class TwoDimenArray {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            System.out.println("\n===Two Dimensional Array and sort testing ===");
            // Creating a two-dimensional array of size N × M
            System.out.print("Enter the number of lines (N): ");
            int N = scanner.nextInt();
            
            System.out.print("Enter the number of columns (M): ");
            int M = scanner.nextInt();
            
            // Checking the correct dimensions
            if (N <= 0 || M <= 0) {
                System.out.println("Array dimensions must be positive numbers!");
                scanner.close();
                return;
            }
            
            // Создание массива
            int[][] matrix = new int[N][M];
            
            // Заполнение массива случайными числами
            System.out.print("\nPlease enter the minimum value for random numbers:");
            int min = scanner.nextInt();
            
            System.out.print("Enter the maximum value for random numbers:");
            int max = scanner.nextInt();
            
            if (min > max) {
                System.out.println("The minimum value is greater than the maximum! Default values (0-99) will be used.");
                min = 0;
                max = 99;
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = random.nextInt(max - min + 1) + min;
                }
            }
            
            // Outputting an array as a table
            System.out.println("\nSource array " + N + " × " + M + ":");
            printMatrix(matrix);
            
            System.out.println("\n=== Operations on array ===");
            // Find the sum of the elements of each row and each column
            System.out.println("\nСуммы элементов:");
            
            // Row sums
            int[] rowSums = new int[N];
            int maxRowSum = Integer.MIN_VALUE;
            int maxRowIndex = -1;
            
            for (int i = 0; i < N; i++) {
                int rowSum = 0;
                for (int j = 0; j < M; j++) {
                    rowSum += matrix[i][j];
                }
                rowSums[i] = rowSum;
                
                // To determine the row with the largest sum
                if (rowSum > maxRowSum) {
                    maxRowSum = rowSum;
                    maxRowIndex = i;
                }
                
                System.out.printf("Сумма строки %d: %d\n", i, rowSum);
            }
            
            // Column sums
            int[] colSums = new int[M];
            
            for (int j = 0; j < M; j++) {
                int colSum = 0;
                for (int i = 0; i < N; i++) {
                    colSum += matrix[i][j];
                }
                colSums[j] = colSum;
                System.out.printf("Column sum %d: %d\n", j, colSum);
            }
            
            // Find the row with the largest sum of elements
            System.out.printf("\nRow with the largest sum of elements: row %d (sum = %d)\n",
                    maxRowIndex, maxRowSum);
            
            // Find the maximum element of the main diagonal (if the array is square)
            if (N == M) {
                int maxDiagonal = Integer.MIN_VALUE;
                for (int i = 0; i < N; i++) {
                    if (matrix[i][i] > maxDiagonal) {
                        maxDiagonal = matrix[i][i];
                    }
                }
                System.out.println("\nThe array is square. The largest element of the main diagonal is: " + maxDiagonal);
                
                // Derivation of the main diagonal
                System.out.print("Elements of the main diagonal: ");
                for (int i = 0; i < N; i++) {
                    System.out.print(matrix[i][i]);
                    if (i < N - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            } else {
                System.out.println("\nThe array is not square (" + N + " х " + M + "), the main diagonal is undefined.");
            }
            
            // Transpose the array and print the result
            System.out.println("\nTransposed array " + M + " x " + N + ":");
            int[][] transposed = transposeMatrix(matrix);
            printMatrix(transposed);
        }
    }
    
    // Method for outputting a matrix in table form
    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Determine the maximum width of a number for a beautiful output
        int maxWidth = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int width = String.valueOf(matrix[i][j]).length();
                if (width > maxWidth) {
                    maxWidth = width;
                }
            }
        }
        
        // Matrix output
        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < cols; j++) {
                System.out.printf(" %" + maxWidth + "d |", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    // Method for matrix transposition
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        
        return transposed;
    }
}
