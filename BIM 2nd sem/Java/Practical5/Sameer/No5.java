// Create an abstract class FMachine having methods getData() and putData(). Derive a class Airplane having instance variable code, name, capacity and methods getData() and putData() that overrides method of abstract class to read and display the result. Create some instances of Airplane and call the required methods. 

abstract class FMachine {
    abstract void getData(int code, int capacity, String name);

    abstract void putData();
}

class Airplane extends FMachine {
    int code, capacity;
    String name;

    public void getData(int code, int capacity, String name) {
        this.code = code;
        this.capacity = capacity;
        this.name = name;
    }

    public void putData() {
        System.out.println("Name: " + this.name);
        System.out.println("Capacity: " + this.capacity);
        System.out.println("Code: " + this.code);
    }
}

public class No5 {
    public static void main(String[] args) {
        Airplane a1 = new Airplane();
        a1.getData(123, 12000, "Yeti");
        // a1.getData(112, 14000, "Buddha");
        a1.putData();
    }
}
