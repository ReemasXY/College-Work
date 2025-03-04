package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Dash extends JFrame implements ActionListener {

    private JLabel image;
    public JButton adm, recp;

    public Dash (String post) {
        setBounds(-7, 0, 1380, 768);
        setVisible(true);
        setLayout(null);
        frameImage();
        adminStaff(post);
    }

    public void frameImage() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/Dashboard.gif"));
        Image i2 = i1.getImage().getScaledInstance(1380, 768, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(-7, 0, 1380, 768);
        add(image);

        // text add
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(390, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 45));
        text.setForeground(Color.white);
        image.add(text);
    }

    public void adminStaff(String post) {
        //boss button
        adm = new JButton("Admins");
       if(!(post.equalsIgnoreCase("admin")))
       {
       adm.setEnabled(false);
       }
        adm.setBounds(850, 485, 140, 40);
        adm.setFont(new Font("Tahoma", Font.BOLD, 15));
        adm.setBackground(new Color(255, 98, 0));
        adm.setForeground(Color.white);
        adm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adm.addActionListener(this);
        image.add(adm);

        //boss imageS
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./next/boss.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 195, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(825, 280, 200, 195);
        image.add(img);

        //reception button
        recp = new JButton("Reception");
        recp.setBounds(430, 480, 140, 40);
        recp.setFont(new Font("Tahoma", Font.BOLD, 15));
        recp.setBackground(new Color(255, 98, 0));
        recp.setForeground(Color.white);
        recp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        recp.addActionListener(this);
        image.add(recp);

        //reception image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("./next/reception.png"));
        Image i5 = i4.getImage().getScaledInstance(200, 195, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel img1 = new JLabel(i6);
        img1.setBounds(400, 280, 200, 195);
        image.add(img1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == adm) {
            AdminDash.main(new String[]{});
        }
        else{
               Reception.main(new String[]{});
        }

    }
}

    public class Dashboard {
        
        public static void main(String[] args) {
           new Dash("admin");
        }
    }
