// 5.	Provide example on dynamic method dispatch
//Dynamnic memory dispath simply means reference of parent class stores the child object.
class Parent {

    public void calc(int x, int y) {
        System.out.println("The sum is " + (x + y));
    }
}

class Child extends Parent {
    @Override
    public void calc(int x, int y) {
        System.out.println("The product is " + (x * y));
    }
}

public class No5 {
    public static void main(String[] args) {
        Child c1 = new Child();
        Parent r1 = c1;
        r1.calc(2, 3);
    }
}
