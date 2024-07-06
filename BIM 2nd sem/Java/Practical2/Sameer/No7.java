import java.util.*;

public class No7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Division \n 2.Sum \n 3.Multiply \n 4.Subtraction");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        System.out.println("Enter two numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("The quotient is " + (double) a / b);
                break;
            case 2:
                System.out.println("The sum is " + (a + b));
                break;
            case 3:
                System.out.println("The product is" + (a * b));
                break;
            case 4:
                System.out.println("The difference is " + (a - b));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
