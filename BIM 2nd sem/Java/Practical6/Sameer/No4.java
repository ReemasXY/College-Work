// 4.	Provide example on method overriding condition
class Parent {
    public void display() {
        System.out.println("Display method of parent class");
    }
}

class Child extends Parent {
    public void display() {
        super.display();//calls parent display method whenever child display method is called
        System.out.println("Display method of child class");
    }
}

public class No4 {
    public static void main(String[] args) {
        Child c1 = new Child();
        c1.display();// calls the child method
    }
}