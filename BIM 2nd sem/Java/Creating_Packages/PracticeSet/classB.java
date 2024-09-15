
import pack1.*;

class B extends classA {
    public void display() {
        System.out.println(a);
    }
}

public class classB {
    public static void main(String[] args) {
        classA obj = new classA();
        // System.out.println(obj.a);
        B obj1 = new B();
        obj1.display();
        // System.out.println(obj1.a);


    }
}
