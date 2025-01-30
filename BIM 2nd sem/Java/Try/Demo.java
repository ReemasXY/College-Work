
import java.io.*;

public class Demo {
    public static void main(String[] args) {
        String s = "Sameer";
        int len = s.length();
        boolean t = true;
        for (int i = 2; i < len; i++) {
      
            if (len % i == 0) {
                t = false;
                break;
            }
        }
        if (t) {
            try {
                File f = new File("prime.txt");
                FileWriter fos = new FileWriter(f);
                fos.write(s);
                fos.close();

            } catch (IOException e) {
                System.out.println(e);
            }
        }
        else{
            try {
                File f = new File("composite.txt");
                FileWriter fos = new FileWriter(f);
                fos.write(s);
                fos.close();

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}