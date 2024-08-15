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

class Result extends ExamDept {
    int m1, m2, m3, m4, m5;

    public void setMarks(int m1, int m2, int m3, int m4, int m5) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
    }

    public void calcPercentage() {
        int total = m1 + m2 + m3 + m4 + m5;
        double per = ((double) total / 500) * 100;
        String div = "";
        if (per > 80) {
            div = "Distinction";
        } else if (per > 60) {
            div = "Excellent";
        } else if (per > 40) {
            div = "Good";
        } else {
            div = "fail";
        }
        System.out.println("Total Marks= " + total);
        System.out.println("Percentage=" + per);
        System.out.println("Division=" + div);
    }

}

public class No8 {
    public static void main(String[] args) {
        Result r1 = new Result();
        r1.setData(1, "Sameer", "KTM", "Mgmt");
        r1.setMarks(90, 80, 90, 80, 90);
        r1.display();
        r1.calcPercentage();
    }
}
