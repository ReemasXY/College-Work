// 1.	Create a interface Exam with methods setExam(String division, int mark) and showExam(). Create a class named test that implements the interface Exam and then display the records
interface Exam {
    public void setExam(String division, int mark);

    public void showExam();
}

class Test implements Exam {
    String division;
    int mark;

    @Override
    public void setExam(String division, int mark) {
        this.division = division;
        this.mark = mark;
    }

    @Override
    public void showExam() {
        System.out.println("Division=" + this.division);
        System.out.println("Mark=" + this.mark);

    }
}

public class No1 {
    public static void main(String[] args) {

        Test t1 = new Test();
        t1.setExam("Distinction", 100);
        t1.showExam();
    }
}