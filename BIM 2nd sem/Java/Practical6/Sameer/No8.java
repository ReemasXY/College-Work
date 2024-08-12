// 8.	Create a class ExamDept which hold the details of student like roll, name, address and faculty and also have methods to set the values of student and display the details of student. Create a subclass Result that inherits Exam dept which have data member to hold marks of five subject and method setMarks() to set the marks of 5 subject, calcPercentage() that calculate the total marks, percentage and division achieved by students and display the achieved results.  Now create the object of Result and demonstrate the above scenario. 
class ExamDept {
    int roll;
    String name, address, faculty;

    public void setData(int roll, String name, String address, String faculty) {
        this.roll = roll;
        this.name = name;
        this.address = address;
        this.faculty = faculty;
    }

    public void display() {
        System.out.println("Roll no: " + roll);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Faculty: " + faculty);

    }
}

public class No8 {

}
