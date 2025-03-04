package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Employee extends JFrame implements ActionListener {

    JTextField nameF, idF, SalaryF, PhoneF;
    JRadioButton male, female;
    JComboBox job;// dropdown list banauxa yesle
    JButton submit,cancel;

    public Employee() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whoe frame
        setBounds(290, 180, 850, 520);
        setVisible(true);
        setLayout(null);
    }

    //for left padding in text field
    public static JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(), // Preserve original border
                BorderFactory.createEmptyBorder(0, 10, 0, 10) // Add padding: top, left, bottom, right
        ));
        return textField;
    }

    public void text() {
          //Name Text
        JLabel heading = new JLabel("Add Employees");
        heading.setBounds(160, 0, 220, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);
        
        //Name Text
        JLabel id = new JLabel("ID");
        id.setBounds(60, 50, 120, 30);
        id.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(id);

        //age Text
        JLabel name = new JLabel("Name");
        name.setBounds(60, 110, 120, 30);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(name);

        //Gender Text
        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(60, 170, 120, 30);
        Gender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Gender);

        //Job Text
        JLabel Job = new JLabel("Job");
        Job.setBounds(60, 230, 120, 30);
        Job.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Job);

        //Salary Text
        JLabel Salary = new JLabel("Salary");
        Salary.setBounds(60, 290, 120, 30);
        Salary.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Salary);

        //Phone Text
        JLabel Phone = new JLabel("Phone");
        Phone.setBounds(60, 350, 120, 30);
        Phone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Phone);
    }

    public void textField() {
        //name textfield
        idF = createPaddedTextField();
        idF.setBounds(170, 50, 150, 30);
        add(idF);

        //age textfield
        nameF = createPaddedTextField();
        nameF.setBounds(170, 110, 150, 30);
        add(nameF);

        //Gender Radio
        male = new JRadioButton("Male");
        male.setBounds(165, 170, 70, 30);
        male.setFont(new Font("Tahoma", Font.PLAIN, 14));
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma", Font.PLAIN, 14));
        female.setBounds(240, 170, 70, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup bg = new ButtonGroup();//This helps to select either male or female not both at a time
        bg.add(male);
        bg.add(female);
        male.setSelected(true);

        //Dropdown for job
        String jobs[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        job = new JComboBox(jobs);
        job.setBackground(Color.WHITE);
        job.setBounds(170, 230, 150, 30);
        add(job);

        //Salary textfield
        SalaryF = createPaddedTextField();
        SalaryF.setBounds(170, 290, 150, 30);
        add(SalaryF);

        //Phone textfield
        PhoneF = createPaddedTextField();
        PhoneF.setBounds(170, 350, 150, 30);
        add(PhoneF);
    }

    public void btn() {
        submit = new JButton("Submit");
        submit.setBounds(250, 420, 140, 40);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        add(submit);
        
           cancel = new JButton("Back");
        cancel.setBounds(420, 420, 140, 40);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);
    }

    public void img() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 10, 450, 450);
        add(image);
    }

    public void validate(String n) {
        JOptionPane.showMessageDialog(null, n);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
            String name = nameF.getText();// helps to get the text entered inside the name field
        String id = idF.getText();
        String phone = PhoneF.getText();
        String salary = SalaryF.getText();
        String gender = null;

        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String job1 = (String) job.getSelectedItem();//getSelected returns object so converting into string
        Boolean correct = true;
        Boolean sameId = false;
        try {
            String q2 = "SELECT id FROM employee";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(q2);
            while (rs.next()) {
                if (id.trim().equalsIgnoreCase(rs.getString("id"))) {
                    sameId = true;
                    break;
                }
            }
        } catch (Exception ea) {
            ea.printStackTrace();
        }

        if (name.trim().isEmpty() || id.trim().isEmpty() || phone.trim().isEmpty() || salary.trim().isEmpty()) {
            correct = false;
            validate("Please Enter all the fields");
        } else if (phone.trim().length() != 10) {
            correct = false;
            validate("Invalid phone number");
        } else if (sameId) {
            correct = false;
            validate("Id already used.Please choose another");
        }

        //writing in database
        try {
            if (correct) {
                Conn c = new Conn();
                String query = "INSERT INTO employee (id, name, gender, job, salary, phone) VALUES ('"
                        + id + "', '"
                        + name + "', '"
                        + gender + "', '"
                        + job1 + "', '"
                        + salary + "', '"
                        + phone + "')";
//            executeQuery is used to read the data from database
//executeUpdate is used to write and update data in database
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
             
            }

        } catch (Exception ea) {
            ea.printStackTrace();
        }
        }
        else if (e.getSource()==cancel){
            setVisible(false);
              AdminDash.main(new String[]{});
        }

    }
}

public class AddEmployee {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.text();
        e.textField();
        e.btn();
        e.img();
    }
}
