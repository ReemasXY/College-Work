package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class RunFrame extends JFrame implements ActionListener {

    public String post;
    JTextField userText;
    JPasswordField passText;// JPassword Field le chai user le password rakheko lai hide garxa frontend ma 
    JButton cancel, login;

    //for Frame
    public void Frame() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whoe frame
        setBounds(400, 200, 600, 300);
        setVisible(true);
        setLayout(null);
    }

    //for username and password
    public void user() {

        //username
        JLabel userName = new JLabel("Username");
        userName.setBounds(40, 40, 100, 20);
        add(userName);
        userText = new JTextField();// Input bar for username
        userText.setBounds(150, 35, 150, 30);
        add(userText);

        //password
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 100, 100, 20);
        add(pass);
        passText = new JPasswordField();// Input bar for password
        passText.setBounds(150, 95, 150, 30);
        add(passText);
    }

    //for button
    public void button() {
        //login button
        login = new JButton("Login");
        login.setBounds(40, 160, 120, 30);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

//cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 160, 120, 30);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
    }

    public void runImage() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        //Adjusting image size
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        //Image class object cannot be placed in JLabel so changing into ImageIcon class object
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String user = userText.getText();// getText helps to get the value(String) entered by the user in the textfield
            String pass = passText.getText();

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username = '" + user + "' and password = '" + pass + "'";
                ResultSet result = c.s.executeQuery(query); // if the useraname and pass is there in database then it returns username and pass or else null
// to store the result from database ResultSet class from sql package is used

                if (result.next()) {// result.next() le chai database bata value ako xa ki nai herxa 
                    setVisible(false);
                    post = result.getString("post");
                    new Dash(post);
//                  
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");// alert jastai ho js ko 
                    setVisible(false);
                }

            } catch (Exception err) {
                err.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

}

public class Login {

    public static void main(String[] args) {

        RunFrame s = new RunFrame();
        s.Frame();
        s.user();
        s.button();
        s.runImage();
    }
}
