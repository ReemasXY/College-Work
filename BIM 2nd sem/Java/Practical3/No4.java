
import java.util.*;
public class No4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The elements in even position are: ");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.print(" "+arr[i]);
            }
        }
    }
}
