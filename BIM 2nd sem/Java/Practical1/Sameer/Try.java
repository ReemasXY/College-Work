import java.util.Scanner;

public class Try {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = "SAmeer";
        a = "Teemas";
        System.out.println(a);
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // Modifies the existing object
        System.out.println(sb);
        boolean isEqual = a.equals("Teemas"); // isEqual = true
        System.out.println(isEqual);
        String str = "Sameer";
        String replaced = str.replace('e', 'a'); // replaced = "Hallo"
        System.out.println(replaced);

    }
}