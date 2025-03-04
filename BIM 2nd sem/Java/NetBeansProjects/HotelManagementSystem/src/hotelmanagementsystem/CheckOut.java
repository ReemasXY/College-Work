
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;


class Check extends JFrame implements ActionListener {
JLabel nam,depo,checkdate,day,pending;
     JComboBox room;
     JButton submit, cancel, check;
     int pbill;
    Check()
{
     getContentPane().setBackground(Color.white);// getContentPane selects the whoe frame
        setBounds(250, 180, 890, 530);
        setVisible(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/checkout.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390, 0, 450, 400);
        add(image); 
}
 public void text() {
        JLabel heading = new JLabel("Check-Out");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);

        //Roomno text
        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(60, 70, 120, 30);
        Roomno.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Roomno);

        //RoomAvailable text
        JLabel Name = new JLabel("Name");
        Name.setBounds(60, 130, 120, 30);
        Name.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Name);

        //Room Cleaned text
        JLabel Check = new JLabel("Room Price");
        Check.setBounds(60, 190, 150, 30);
        Check.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Check);

        //Price text
        JLabel Deposit = new JLabel("Deposit ");
        Deposit.setBounds(60, 250, 120, 30);
        Deposit.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Deposit);

        //BedType text
        JLabel Days = new JLabel("Days Spent ");
        Days.setBounds(60, 310, 120, 30);
        Days.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Days);
        
          //BedType text
        JLabel Pending = new JLabel("Pending Bill");
        Pending.setBounds(60, 370, 120, 30);
        Pending.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Pending);

    }
 public void textInputs()
 {
     int rowCount;
      

        try {
            Conn c = new Conn();
            Statement statement = null;
            String query = "SELECT roomnumber FROM room where availability= 'Occupied' ";
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

 }catch (Exception e) {
            e.printStackTrace();
        }
           room.setBounds(200, 75, 150, 30);
        room.setBackground(Color.WHITE);

        // Add a null placeholder as the default valu
        room.setSelectedItem(null); // Set null as the default selected item

        add(room);
        
        nam= new JLabel(": ");
        nam.setBounds(200, 130, 150, 30);
          nam.setFont(new Font("Tahoma", Font.BOLD, 15));
          add(nam);
          
          checkdate= new JLabel(": ");
        checkdate.setBounds(200, 190, 150, 30);
          checkdate.setFont(new Font("Tahoma", Font.BOLD, 15));
          add(checkdate);
          
             depo= new JLabel(": ");
        depo.setBounds(200, 250, 150, 30);
          depo.setFont(new Font("Tahoma", Font.BOLD, 15));
          add(depo);   
          
          
                  day= new JLabel(": ");
        day.setBounds(200, 310, 150, 30);
          day.setFont(new Font("Tahoma", Font.BOLD, 15));
          add(day);   
          
           pending= new JLabel(":");
        pending.setBounds(200, 370, 150, 30);
          pending.setFont(new Font("Tahoma", Font.BOLD, 15));
          add(pending);
          
          
          
 }
 public void confirm()
 {
     try{
                     Conn c = new Conn();
                       String q2 = "UPDATE room SET availability = 'Available' where roomnumber= '"+room.getSelectedItem() + "'";
                       c.s.executeUpdate(q2);
//                   
                      
                      String q3="DELETE from customer where room = '"+room.getSelectedItem() + "'";
                       c.s.executeUpdate(q3);
                       JOptionPane.showMessageDialog(null, "Checked Out Successfully");
                       setVisible(false);
                        CustomerInfo.main(new String[]{});
            }catch(Exception e)
            {
                    e.printStackTrace();
             }
 }
  public void btn() {
        submit = new JButton("Check Out");
        submit.setBounds(190, 420, 140, 40);
//        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        check = new JButton("Show Details");
        check.setBounds(350, 420, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        check.setCursor(new Cursor(Cursor.HAND_CURSOR));
        check.addActionListener(this);
        add(check);

        cancel = new JButton("Back");
        cancel.setBounds(505, 420, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);

    }
  @Override
    public void actionPerformed(ActionEvent e) {
         LocalDate currentDate = LocalDate.now();
    int month = currentDate.getMonthValue(); // Numeric month (1-12)
    int day1 = currentDate.getDayOfMonth();
    int dayspent=0;
    String depositvalue="0";
      if (e.getSource() == check) {
            try {
                Conn c = new Conn();
                  Statement statement = null;
                  statement = c.cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String query = "SELECT * FROM customer where room = '" + room.getSelectedItem() + "'";
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
               
                    submit.setEnabled(true);
                    nam.setText(": "+rs.getString("Name"));
                   
                    depo.setText(": "+rs.getString("deposit"));
                    depositvalue=rs.getString("deposit");
                   int checkinday= rs.getInt("month")*30 + rs.getInt("date");
                   int checkoutday= month*30+day1;
                    dayspent= checkoutday-checkinday;
                   if(checkoutday==checkinday)
                   {
                       dayspent=1;
                   }
                   day.setText(": "+dayspent);
               
                }

                 String query1 = "SELECT price FROM room where roomnumber = '" + room.getSelectedItem() + "'";
                ResultSet rs1= statement.executeQuery(query1);
                if(rs1.next())
                {
                    int roomp=Integer.parseInt(rs1.getString("price"));
                     checkdate.setText(": "+rs1.getString("price")+" (Per day)");
              pbill= roomp*dayspent-Integer.parseInt(depositvalue);
System.out.println(pbill);
pending.setText(": "+pbill);
                }
                else {
    System.out.println("No room price found for the given room number.");
}

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
      else if(e.getSource()== submit)
      {
          if(pbill!=0)
          {
                int response = JOptionPane.showConfirmDialog(
                null,                            // Parent component (null for default)
                "The bill is pending. Are you sure to check-out?",       // Message
                "Confirmation",                  // Title
                JOptionPane.YES_NO_OPTION,       // Option type (Yes/No buttons)
                JOptionPane.QUESTION_MESSAGE     // Message type (Question icon)
                       
        );
             if (response == JOptionPane.YES_OPTION) {
            confirm();
             }
             else if (response == JOptionPane.NO_OPTION) {
            System.out.println("Check-out Canceled");
          }
          
        }
          else{
                 confirm();
          }
      }
      else{
          setVisible(false);
          Reception.main(new String[]{});
          
      }
    }
}

public class CheckOut {
    public static void main(String []args)
    {
        Check c1= new Check();
        c1.text();
        c1.textInputs();
        c1.btn();
    }
}
