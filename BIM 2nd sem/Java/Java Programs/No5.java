
public class No5 {
    public static void main(String[] args) {
        int a = 10, b = 20, c = 30;
        System.out.println("Eample of arithemetic operator");
        System.out.println("a + b = " + (a + b));
        System.out.println("Example of post increment operator");
        System.out.println("a++ = " + (a++));// 10
        System.out.println("Example of pre increment operator");
        System.out.println("++a = " + (++a));// 12
        System.out.println("Example of post decrement operator");
        System.out.println("b-- = " + (b--));// 20
        System.out.println("Example of pre decrement operator");
        System.out.println("--b = " + (--b));// 18
        System.out.println("Example of comparison operator");
        System.out.println((a > b) ? a : b);
        System.out.println("Example of && operator");
        System.out.println((a < b && a < c) ? a : b);
        System.out.println("Example of || operator");
        System.out.println((b < a || b < c) ? b : c);
        System.out.println("Example of ! operator");
        System.out.println(!(a < b && a < c) ? a : b);
    }
}