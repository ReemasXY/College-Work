/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

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
            String filetxt = "";
            String filePath = "./src/files/admin.txt"; // Replace with your file path

            try (FileReader fr = new FileReader(filePath)) {
                StringBuilder line = new StringBuilder();
                int ch;
                while ((ch = fr.read()) != -1) {
                    if (ch == '\n') {
                        break; // End of the line
                    }
                    line.append((char) ch);
                }
                filetxt = line.toString();
                String[] arr = filetxt.split(",");
                if (arr[0].equals(user) && arr[1].equals(pass)) {
                    HospitalManagementSystem.main(new String[]{});
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");// alert jastai ho js ko 
         
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else{
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
