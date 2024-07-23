// 3.	Create a class Number having instance variable x and y both in integer, default constructor that set the value of x and y to 0, parameterized constructor that sets the value of x and y, method findOdd() that calculates the even no. occurring between x and y and display the result, findEven() that calculates the odd no. occurring between x and y and display the results. Now, create some instance of Number and invoke all the methods. 
class Number {
    private int x;
    private int y;

    public Number() {
        this.x = 0;
        this.y = 0;
    }

    public Number(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void findEven() {
        System.out.println("Even numbers from " + this.x + " to " + this.y);
        for (int i = this.x; i <= this.y; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");

    }

    public void findOdd() {
        System.out.println("Odd numbers from " + this.x + " to " + this.y);
        for (int i = this.x; i <= this.y; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }
}

public class No3 {
    public static void main(String[] args) {
        Number n1 = new Number(10, 20);
        Number n2 = new Number(30, 40);
        n1.findEven();
        n2.findOdd();
    }
}
