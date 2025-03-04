package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;

class Customer extends JFrame implements ActionListener {

    JTextField idF, NameF, AddressF, DepositF;
    Choice croom;
    JButton submit, cancel;

    LocalDate currentDate = LocalDate.now();

    // Extract year, month, and day
    int year = currentDate.getYear();
    int month = currentDate.getMonthValue(); // Numeric month (1-12)
    int day = currentDate.getDayOfMonth();

    Customer() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whole frame
        setBounds(250, 170, 890, 550);
        setVisible(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/custo.PNG"));
        Image i2 = i1.getImage().getScaledInstance(630, 430, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 20, 450, 430);
        add(image);
    }

    //for left padding in text field
    public static JTextField createPaddedTextField(int Yaxis) {
        JTextField textField = new JTextField();
        textField.setBounds(150, Yaxis, 150, 30);
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(), // Preserve original border
                BorderFactory.createEmptyBorder(0, 10, 0, 10) // Add padding: top, left, bottom, right
        ));
        return textField;
    }

    public JLabel textAdjust(String text, int Yaxis) {
        JLabel j = new JLabel(text);
        j.setBounds(60, Yaxis, 120, 30);
        j.setFont(new Font("Tahoma", Font.BOLD, 15));
        return j;
    }

    public void text() {
        JLabel heading = new JLabel("New Customer Form");
        heading.setBounds(100, 15, 300, 30);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(heading);

        //id text
        JLabel id = textAdjust("Name", 80);
        add(id);

        //Name text
        JLabel Name = textAdjust("Contact", 145);//30//35
        add(Name);

        JLabel Address = textAdjust("Address", 210);//30//35
        add(Address);

        JLabel Room = textAdjust("Room No ", 275);//30//35
        Room.setSize(80, 30);
        add(Room);

        JLabel Checkin = textAdjust("Check In Time:", 340);//30//35
        add(Checkin);

        JLabel Deposit = textAdjust("Deposit", 390);//30//35
        add(Deposit);

    }

    public void textFields() {
        idF = createPaddedTextField(80);
        add(idF);

        NameF = createPaddedTextField(145);
        add(NameF);

        AddressF = createPaddedTextField(210);
        add(AddressF);

        croom = new Choice();
        croom.setBounds(150, 275, 150, 40);

        try {
            Conn c = new Conn();
            String query = "SELECT * FROM room where availability = 'Available'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        add(croom);

        JLabel checkTime = new JLabel(" " + year + "/" + month + "/" + day);
        checkTime.setBounds(180, 340, 160, 30);
        checkTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(checkTime);

        DepositF = createPaddedTextField(390);
        add(DepositF);

    }

    public void btn() {
        submit = new JButton("Add Customer");
        submit.setBounds(55, 450, 140, 40);
//        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(230, 450, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);
    }
public void validate(String n){
      JOptionPane.showMessageDialog(null,n);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = idF.getText();
            String address = AddressF.getText();
            String contact = NameF.getText();
            String roomNo = (String) croom.getSelectedItem();
            String deposit = DepositF.getText();
            String checkIn= " "+year+"-"+month+"-"+day;
            Boolean correct  = true;

            if(name.trim().isEmpty()||address.trim().isEmpty()||contact.trim().isEmpty()||deposit.trim().isEmpty()){
                correct=false;
                validate("Please Enter all the fields");
            }else if(contact.trim().length()!= 10)
            {
                 correct=false;
                validate("Invalid contact number");
            }
            try {
              if(correct)
              {
                    Conn c = new Conn();
             String query = "INSERT INTO customer (name, address, contact, room, year, month, date, deposit, checkin) VALUES ('"
    + name + "', '"
    + address + "', '"
    + contact + "', '"
    + roomNo + "', "
    + year + ", "
    + month + ", "
    + day + ", "
    + deposit + ", '"
    + checkIn + "')";

//            executeQuery is used to read the data from database
//executeUpdate is used to write and update data in database
                c.s.executeUpdate(query);
                
                 String q2 = "update room set availability = 'Occupied' where roomnumber = "+roomNo;
                                c.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
                 Reception.main(new String[]{});
              }
            } catch (Exception e1) {
                e1.printStackTrace();

            }
        } else {
            setVisible(false);
            Reception.main(new String[]{});
        }
    }
}

public class AddCustomer {

    public static void main(String[] agrs) {
        Customer c = new Customer();
        c.text();
        c.textFields();
        c.btn();
    }
}
