public class No4 {
    public static void main(String[] args) {
        System.out.println("Implicit type casting (int to double)");
        int a = 20;
        double b = a;
        System.out.println("Int=" + a + " Double=" + b);
        System.out.println("Explicit type casting (double to int)");
        double c = 20.20;
        int d = (int) c;
        System.out.println("Double= " + c + " Int=" + d);
    }
}