// 6.	Create a class Box with attributes length, breadth and height. The class contains method computeVolume() that computes the volume of box and return the volume. Now, create two object of box and find volume and display it.
class Box {
    private int length, breadth, height;

    public Box(int length, int breadth, int height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    public int computeVolume() {
        return (this.length * this.breadth * this.height);
    }
}

public class No6 {
    public static void main(String[] args) {
        Box b1 = new Box(14, 15, 16);
        Box b2 = new Box(16, 17, 18);
        System.out.println("The volume of the box1 is " + b1.computeVolume());
        System.out.println("The volume of the box2 is " + b2.computeVolume());
    }
}
