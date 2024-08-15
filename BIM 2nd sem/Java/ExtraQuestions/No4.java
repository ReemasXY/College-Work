
// 4.	Create a class name Course with data member title. Credit and courseCode and a method name void setValues() to assign the values and another method named showVlaues to display the record. In main(), instantiated 5 objects of course and display the record of course whose title start with “C”.
import java.util.*;

class Course {
    String title;
    int credit, courseCode;

    public void setValues(String title, int credit, int courseCode) {
        this.title = title;
        this.credit = credit;
        this.courseCode = courseCode;
    }

    public void showValues() {
        System.out.println("Title: " + this.title);
        System.out.println("Credit: " + this.credit);
        System.out.println("Course Code: " + this.courseCode);
    }
}

public class No4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course[] arr = new Course[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Title: ");
            String title = sc.next();
            System.out.println("Credit: ");
            int credit = sc.nextInt();
            System.out.println("Course code: ");
            int courseCode = sc.nextInt();
            arr[i] = new Course();
            arr[i].setValues(title, credit, courseCode);
        }
        for (Course c1 : arr) {
            if (c1.title.charAt(0) == 'c' || c1.title.charAt(0) == 'C') {
                c1.showValues();
            }
        }
    }

}
