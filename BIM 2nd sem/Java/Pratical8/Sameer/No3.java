
//Wap to demonstrate Bounds in generics
class Rectangle<T extends Number> {
    private T length;
    private T breadth;// Number type bhoo basically (int or double or float or byte)
    // public Rectangle(T length,T breadth)
    // private Number breadth bho bhanna le
    // {

    // }
    public void setData(T length, T breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void calcArea() {
        // System.out.println("Area is "+ (this.length*this.breadth));

        // The main issue in your code is that you are trying to multiply generic types
        // (T) directly using the * operator. Even though T is restricted to Number
        // (i.e., it can only be Integer, Double, Float, etc.), Java doesn't allow
        // direct multiplication of objects of type Number.
        System.out.println("Area is " + ((int) this.length * (int) this.breadth));
        // System.out.println("Area is " + (this.length.doubleValue() *
        // this.breadth.intValue()));// milxa yo ni

    }
}

public class No3 {
    public static void main(String[] args) {
        Rectangle<Integer> r1 = new Rectangle<Integer>();
        r1.setData(2, 3);
        r1.calcArea();

    }

}
