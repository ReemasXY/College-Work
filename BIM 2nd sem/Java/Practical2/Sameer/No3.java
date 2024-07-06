import java.util.*;

public class No3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        System.out.println("Enter three numbers ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        System.out.println(n + " is " + ((n % 2 == 0) ? "even" : "odd"));
        System.out.println(n + " is " + ((n > 0) ? "positive" : "negative"));
        int great = (a > b && a > c) ? a : (b > c && b > a) ? b : c;
        System.out.println("The greatest among " + a + b + c + " is " + great);
    }
}