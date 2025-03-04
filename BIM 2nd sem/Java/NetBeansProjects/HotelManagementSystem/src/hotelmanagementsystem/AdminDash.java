
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Admin extends JFrame implements ActionListener{
    JButton addRoom,addEmployee,addDriver;
    JLabel image,image2,image3;
    public Admin()
    {
        getContentPane().setBackground(Color.white);// getContentPane selects the whoe frame
        setBounds(350, 200, 700, 380);
        setVisible(true);
        setLayout(null);
    }
    public void buttons()
    {
    //room buutton
        addRoom= new JButton("Add Room");
        addRoom.setBounds(350, 80, 150, 40);
        addRoom.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addRoom.setBackground(Color.BLACK);
        addRoom.setForeground(Color.white);
        addRoom.addActionListener(this);
        add(addRoom);
        
        
        //Employee buutton
        addEmployee= new JButton("Add Employee");
        addEmployee.setBounds(350, 205, 150, 40);
        addEmployee.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addEmployee.setBackground(Color.BLACK);
        addEmployee.setForeground(Color.white);
        addEmployee.addActionListener(this);
        add(addEmployee);
        
        
   

    }
    
    
    public void addImage(){
        //room image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./next/room.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(160, 50, 100, 100);
        add(image);
        
        //employee image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("./next/employees.png"));
        Image i5 = i4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        image2 = new JLabel(i6);
        image2.setBounds(160, 175, 100, 100);
        add(image2);
        
        
      
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addEmployee)
        {
            setVisible(false);
               AddEmployee.main(new String[]{});
        }
        else if(e.getSource()==addRoom)
        {
              setVisible(false);
               AddRooms.main(new String[]{});
        }
    }
}
public class AdminDash {
    public static void main(String[]args)
    {
        Admin a= new Admin();
        a.buttons();
        a.addImage();
    }
}
