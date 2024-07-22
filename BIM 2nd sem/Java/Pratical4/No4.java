
// 4.	Create a class Rectangle with attributes length and breadth. The class contains method computeArea() and displayArea(). Now, create two object of Rectangle and find area and display the area.
class Rectangle {
    private int length, breadth, area;

    public void computeArea(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
        this.area = this.length * this.breadth;
    }

    public void displayArea() {
        System.out.println("The area of rectangle is " + this.area);
    }

}

public class No4 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        r1.computeArea(20, 30);
        r1.displayArea();
        r2.computeArea(40, 50);
        r2.displayArea();
    }

}
