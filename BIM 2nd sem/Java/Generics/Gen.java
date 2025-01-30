class Demo {
    public <T> void display(T[] arr) {
        for (T a : arr) {
            System.out.println(a);
        }
    }
}

public class Gen {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        String [] arr = { "Sameer", "Matina", "Raj", "Sid" };
        d1.display(arr);
    }
}