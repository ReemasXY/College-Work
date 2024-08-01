//How static polymorphism is achieved in java? Show a program
class Box {
    public void calc(int x, int y) {
        System.out.println("The sum of two numbers is : " + (x + y));
    }

    public void calc(int x, int y, int z) {
        System.out.println("The sum of three numbers is: " + (x + y + z));
    }
}

public class No3 {
    public static void main(String[] args) {
        Box b1 = new Box();
        System.out.println("Example of Static polymorphism");
        b1.calc(2, 3);
        b1.calc(3, 4, 5);
    }
}
