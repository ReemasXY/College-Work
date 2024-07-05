public class No3 {
    // WAP to describe floating point literals (exponential and normal), Boolean
    // literals, character literals, string literals(uses of escape sequence)

    public static void main(String[] args) {
        // Floating Point Literals
        double eFloat = 1.2e2; // 1.2040 * 10^2
        double Float = 1.8;
        // Boolean Literals
        boolean tL = true;
        // Character Literals
        char ch = 'S';
        // String Literals with Escape Sequence
        String nL = "\nHello World";
        // Common Escape Sequences
        String bS = "Backslash: \\";
        String sQ = "Single Quote : \'";
        String dQ = "Double Quote: \"\"";
        // Display
        System.out.println("Exponential Float: " + eFloat);
        System.out.println("Normal Float " + Float);
        System.out.println("Boolean Literal: " + tL);
        System.out.println("Character Literal: " + ch);
        System.out.println("String Literals with Escape Sequence: ");
        System.out.println("Next Line Character: " + nL);
        System.out.println(bS);
        System.out.println(sQ);
        System.out.println(dQ);
    }
}
