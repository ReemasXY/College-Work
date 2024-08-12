// The StringBuilder and StringBuffer are almost same just diff in thread safety 

// The following methods can be used in both StirngBuilder and StringBuffer

//all the methods will change the original string i.e the changes made using these methods will reflect in s1 and s2

public class Demo {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("Hello");
        StringBuffer s2 = new StringBuffer("Hello");

        // append
        s1.append(" World");
        s2.append(" World");
        System.out.println(s1);
        System.out.println(s2);

        // delete
        s1.delete(5, 11);
        s2.delete(5, 11);
        System.out.println(s1);
        System.out.println(s2);

        // replace
        s1.replace(0, 6, "Java");
        s2.replace(0, 6, "Java");
        System.out.println(s1);
        System.out.println(s2);

        // reverse
        s1.reverse();
        s2.reverse();
        System.out.println(s1);
        System.out.println(s2);

        // charAt

        System.out.println(s1.charAt(1));
        System.out.println(s2.charAt(1));

        // length
        System.out.println(s1.length());
        System.out.println(s2.length());
    }
}