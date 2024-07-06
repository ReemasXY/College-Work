import java.util.Scanner;

public class Try {
    /*
     * WAP that ask student to enter his/her marks for 5 subject and print the grade
     * obtained
     * 
     * a) 80-100 --> grade A
     * b) 60-79 --> grade B
     * c) 40-59 --> grade C
     * d) Below 40 --> grade F
     * 
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter annual salary: ");
        int salary = sc.nextInt();
        double tax = 0;
        if (salary > 500000) {
            tax = 0.1 * salary;
        } else if (salary > 100000) {
            tax = 0.05 * salary;
        } else {
            tax = 0.01 * salary;
        }
        double actualSalary = salary - tax;
        System.out.println("Actual salary: " + actualSalary);
        sc.close();
    }
}
