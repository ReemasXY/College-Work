package pack2;

import pack1.*;

class Print extends No1 {
    public void display() {
        System.out.println(a);
        // System.out.println(b);//private so cannot be accessed in other package even
        // using subclass
        System.out.println(c);
        // System.out.println(d);// default so cannot be accessed in other package even
        // using subclas
        // System.out.println(b);
    }
}

public class No3 {
    public static void main(String[] args) {
        Print p = new Print();
        p.display();

    }
}
