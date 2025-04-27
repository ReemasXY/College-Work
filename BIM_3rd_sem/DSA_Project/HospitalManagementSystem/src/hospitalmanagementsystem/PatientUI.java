package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class PatientUI extends JFrame implements ActionListener {

    JTextField idF, NameF, ContactF, DepositF;
    JComboBox condition;
    JRadioButton male, female;
    JButton submit, cancel;

    PatientUI() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whole frame
        setBounds(250, 100, 890, 570);
        setVisible(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/patient.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390, 70, 500, 350);
        add(image);
    }

    public void Heading() {
        JLabel heading = new JLabel("New Patient Form");
        heading.setBounds(350, 0, 600, 30);
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
        textField.setBounds(200, Yaxis, 160, 30);
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(), // Preserve original border
                BorderFactory.createEmptyBorder(0, 10, 0, 10) // Add padding: top, left, bottom, right
        ));
        return textField;
    }

    public JLabel textAdjust(String text, int Yaxis) {
        JLabel j = new JLabel(text);
        j.setBounds(60, Yaxis, 120, 30);
        j.setFont(new Font("Tahoma", Font.BOLD, 15));
        return j;
    }

    public void text() {

        //id text
        JLabel id = textAdjust("Patient ID", 80);
        add(id);

        //Name text
        JLabel Name = textAdjust("Name", 145);//30//35
        add(Name);

        JLabel Contact = textAdjust("Contact", 210);//30//35
        add(Contact);

        JLabel Gender = textAdjust("Gender ", 275);//30//35
        Gender.setSize(80, 30);
        add(Gender);

        JLabel Condition = textAdjust("Condition", 340);//30//35
        add(Condition);

        JLabel Deposit = textAdjust("Deposit", 400);//30//35
        add(Deposit);

    }

    public void textFields() {
        idF = createPaddedTextField(80);
        add(idF);

        NameF = createPaddedTextField(145);
        add(NameF);

        ContactF = createPaddedTextField(210);
        add(ContactF);

        //Gender Radio
        male = new JRadioButton("Male");
        male.setBounds(200, 275, 70, 30);
        male.setFont(new Font("Tahoma", Font.PLAIN, 14));
        male.setCursor(new Cursor(Cursor.HAND_CURSOR));
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Tahoma", Font.PLAIN, 14));
        female.setBounds(275, 275, 70, 30);
        female.setBackground(Color.white);
        female.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(female);

        ButtonGroup bg = new ButtonGroup();//This helps to select either male or female not both at a time
        bg.add(male);
        bg.add(female);
        male.setSelected(true);

        String[] options = {"Critical", "Urgent", "Stable", "Non Urgent"};
        condition = new JComboBox(options);
        condition.setBackground(Color.WHITE);
        condition.setBounds(200, 340, 160, 30);
        condition.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(condition);

        DepositF = createPaddedTextField(400);
        add(DepositF);

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
        String Deposit = DepositF.getText();
        String gender = null;

        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String conditionf = (String) condition.getSelectedItem();
        try {
            String data = id + ";" + name + ";" + Contact + ";" + gender + ";" + conditionf + ";" + Deposit+";" +"No"+";"+"NULL"+ "\n";
            FileWriter fw = new FileWriter("./src/files/patient.txt", true);
            fw.write(data);
            fw.close();

            JOptionPane.showMessageDialog(null, "Patient Added Successfully");

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public Boolean validate(String id, String contact) {
        try {
//        FileReader fr= new FileReader("./src/files/patient.txt");
            File file = new File("./src/files/patient.txt");
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
            fr.close();
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
        PatientUI p = new PatientUI();
        p.Heading();
        p.addHeadingBorder();
        p.text();
        p.textFields();
        p.btn();

    }
}
