
// 2.	Create a class named Book with instance variables title and price. Add a method named setVar to pass parameter for title and price. Add another method named showVar to display values of these variables. Now in main() declare 4 objects of book and display the records of book that matched with word “java”.
import java.util.*;

class Book {
    String title;
    int price;

    public void setVar(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public void showVar() {
        System.out.println("Title: " + this.title);
        System.err.println("Price: " + this.price);
    }
}

public class No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] arr = new Book[4];
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter the title of the book: ");
            String title = sc.next();
            System.out.println("Enter the price of the book: ");
            int price = sc.nextInt();
            arr[i] = new Book();
            arr[i].setVar(title, price);
        }
        for (Book s1 : arr) {
            if (s1.title.equalsIgnoreCase("java")) {
                s1.showVar();
            }
        }

    }
}