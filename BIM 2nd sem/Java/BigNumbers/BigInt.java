import java.math.*;

public class BigInt {
    public static void main(String[] args) {
        // BigInteger b1 = new BigInteger();
        // b1 = 213131231231; cannot do this even if string is passed
        // BUTTTTTT b1 ma arko big Integer store garna milxa
        // b1= new BigInteger("1231313") valid

        BigInteger b1 = new BigInteger("13231321312");// Yesma chai string pass garnu nai parxa
        // BigInteger b1 = new BigInteger(13231321312);//error auxa
        System.out.println(b1);

        BigInteger b2 = BigInteger.valueOf(125);// also valid however valueof ko bhitra integer hunu nai paryo no stirng
                                                // is allowed
        // also the valueOf should be an in integer range it cannot go beyong it if it
        // does it shows error
        // BigInteger b2 = BigInteger.valueOf(125446656546544664654654);// error cuz its
        // beyong range of the interger
        System.out.println(b2);

        // Constant
        BigInteger D = BigInteger.ONE;// valid
        System.out.println(D);

        // some methods
        BigInteger b3 = b1.add(b2);
        BigInteger b4 = b1.multiply(b2);
        BigInteger b5 = b1.divide(b2);
        BigInteger b6 = b1.subtract(b2);
        // BigInteger b7= b1*b2; yesto garna mildaina

        System.out.println("\n" + b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);

        Demo d1 = new Demo();
        d1.hello();
        d3 d2 = new d3();
        d2.hell();
    }
}