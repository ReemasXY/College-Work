import java.util.*;

public class No7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows of array1");
        int row1 = sc.nextInt();
        System.out.println("Enter the number of columns array1");
        int col1 = sc.nextInt();
        int[][] arr1 = new int[row1][col1];

        System.out.println("Enter the number of rows of array2");
        int row2 = sc.nextInt();
        System.out.println("Enter the number of columns array2");
        int col2 = sc.nextInt();
        int[][] arr2 = new int[row2][col2];

        if (col1 == row2) {
            System.out.println("Enter the elements in matrix1");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    arr1[i][j] = sc.nextInt();
                }
            }

            System.out.println("Enter the elements in matrix2");
            for (int i = 0; i < row2; i++) {
                for (int j = 0; j < col2; j++) {
                    arr2[i][j] = sc.nextInt();
                }
            }

            int[][] arr3 = new int[row1][col2];
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    int sum = 0;
                    for (int k = 0; k < row2; k++) {
                        sum += arr1[i][k] * arr2[k][j];
                    }
                    arr3[i][j] = sum;
                }
            }
            System.out.println("The matrix multiplication is :");
            for (int[] x : arr3) {
                for (int j : x) {
                    System.out.print(j + "\t");
                }
                System.out.println("");
            }

        } else {
            System.out.println("Matrix multiplication not possible");
        }
    }
}
