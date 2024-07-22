// 8.	Create a class Shape that contains instance variable length, breadth and height. Create a default constructor that sets the value of instance variable to zero, constructor with two parameter that will sets the value of length and breadth only and constructor with three parameter that will sets the value of length, breadth and height. After this create calcAreaRectangle() that calculates the area of rectangle, calcVolumeBox() that calculates volume of box and display the result. Now create first object of Shape wihich will have name rectangle and calls constructor with two parameter and calAreaRectangle() method, create second object of Shape that will have name Box which will call constructor with three parameter and calcVolumeBox() method.
class Shape {
    private int length, breadth, height;

    public Shape() {
        this.length = 0;
        this.breadth = 0;
        this.height = 0;
    }

    public Shape(int lenght, int breadth) {
        this.length = lenght;
        this.breadth = breadth;
    }

    public Shape(int lenght, int breadth, int height) {
        this.length = lenght;
        this.breadth = breadth;
        this.height = height;
    }

    public void calcAreaRectangle() {
        System.out.println("The area of rectangle is " + (this.length * this.breadth));
    }

    public void calcVolumeBox() {
        System.out.println("The volume of box is " + (this.length * this.breadth * this.height));

    }
}

public class No8 {
    public static void main(String[] args) {
        Shape Rectangle = new Shape(10, 20);
        Rectangle.calcAreaRectangle();
        Shape Box = new Shape(10, 20, 30);
        Box.calcVolumeBox();
    }

}
