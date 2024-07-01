public class No11 {
    public static void main(String[] args) {
        System.out.println("Prime numbers from 1-100");
        for (int i = 1; i <= 100; i++) {
            boolean isprime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime) {
                System.out.print(" " + i);
            }
        }
    }
}
