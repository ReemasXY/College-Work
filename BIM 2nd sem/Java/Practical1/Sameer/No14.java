import java.util.*;
public class No14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] marks = new double[5];
        boolean fail = false;
        double sum = 0;
        System.out.println("Enter the marks of 5 subjects");
        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextDouble();
            sum += marks[i];
            if (marks[i] < 35) {
                fail = true;
            }
        }
        double percentage = (sum / 500) * 100;
        System.out.println("Total Marks is " + sum);
        System.out.println("Percentage is " + percentage + "%");
        if (fail) {
            System.out.println("The Student is fail");
        } else {
            System.out.println("The Student is pass");
        }
    }
}