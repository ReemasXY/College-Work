import java.util.*;

public class No9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        sc.close();
        boolean isprime = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isprime = false;
                break;
            }
        }
        if (isprime) {
            System.out.println("The number is prime");
        } else {
            System.out.println("The number is compositte");
        }
    }
}
