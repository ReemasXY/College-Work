import java.util.*;

public class No8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Salary");
        double sal = sc.nextDouble();
        double tax = 0;
        if (sal > 500000) {
            tax = ((double) 10 / 100) * sal;
        } else if (sal > 100000) {
            System.out.println("gayo");
            tax = ((double) 5 / 100) * sal;
        } else {
            tax = ((double) 1 / 100) * sal;
        }
        System.out.println("Tax is " + tax);
        System.out.println("Actual salary is " + (sal - tax));
    }
}
