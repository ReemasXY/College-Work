// 6.	Create a class Book with member variables book_id and pages. Then create a subclass FictionBooks of Book with member variable called name. Create some instance of FictionBook and set the value of both subclass and superclass and display all member variables that have been initialized.
class Book {
    int book_id;
    int pages;

    public Book(int book_id, int pages) {
        this.book_id = book_id;
        this.pages = pages;
    }

}

class FictionBook extends Book {

    String name;

    public FictionBook(int book_id, int pages, String name) {
        super(book_id, pages);
        this.name = name;
    }

    public void display() {
        System.out.println("Book id: " + this.book_id);
        System.out.println("Pages: " + this.pages);
        System.out.println("Name: " + this.name);
    }

}

public class No6 {
    public static void main(String[] args) {
        FictionBook f1 = new FictionBook(100, 123, "Chetan Bhagat");
        f1.display();
    }

}
