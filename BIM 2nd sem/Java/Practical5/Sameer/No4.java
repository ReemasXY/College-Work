// Create an abstract class Calculation which has one normal method int add(int x, int y) which will calculate the sum of x and y and return the results and one abstract method int mul (int x, int y) that performs multiplication. Create a class Demo that inherit abstract class that implement all the abstract method, and it have its own method int calcDiv(int x, int y) that calculates the division between x and y and return the result. Now create the object of Demo and demonstrate the above scenario. After this access the method of abstract class using reference of abstract class. 
abstract class Calculation {
    public int add(int x, int y) {
        return (x + y);
    }

    abstract int mul(int x, int y);
}

class Demo extends Calculation {
    public int calcDiv(int x, int y) {
        return (x / y);
    }

    public int mul(int x, int y) {
        return (x * y);
    }
}

public class No4 {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        System.out.println("The sum of 2 and 3 is: " + d1.add(2, 3));
        System.out.println("The division of 3 and 2 is: " + d1.calcDiv(3, 2));
        System.out.println("The product of 2 and 3 is: " + d1.mul(2, 3));
    }

}
