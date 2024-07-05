public class No18 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i == 25 || i == 40 || i == 90) {
                continue;
            } else {
                System.out.print(" "+i);
            }
        }
    }
}
