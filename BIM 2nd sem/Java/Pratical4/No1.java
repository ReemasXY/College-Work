// 1.	Create a class Student having data member roll (int), name (string), address (string), gender (string), faculty (string) and method setData() to set the value of data member and display method that display the data of student. Now create two object of Student and invoke set and display method.
class Student {
    private int roll;
    private String name, gender, address, faculty;// all private instance variable

    public void setData(int roll, String name, String gender, String address, String faculty) {
        this.roll = roll;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.faculty = faculty;
    }

    public void displayData() {
        System.out.println("Name= " + this.name + "\nRoll =" + this.roll + "\nGender= " + this.gender + "\nAddress= "
                + this.address + "\nFaculty= " + this.faculty);
    }
}

public class No1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.setData(12, "Sameer Maharjan", "Male", "Khusibun", "Management");
        s2.setData(12, "Ram Shretha", "Male", "Nayabazar", "Management");
        s1.displayData();
        s2.displayData();
    }
}