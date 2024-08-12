
// 2.	Provide an example of multi-level inheritance of your choice.
class Parent {
    int x = 10;

    public void parentMethod() {
        System.out.println("This is parent method with value" + this.x);
    }
}

class Child extends Parent {
    int x = 20;

    public void childMethod() {

        System.out.println("This is child method with value" + this.x);
    }
}

class GrandChild extends Child {
    public void grandChildMethod() {

        System.out.println("This is  grand child method with value" + this.x);// immediate parent ko lai priority dinxa

    }
}

public class No2 {
    public static void main(String[] args) {
        GrandChild g1 = new GrandChild();
        g1.parentMethod();
        g1.childMethod();
        g1.grandChildMethod();
    }

}
