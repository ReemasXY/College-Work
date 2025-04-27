
package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class DoctorUI extends JFrame implements ActionListener {

    JTextField idF, NameF, ContactF, FeesF, AddressF;

 
    JButton submit, cancel;

    DoctorUI() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whole frame
        setBounds(250, 100, 850, 570);
        setVisible(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/doctor2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 370, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 60, 450, 370);
        add(image);
    }

    public void Heading() {
        JLabel heading = new JLabel("Doctor Enrollment Form");
        heading.setBounds(300, 0, 600, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
//         heading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); 
        add(heading);
    }

    public void addHeadingBorder() {
        JPanel line = new JPanel();
        line.setBackground(Color.GRAY);
        line.setBounds(0, 40, getWidth(), 4); // y = 35 just below the heading
        add(line);
    }

    //for left padding in text field
    public static JTextField createPaddedTextField(int Yaxis) {
        JTextField textField = new JTextField();
        textField.setBounds(220, Yaxis, 160, 30);
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(), // Preserve original border
                BorderFactory.createEmptyBorder(0, 10, 0, 10) // Add padding: top, left, bottom, right
        ));
        return textField;
    }

    public JLabel textAdjust(String text, int Yaxis) {
        JLabel j = new JLabel(text);
        j.setBounds(80, Yaxis, 120, 30);
        j.setFont(new Font("Tahoma", Font.BOLD, 15));
        return j;
    }

    public void text() {

        //id text
        JLabel id = textAdjust("Doctor ID", 80);
        add(id);

        //Name text
        JLabel Name = textAdjust("Name", 145);//30//35
        add(Name);

        JLabel Address = textAdjust("Address", 210);//30//35
        add(Address);

        JLabel Contact = textAdjust("Contact ", 275);//30//35
        Contact.setSize(80, 30);
        add(Contact);

        JLabel Status = textAdjust("Status", 340);//30//35
        add(Status);

        JLabel Fees = textAdjust("Fees", 400);//30//35
        add(Fees);

    }

    public void textFields() {
        idF = createPaddedTextField(80);
        add(idF);

        NameF = createPaddedTextField(145);
        add(NameF);
        
         AddressF = createPaddedTextField(210);
        add(AddressF);

        ContactF = createPaddedTextField(275);
        add(ContactF);

       JLabel StatusF = textAdjust("Free", 340);//30//35
       StatusF.setLocation(220,340);
        add(StatusF);
       
//        String[] options = {"Critical", "Urgent", "Stable", "Non Urgent"};
//        condition = new JComboBox(options);
//        condition.setBackground(Color.WHITE);
//        condition.setBounds(200, 340, 160, 30);
//        condition.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        add(condition);

        FeesF = createPaddedTextField(400);
        add(FeesF);

    }

    public void btn() {
        submit = new JButton("Add");
        submit.setBounds(250, 470, 140, 40);
//        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(430, 470, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);
    }

    public void WritePfile() {
        String name = NameF.getText();// helps to get the text entered inside the name field
        String id = idF.getText();
        String Contact = ContactF.getText();
        String Address = AddressF.getText();
        String Fees = FeesF.getText();
        try {
            String data = id + ";" + name + ";" + Address + ";" + Contact + ";" + Fees + ";" + "Free"+"\n";
            FileWriter fw = new FileWriter("./src/files/doctor.txt", true);
            fw.write(data);
            fw.close();

            JOptionPane.showMessageDialog(null, "Doctor Enrolled Successfully");

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public Boolean validate(String id, String contact) {
        try {
//        FileReader fr= new FileReader("./src/files/patient.txt");
            File file = new File("./src/files/doctor.txt");
            Scanner fr = new Scanner(file);
            while (fr.hasNextLine()) {
                String data = fr.nextLine();
                if (data.length() > 5) {
                    String[] dataarr = data.split(";");
                    if (dataarr[0].equals(id)) {
                        JOptionPane.showMessageDialog(null, "ID cannot be same");
                        return false;
                    }
                }
            }
            if(contact.length()!=10)
            {
                JOptionPane.showMessageDialog(null, "Please Enter a valid contact");
                return false;
            }
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            Boolean correct = validate(idF.getText(), ContactF.getText());
           if(correct)
           {
                WritePfile();
           }
        } else {
            setVisible(false);
            HospitalManagementSystem.main(new String[]{});

        }
    }

    public static void main(String[] args) {
        DoctorUI p = new DoctorUI();
        p.Heading();
        p.addHeadingBorder();
        p.text();
        p.textFields();
        p.btn();

    }
}
