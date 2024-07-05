import java.util.*;

public class No15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Momo");
        System.out.println("2.Pizza");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1.Veg");
                System.out.println("2.Buff");
                System.out.println("Enter your choice");
                int choice1 = sc.nextInt();
                switch (choice1) {
                    case 1:
                        System.out.println("Veg Momo");
                        break;

                    case 2:
                        System.out.println("Buff Momo");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
                break;

            case 2:
                System.out.println("1.Veg");
                System.out.println("2.Chicken");
                System.out.println("Enter your choice");
                choice1 = sc.nextInt();
                switch (choice1) {
                    case 1:
                        System.out.println("Veg Pizza");
                        break;

                    case 2:
                        System.out.println("Chicken Pizza");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
                break;

            default:
                System.out.println("Invalid Choice");

        }
        sc.close();
    }
}
