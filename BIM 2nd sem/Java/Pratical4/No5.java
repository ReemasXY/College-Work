
// 5.	Create a class Numbers with three integer instance variables x, y and z. the class will have one constructor to set the value of instance variable and method getMax() that find the greatest number between x, y and z and return the results. Create one object of Number and invoke the method to find greatest number.
import java.util.*;;

class Numbers {
    private int x, y, z;

    public Numbers(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getMax() {
        if (this.x > this.y && this.x > this.z) {
            return this.x;
        } else if (this.y > this.x && this.y > this.z) {
            return this.y;
        } else {
            return this.z;
        }
    }
}

public class No5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        Numbers n1 = new Numbers(a, b, c);
        System.out.println("The greatest among these numbers is " + n1.getMax());
    }
}
