
import java.util.*;

public class No5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] birds = new String[5];
        System.out.println("Enter the name of 5 birds: ");
        for (int i = 0; i < 5; i++) {
            birds[i] = sc.next();
        }
        System.out.println("The name of bird whose first letter is \"s\" ");
        for (String bird : birds) {
            if (bird.charAt(0) == 's' || bird.charAt(0) == 'S') {
                System.out.println(bird);
            }
        }
    }
}
