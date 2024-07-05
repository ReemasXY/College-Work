import java.util.*;

public class No6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks of 5 subjects");
        double[] marks = new double[5];
        double total = 0;
        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextDouble();
            total += marks[i];
        }
        double avg = (total / 5);

        if (avg >= 80 && avg <= 100) {
            System.out.println("Grage A");
        } else if (avg >= 60) {
            System.out.println("Grade B");
        } else if (avg >= 40) {
            System.out.println("Grade C");
        } else {
            System.out.println("Grade F");
        }
    }
}
