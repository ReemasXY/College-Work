import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two numbers");
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        scan.close();
        for (int i = n1; i <= n2; i++) {
            int flag = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag++;
                    break;
                }
            }
            if (flag != 1) {
                System.out.println(i);
            }
        }

    }

}
