package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Update extends JFrame implements ActionListener {

    JTextField priceF;
    JComboBox roomavai, cleanCombo, BedType, room;
    JButton submit, cancel, check;

    Update() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whoe frame
        setBounds(250, 180, 890, 500);
        setVisible(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390, 60, 450, 300);
        add(image);

    }

    public static JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(), // Preserve original border
                BorderFactory.createEmptyBorder(0, 10, 0, 10) // Add padding: top, left, bottom, right
        ));
        return textField;
    }

    public void text() {
        JLabel heading = new JLabel("Update Room Status");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        //Roomno text
        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(60, 100, 120, 30);
        Roomno.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Roomno);

      
        //Room Cleaned text
        JLabel cleanStatus = new JLabel("Cleaned Status");
        cleanStatus.setBounds(60, 160, 120, 30);
        cleanStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(cleanStatus);

        //Price text
        JLabel Price = new JLabel("Price ");
        Price.setBounds(60, 220, 120, 30);
        Price.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(Price);

        //BedType text
        JLabel BedType = new JLabel("Bed Type ");
        BedType.setBounds(60, 275, 120, 30);
        BedType.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(BedType);

    }

    public void textInputs() {
        //Room no field

        // 
        int rowCount;
        try {
            Conn c = new Conn();
            Statement statement = null;
            String query = "SELECT roomnumber FROM room";
            statement = c.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(query);
            // Move the cursor to the last row to get the row count
            rs.last();
            rowCount = rs.getRow();  // Get the number of row
            // Optionally, move the cursor back to the first row if needed
            rs.beforeFirst();
            System.out.println("Number of rows: " + rowCount);
            System.out.println(rowCount);
            String roomnos[] = new String[rowCount];
            int i = 0;
            // Iterate through the ResultSet and count rows
            while (rs.next()) {
                roomnos[i] = rs.getString("roomnumber");
                i++;
            }
            room = new JComboBox(roomnos);

        } catch (Exception e) {
            e.printStackTrace();
        }

        room.setBounds(200, 100, 150, 30);
        room.setBackground(Color.WHITE);

        // Add a null placeholder as the default valu
        room.setSelectedItem(null); // Set null as the default selected item

        add(room);

       

//        Room cleaned
        String arr1[] = {
            "Cleaned",
            "Dirty"
        };
        cleanCombo = new JComboBox(arr1);
        cleanCombo.setBounds(200, 160, 150, 30);
        cleanCombo.setBackground(Color.WHITE);
        cleanCombo.setEnabled(false);
        cleanCombo.setSelectedItem(null);
        add(cleanCombo);

        //Price field
        priceF = createPaddedTextField();
        priceF.setBounds(200, 220, 150, 30);
        priceF.setEnabled(false);
        add(priceF);

        //Bed type field
        String arr2[] = {
            "Single Bed",
            "Double Bed"
        };
        BedType = new JComboBox(arr2);
        BedType.setBounds(200, 275, 150, 30);
        BedType.setBackground(Color.WHITE);
        BedType.setSelectedItem(null);
        BedType.setEnabled(false);
        add(BedType);

    }

    public void btn() {
        submit = new JButton("Update");
        submit.setBounds(190, 390, 140, 40);
//        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        check = new JButton("Check");
        check.setBounds(350, 390, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        check.setCursor(new Cursor(Cursor.HAND_CURSOR));
        check.addActionListener(this);
        add(check);

        cancel = new JButton("Back");
        cancel.setBounds(505, 390, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM room where roomnumber = '" + room.getSelectedItem() + "'";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    BedType.setEnabled(true);
                   
                    cleanCombo.setEnabled(true);
                    priceF.setEnabled(true);
                    submit.setEnabled(true);
                 
                    cleanCombo.setSelectedItem(rs.getString("cleaningStatus"));
                    BedType.setSelectedItem(rs.getString("bedType"));
                    priceF.setText(rs.getString("price"));
             
                }

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource() == submit) {
            try {
                Conn c = new Conn();
              String q2 = "UPDATE room SET "
          
          + "cleaningStatus = '" + cleanCombo.getSelectedItem() + "', "
          + "bedType = '" + BedType.getSelectedItem() + "', "
          + "price = '" + priceF.getText() + "' "
          + "WHERE roomnumber = '"+ room.getSelectedItem()+"'" ;


                c.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Room Updated Successfully");
                setVisible(false);
                  AllRooms.main(new String[]{});
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
          else{
    setVisible(false);
       Reception.main(new String[]{});
}
    }
  
}

    public class UpdateRoom {

        public static void main(String[] args) {
            Update u = new Update();
            u.text();
            u.textInputs();
            u.btn();

        }
    }
