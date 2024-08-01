
//Create a class Student having data member roll, name, address, faculty, grade(string). Create suitable constructor to set the details of student and methods findDivision() that calculates the division of student based on grade achieved and return the division( if grade=A+ then distinction, if grade=A then very good, grade B+ then first division, grade B then second division , grade C then pass in individual subject and if grade D the fail), display() method that display the student details and also display the division achieved by the student in main method. Now create the instance of two students and demonstrate the above scenario.
class Student {
    private int roll;
    private String name, address, faculty, grade;

    public Student(int roll, String name, String address, String faculty, String grade) {
        this.roll = roll;
        this.name = name;
        this.address = address;
        this.faculty = faculty;
        this.grade = grade;
    }

    public String findDivision() {
        if (grade == "A+") {
            return "Distinction";
        } else if (grade == "A") {
            return "Very Good";
        } else if (grade == "B+") {
            return "First Division";
        } else if (grade == "B") {
            return "Second Division";
        } else if (grade == "C") {
            return "Pass in all";
        } else {
            return "Fail";
        }
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll: " + roll);
        System.out.println("Address: " + address);
        System.out.println("Grade: " + grade);
        System.out.println("Faculty: " + faculty);
        System.out.println("Division: " + this.findDivision());
    }
}

public class No2 {
    public static void main(String[] args) {
        Student s1 = new Student(19, "Sameer Maharjan", "Nayabazar", "Management", "A+");
        Student s2 = new Student(20, "Reemas Shrestha", "Chamati", "Management", "A");
        s1.display();
        System.out.println("\n");
        s2.display();
    }
}
