// 7.	Create a class Product with name, qty and price. Create a parameterized constructor to set the product details. Provide the method getName(), getQty() and getPrice() that return product name, qty and price. Also create method getTotal() that returns the total price. Then create a class ProductDemo with main method that creates two object of Product and find the total price of both products.
class Product {
    private String name;
    private int qty, price;

    public Product(String name, int qty, int price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getQty() {
        return this.qty;
    }

    public int getPrice() {
        return this.price;
    }

    public int getTotal() {
        return (this.price * this.qty);
    }
}

public class No7 {
    public static void main(String[] args) {
        Product p1 = new Product("Soap", 10, 50);
        Product p2 = new Product("Comb", 5, 30);
        System.out.println("The total price of " + p1.getName() + " is " + p1.getTotal());
        System.out.println("The total price of " + p2.getName() + " is " + p2.getTotal());

    }

}
