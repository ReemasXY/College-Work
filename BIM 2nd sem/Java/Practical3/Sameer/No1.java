import java.util.*;

public class No1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The number divisible by 2 and 3 in array are: ");
        for (int x : arr) {
            if (x % 2 == 0 && x % 3 == 0) {
                System.out.println(x);
            }
        }

    }
}