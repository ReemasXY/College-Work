package hotelmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//Action listener is in this package

//action Listener is same like addeventlistener 

public class HotelManagementSystem extends JFrame implements ActionListener {

    public HotelManagementSystem() {
        setSize(1366, 565);// used to make the frame of the image(height and width of image)
        setVisible(true);// by default frame is hidden so to show it this function is used
        setLocation(0, 80);// by default frame comes from top left to ajust it this function is used
//        setBounds(0,80,1366,565); milxa yo ni

        //layout helps to add components in the frame 
        //layour means inside frame
        // by default layout is border with center
        setLayout(null);// default layout (border layout lai hatauxa)
        // by doing null we need to place each and every components or else it won't display

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));// helps to get required image
        // from the pc or file DIRECTORY

        //JLabel helps to add components in the frame like text image shown below                                                                                   
        JLabel image = new JLabel(i1);

        //setBounds helps to move and adjust the size of components inside the frame
        image.setBounds(0, 0, 1366, 565);// same like setsize and set location just diff is yo frame ko respect ma size ra location hunxa not of screen
        add(image);//this actually helps to add the image in the frame

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(80, 440, 1000, 100);
        //setForeground helps to change the color of text
        //Color class is inside java.awt
        text.setForeground(Color.white);

        text.setFont(new Font("serif", Font.PLAIN, 40));// helps to adjust font size style and family

//        add(text); image ko zindex besi hunxa ani text hide
        image.add(text);// image ko mathi text auxa aba yesle

        JButton next = new JButton("Next");// helps to add the button in the frame
        next.setBounds(1200, 460, 100, 45);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.DARK_GRAY);
        next.setFont(new Font("serif", Font.PLAIN, 16));
next.addActionListener(this);//tells which button has been triggered
                next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.add(next);

        // flicker effect
        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);// used to hold the code for 500ms
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
              try {
                Thread.sleep(500);// used to hold the code for 500ms
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


  
    }
@Override
      public void actionPerformed(ActionEvent ae)
        {
setVisible(false);
   Login.main(new String[] {});//callig main method of Login.java
}

    public static void main(String[] args) {
        new HotelManagementSystem();
    
    }

}
