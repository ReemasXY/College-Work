class BankAccount {
    int accNo;
    String name, address, phone, gender;

    int ty;

    public BankAccount(int accNo, String name, String address, String phone, String gender) {
        this.accNo = accNo;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("address: " + address);
        System.out.println("phone: " + phone);
        System.out.println("accNo: " + accNo);
        System.out.println("gender: " + gender);
    }
}

class SavingAc extends BankAccount {
    int currentAmount, month;

    public SavingAc(int currentAmount, int month, int accNo, String name, String address, String phone, String gender) {
        super(accNo, name, address, phone, gender);
        this.currentAmount = currentAmount;
        this.month = month;
    }

    public double calcTotal() {
        double TotalAmount;
        if (this.month < 3) {
            TotalAmount = currentAmount + ((double) 2 / 100 * currentAmount);
        } else if (this.month > 3 && this.month < 6) {
            TotalAmount = currentAmount + ((double) 5 / 100 * currentAmount);
        } else if (this.month > 6 && this.month < 12) {
            TotalAmount = currentAmount + ((double) 8 / 100 * currentAmount);
        } else {
            TotalAmount = currentAmount + (11.03 / 100 * currentAmount);
        }
        return TotalAmount;
    }
}

public class No11 {
    public static void main(String[] args) {
        SavingAc s1 = new SavingAc(20000, 13, 11, "Sameer", "Kathmandu", "9841540119", "Male");
        System.out.println("TotalAmount: " + s1.calcTotal());
        s1.showDetails();
    }
}