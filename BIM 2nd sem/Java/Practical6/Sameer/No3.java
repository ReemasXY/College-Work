// 3.	Provide example on how constructor of super class is called. 
// note whenever child class constructor is called parent class ko constructor call hunaa nai parxa explicit user le deko wala constructor not the compiler one
class Parent {
    public Parent() {
        System.out.println("Default constructor of parent");// default constructor is called automatically whenever the
                                                            // child object is created

    }

    public Parent(int x) {
        System.out.println("Parameterized constructor of parent " + x);
    }
}

class Child extends Parent {
    public Child() {
        System.out.println("Default construtor of child");
    }

    public Child(int x) {
        super(20);// It calls the parameterized constructor of parent as is doesn't get called
                  // automatically;
        System.out.println("Parameterized constructor of child " + x);
    }
}

public class No3 {
    public static void main(String[] args) {
        Child c1 = new Child();
        Child c2 = new Child(100);
    }

}
