
import java.util.*;

public class No3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of 10 Students");
        String[] name = new String[3];
        for (int i = 0; i < 3; i++) {
            name[i] = sc.next();
        }
        System.out.println(
        "The name of students whose names end with letter \"a\" are:");
        for (String nam : name) {
            int len = nam.length() - 1;
            if (nam.charAt(len) == 'a') {
                System.out.println(nam);
            }
        }

    }
}
