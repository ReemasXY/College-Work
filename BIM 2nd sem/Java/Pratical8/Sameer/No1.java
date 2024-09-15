
// Wap to demonstrate generic class and method
class Rectangle<T> {
    private T length;
    private T breadth;

    public Rectangle(T length, T breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public T getlength() {
        return this.length;
    }

    public T getBreadth() {
        return this.breadth;
    }
}

public class No1 {

    public static void main(String[] args) {
        Rectangle<Integer> r1 = new Rectangle<Integer>(10, 20);
        int b = r1.getBreadth();
        int l = r1.getlength();
        System.out.println("length is " + l + " Breadth is "+b);

        Rectangle<Double> r2 = new Rectangle<Double>(10.2, 20.2);
        System.out.println("length is " + r2.getlength() + " Breadth is " + r2.getBreadth());
    }
}