// 3.	Create an interface Shape with a method void myShape(String name). create two class Rectangle and Circle to implement this method. Then instantiated object for each class to call myShape(string) function.
interface Shape {
    void myShape(String name);
}

class Rectangle implements Shape {
    @Override
    public void myShape(String name) {
        System.out.println("This is " + name);
    }
}

class Circle implements Shape {
    @Override
    public void myShape(String name) {
        System.out.println("This is " + name);
    }
}

public class No3 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Circle c1 = new Circle();
        r1.myShape("Rectangle");
        c1.myShape("Circle");
    }
}
