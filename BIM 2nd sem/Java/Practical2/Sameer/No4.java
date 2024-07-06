import java.util.*;

public class No4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks of 5 subjects");
        double[] marks = new double[5];
        double total = 0;
        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextDouble();
            total += marks[i];
        }
        double per = (total / 500) * 100;
        System.out.println("Percentage is " + per);
        if (per >= 80 && per <= 100) {
            System.out.println("Distinction");
        } else if (per >= 60) {
            System.out.println("First division");
        } else if (per >= 40) {
            System.out.println("Second division");
        } else {
            System.out.println("Fail");
        }
    }
}
