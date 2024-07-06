import java.util.*;

public class No1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        double div = (double) a / b;
        int rem = a % b;
        System.out.println("Quotient: " + div);
        System.out.println("Remainder: " + rem);
    }

}