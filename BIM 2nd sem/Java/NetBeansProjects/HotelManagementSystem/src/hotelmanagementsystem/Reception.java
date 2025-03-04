package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Recep extends JFrame implements ActionListener {

    JButton newCustomer, allEmployee, checkout, updateStatus, search, Rooms,customerinfo;

    Recep() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whole frame
        setBounds(250, 170, 890, 550);
        setVisible(true);
        setLayout(null);
        
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/Reception.png"));
        Image i2 = i1.getImage().getScaledInstance(630, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 10, 450, 450);
        add(image);
    }

    public JButton adjustment(String text, int Yaxis) {
        JButton j = new JButton(text);
        j.setBounds(60, Yaxis, 180, 40);
        j.setBackground(Color.BLACK);
        j.setForeground(Color.white);
        j.setCursor(new Cursor(Cursor.HAND_CURSOR));
        j.setFont(new Font("Tahoma", Font.PLAIN, 16));
        return j;
    }

    public void btn() {
        newCustomer = adjustment("Customer Form", 30);//40 //30
        newCustomer.addActionListener(this);
        add(newCustomer);

        allEmployee = adjustment("All Employees", 100);//30
              allEmployee.addActionListener(this);
        add(allEmployee);

        Rooms = adjustment("Rooms", 170);//30
              Rooms.addActionListener(this);
        add(Rooms);
        
          customerinfo = adjustment("Customer Info", 240);//30
                customerinfo.addActionListener(this);
        add(customerinfo); 
        
        checkout = adjustment("Checkout", 310);//30
              checkout.addActionListener(this);
        add(checkout);

        updateStatus = adjustment("Update Room Status", 380);//30
              updateStatus.addActionListener(this);
        add(updateStatus);

        search = adjustment("Search Room", 450);//30
              search.addActionListener(this);
        add(search);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
if(e.getSource()==newCustomer)
{
       AddCustomer.main(new String[]{});
}else if(e.getSource()==Rooms)
{
           AllRooms.main(new String[]{});
}
else if(e.getSource()== allEmployee)
    {
         EmployeeInfo.main(new String[]{});
    }
else if(e.getSource()==customerinfo)
{
    CustomerInfo.main(new String[]{});
}
else if(e.getSource()==search)
{
    Search.main(new String[]{});
}
else if(e.getSource()==updateStatus)
{
    UpdateRoom.main(new String[]{});
}
else if(e.getSource()==checkout){
      CheckOut.main(new String[]{});
}
    } 
}

public class Reception {

    public static void main(String[] args) {
        Recep r = new Recep();
        r.btn();
    }

}
