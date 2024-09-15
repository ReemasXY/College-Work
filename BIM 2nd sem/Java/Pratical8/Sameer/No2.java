//Wap to demonstrate generic class with Different type
class Rectangle<T, U> {
    T length;
    U breadth;

    public Rectangle(T length, U breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void calcArea() {
        // System.out.println(this.length*this.breadth); direct multiply not possible as
        // generic T and U ma non numeric data ni auna sakxa soo to multiply or peform
        // arithmetic operation yo numberic value nai ho ensure garna parxa natra error
        // auxa
        System.out.println((int) this.length * (double) this.breadth);
    }
}

public class No2 {
    public static void main(String[] args) {
        Rectangle<Integer, Double> r1 = new Rectangle<Integer, Double>(20, 10.1);
        r1.calcArea();
    }
}
