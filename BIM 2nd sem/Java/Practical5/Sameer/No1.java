// Create a class Work which consist of four methods with same name calculate (). If two parameters is passed calculate the sum between two parameter and display the result, if three parameter of type double is passed then find the multiplication between three parameter and return the result, if two parameter of float is passed then calculate difference between two parameter and display the result. Now create the instance of Work and invoke all the method to demonstrate method overloading condition.
class Work {
    public void calculate(int a, int b) {
        System.out.println("The sum of two numbers is " + (a + b));
    }

    public double calculate(double a, double b, double c) {
        return (a * b * c);
    }

    public void calculate(float a, float b) {
        System.out.println("The difference of two numbers is " + (a - b));
    }
}

public class No1 {
    public static void main(String[] args) {
        Work w1 = new Work();
        w1.calculate(1.5f, 2.5f);
        System.out.println("The product of three numbers is " + w1.calculate(1.3, 2.3, 4.3));
        w1.calculate(4, 5);
    }
}