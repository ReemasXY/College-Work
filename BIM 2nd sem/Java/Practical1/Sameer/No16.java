import java.util.*;

public class No16 {
    public static void main(String[] args) {
        System.out.println("Enter a number[1/2]");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch (a) {
            case 1:
                System.out.println("1.BCA");
                System.out.println("2.BIM");
                System.out.println("3.BBA");
                System.out.println("Enter your choice");
                int choice1 = sc.nextInt();
                switch (choice1) {
                    case 1:
                        System.out.println("Fees of BCA is 300000");
                        break;
                    case 2:
                        System.out.println("Fees of BIM is 320000");
                        break;
                    case 3:
                        System.out.println("Fees of BBA is 340000");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                break;
            case 2:
                System.out.println("1.BBS");
                System.out.println("2.BBM");
                System.out.println("Enter your choice");
                choice1 = sc.nextInt();
                switch (choice1) {
                    case 1:
                        System.out.println("Fees of BBA is 240000");
                        break;
                    case 2:
                        System.out.println("Fees of BBM is 230000");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                break;
            default:
                System.out.println("Invalid choice");

        }
    }
}
