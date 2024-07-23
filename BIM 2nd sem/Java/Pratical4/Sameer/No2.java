// 2.	Create a class Calculate which contains data member num1 and num2 both in integer and methods setCalc() to set the data, calcSum() that calculate the sum of num1 and num2 and display the result, calcMulti() that calculate the multiplication of num1 and num2 and returns the result, calcDifference that calculate the difference between num1 and num2 and display the result. Now, create some instance of Calculate and invoke all the methods.

class Calculate {
    private int num1, num2;

    public void setCalc(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void calcSum() {
        System.out.println("Sum is " + (this.num1 + this.num2));
    }

    public void calcDifference() {
        System.out.println("Difference is " + (this.num1 - this.num2));
    }

    public int calcMulti() {
        return (this.num1 * this.num2);
    }
}

public class No2 {
    public static void main(String[] args) {
        Calculate c1 = new Calculate();
        c1.setCalc(4, 5);
        c1.calcSum();
        c1.calcDifference();
        System.out.println("Prodcut is " + c1.calcMulti());
    }
}
