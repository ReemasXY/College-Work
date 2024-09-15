
class hello {
    static int x;
    int y = 100;

    public static void display1() {
        // System.out.println(this.y);
    }

    public void display() {
        System.out.println(x);
    }

    
}

public class TryDemo {
    public static void main(String[] args) {
        hello h1 = new hello();
        h1.display();
    }
}