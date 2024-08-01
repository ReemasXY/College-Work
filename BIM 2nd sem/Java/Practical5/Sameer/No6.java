// 14.	Create an abstract class Calculator having abstract methods calcPrime(int x, int y), calcEven(int x, int y). Now create a class SimpleCalculator that inherit an abstract class and provide the implementation of abstract method
abstract class Calculator {
    abstract void calcPrime(int x, int y);

    abstract void calcEven(int x, int y);
}

class SimpleCalculator extends Calculator {
    public void calcPrime(int x, int y) {
        System.out.println("The prime numbers between " + x + " and " + y);
        for (int i = x; i <= y; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }

            }

            if (prime) {
                System.out.print(i + " ");
            }
        }
    }

    public void calcEven(int x, int y) {
        System.out.println("\nThe Even numbers between " + x + " and " + y);
        for (int i = x; i <= y; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}

public class No6 {
    public static void main(String[] args) {
        SimpleCalculator s1 = new SimpleCalculator();
        s1.calcPrime(2, 10);
        s1.calcEven(2, 10);
    }

}
