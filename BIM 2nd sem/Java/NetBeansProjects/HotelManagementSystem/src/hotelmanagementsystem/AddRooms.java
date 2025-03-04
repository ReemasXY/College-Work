package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

class Rooms extends JFrame implements ActionListener {

    JTextField roomnoF, priceF;
    JComboBox roomavai, cleanCombo, BedType;
    JButton submit, cancel;
    //for left padding in text field

    public static JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(), // Preserve original border
                BorderFactory.createEmptyBorder(0, 10, 0, 10) // Add padding: top, left, bottom, right
        ));
        return textField;
    }

    Rooms() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whoe frame
        setBounds(250, 180, 890, 500);
        setVisible(true);
        setLayout(null);
    }

    public void text() {
        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        //Roomno text
        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(60, 70, 120, 30);
        Roomno.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Roomno);

        //RoomAvailable text
        JLabel RoomAvailable = new JLabel("Available");
        RoomAvailable.setBounds(60, 130, 120, 30);
        RoomAvailable.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(RoomAvailable);

        //Room Cleaned text
        JLabel cleanStatus = new JLabel("Cleaned Status");
        cleanStatus.setBounds(60, 190, 200, 30);
        cleanStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cleanStatus);

        //Price text
        JLabel Price = new JLabel("Price ");
        Price.setBounds(60, 250, 120, 30);
        Price.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Price);

        //BedType text
        JLabel BedType = new JLabel("Bed Type ");
        BedType.setBounds(60, 310, 120, 30);
        BedType.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(BedType);

    }

    public void textInputs() {
        //Room no field
        roomnoF = createPaddedTextField();
        roomnoF.setBounds(200, 70, 150, 30);
        add(roomnoF);

        //room available
        String arr[] = {
            "Available",
            "Occupied"
        };
        roomavai = new JComboBox(arr);
        roomavai.setBounds(200, 130, 150, 30);
        roomavai.setBackground(Color.WHITE);
        add(roomavai);

        //Room cleaned
        String arr1[] = {
            "Cleaned",
            "Dirty"
        };
        cleanCombo = new JComboBox(arr1);
        cleanCombo.setBounds(200, 190, 150, 30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);

        //Price field
        priceF = createPaddedTextField();
        priceF.setBounds(200, 250, 150, 30);
        add(priceF);

        //Bed type field
        String arr2[] = {
            "Single Bed",
            "Double Bed"
        };
        BedType = new JComboBox(arr2);
        BedType.setBounds(200, 310, 150, 30);
        BedType.setBackground(Color.WHITE);
        add(BedType);

    }

    public void btn() {
        submit = new JButton("Add Room");
        submit.setBounds(55, 390, 140, 40);
//        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(210, 390, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);
    }

    public void img() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390, 60, 450, 300);
        add(image);
    }
    public void validate(String n) {
        JOptionPane.showMessageDialog(null, n);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == submit) {
            String roomnumber = roomnoF.getText();
            String roomavailabe = (String) roomavai.getSelectedItem();
            String cleanstatus = (String) cleanCombo.getSelectedItem();
            String price = priceF.getText();
            String bedtype = (String) BedType.getSelectedItem();
            
               Boolean correct = true;
        Boolean sameRoomNo = false;
        try {
            String q2 = "SELECT roomnumber FROM room";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(q2);
            while (rs.next()) {
                if (roomnumber.trim().equalsIgnoreCase(rs.getString("roomnumber"))) {
                    sameRoomNo = true;
                    break;
                }
            }
        } catch (Exception ea) {
            ea.printStackTrace();
        }

        if (roomnumber.trim().isEmpty() || price.trim().isEmpty()) {
            correct = false;
            validate("Please Enter all the fields");
        } else if (sameRoomNo) {
            correct = false;
            validate("Room Number already used.Please choose another");
        }

            try{
                if(correct)
                {
                    Conn c= new Conn();
                 String query = "INSERT INTO room (roomnumber, availability, cleaningStatus, price, bedType) VALUES ('" 
                + roomnumber + "', '" 
                + roomavailabe + "', '" 
                + cleanstatus + "', '" 
                + price + "', '" 
                + bedtype + "' )";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"New Room Added Successfully");

                }
            }catch(Exception ei)
            {
                ei.printStackTrace();
            }
        } else if(e.getSource() == cancel) {
            setVisible(false);
              AdminDash.main(new String[]{});
        }
    }
}

public class AddRooms {

    public static void main(String[] args) {
        Rooms r = new Rooms();
        r.text();
        r.textInputs();
        r.btn();
        r.img();
    }

}
