import java.io.*;
import java.util.*;

public class Two {
    public static void main(String[] args) {
        System.out.println("Enter a ling of Stirng");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        try {
            File f1 = new File("a.txt");
            if (!f1.exists()) {
                f1.createNewFile();
            }
            FileWriter fw = new FileWriter(f1);
            fw.write(data);
            fw.close();

            File f2 = new File("b.txt");
            FileReader fr = new FileReader(f1);
            FileWriter fw1 = new FileWriter(f2);
            int i;
            while ((i = fr.read()) != -1) {
                fw1.write((char) i);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("File written successfully");
    }
}
