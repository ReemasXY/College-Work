import java.util.Scanner;

public class Try {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int arr[] = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < arr.length; i++)

        {
            Boolean prime = true;
            for (int j = 2; j < arr[i]; j++)

            {
                if (arr[i] % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.println(arr[i]);
            }
        }
    }
}