public class TryDemo {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a++ + b++;// 1+2//3
        int d = ++a + ++b;// 2+4//3+4//7
        int e = 60 / 5 - 34 * 2;// 12-34*2//12-68/-56

        // boolean f = a==b==c;
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        // System.out.println(a==b==c);mildaina garna
    }
}