// 1.	Provide an example of single inheritance of your choice. (Two child class inheriting single parent class)
class Record {
    String name, address;

    public void setDetails(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

class Student extends Record {
    int room;

    public void displayStu(int room) {
        this.room = room;
        System.out.println("Name=" + this.name);
        System.out.println("Adress: " + this.address);
        System.out.println("Room no: " + this.room);
    }
}

class Teacher extends Record {
    int salary;

    public void displayTeach(int salary) {
        this.salary = salary;
        System.out.println("Name=" + this.name);
        System.out.println("Adress: " + this.address);
        System.out.println("Salary: " + this.salary);
    }
}

public class No1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setDetails("Sameer", "KTM");
        s1.displayStu(12);

        Teacher t1 = new Teacher();
        t1.setDetails("Ramesh", "KTM");
        t1.displayTeach(20000);
    }
}