package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.time.*;
import java.util.Scanner;

public class Discharge extends JFrame implements ActionListener {

    int pending1;
    JLabel nam, depo, checkdate, day;
    JLabel DepositF, NameF, ContactF, PendingF, DocFeesF;
    JComboBox pid;
    JButton submit, cancel, check;

    String Pdata[][], Ddata[][], docId;
//     int pbill;

    Discharge() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whoe frame
        setBounds(250, 100, 890, 570);
        setVisible(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/discharge.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 330, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 80, 400, 330);
        add(image);
        PrepareData("Patient");
        PrepareData("Doctor");

    }

    public void PrepareData(String selection) {
        try {
//        FileReader fr= new FileReader("./src/files/patient.txt");
            PatientList plist = new PatientList();
            DoctorList dlist = new DoctorList();
            File file;
            boolean patient = true;
            if (selection.equals("Patient")) {
                file = new File("./src/files/patient.txt");
            } else {
                file = new File("./src/files/doctor.txt");
                patient = false;
            }
            Scanner fr = new Scanner(file);
            while (fr.hasNextLine()) {
                String data1 = fr.nextLine();
                if (data1.length() > 5) {
                    String[] dataarr = data1.split(";");
                    if (patient) {

                        plist.Insert(dataarr);
                    } else {
                        dlist.Insert(dataarr);
                    }
                }
            }
            fr.close();
            if (patient) {
                Pdata = plist.traverseandconvert();

            } else {
                Ddata = dlist.traverseandconvert();

            }

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void addHeadingBorder() {
        JPanel line = new JPanel();
        line.setBackground(Color.GRAY);
        line.setBounds(0, 40, getWidth(), 4); // y = 35 just below the heading
        add(line);
    }

    public void Heading() {
        JLabel heading = new JLabel("Discharge Patient");
        heading.setBounds(340, 0, 600, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
//         heading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); 
        add(heading);
    }

    public void text() {

        //Roomno text
        JLabel Roomno = new JLabel("Patient ID");
        Roomno.setBounds(60, 80 + 15, 120, 30);
        Roomno.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Roomno);

        //RoomAvailable text
        JLabel Name = new JLabel("Patient Name");
        Name.setBounds(60, 140 + 15, 120, 30);
        Name.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Name);

        //Room Cleaned text
        JLabel Check = new JLabel("Contact");
        Check.setBounds(60, 200 + 15, 150, 30);
        Check.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Check);

        //Price text
        JLabel Deposit = new JLabel("Deposit ");
        Deposit.setBounds(60, 260 + 15, 120, 30);
        Deposit.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Deposit);

        //BedType text
        JLabel Days = new JLabel("Doctors Fees");
        Days.setBounds(60, 320 + 15, 120, 30);
        Days.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Days);

        JLabel Days1 = new JLabel("Pending Bill");
        Days1.setBounds(60, 395, 120, 30);
        Days1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(Days1);

    }

    public void textInputs() {
        PrepareData("Patient");
        int i = 0, j = 0;
        for (String[] row : Pdata) {
            if (row[6].equals("Yes")) {
                i++;
            }
        }
        String[] options = new String[i];
        for (String[] row : Pdata) {
            if (row[6].equals("Yes")) {
                options[j] = row[0];
                j++;
            }
        }
        if (pid != null) {
            remove(pid);
        }

        pid = new JComboBox(options);
        pid.setBackground(Color.WHITE);
        pid.setBounds(180, 80 + 15, 160, 30);
        pid.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pid.setSelectedItem(null); // Set null as the default selected item
        if (pid.getSelectedItem() == null) {
            AddDetails("", "", "", "");
            submit.setEnabled(false);
        }
        pid.addActionListener(e -> {
            String selectedItem = (String) pid.getSelectedItem();
            for (String[] row : Pdata) {
                if (row[0].equals(selectedItem)) {
                    AddDetails(row[1], row[2], row[5], row[7]);
                    docId = row[7];
                }
            }
            submit.setEnabled(true);
        });

        add(pid);
        revalidate();
        repaint();

    }

    public JLabel textAdjust3(String text, int Yaxis) {
        JLabel j = new JLabel(text);
        j.setBounds(180, Yaxis, 190, 30);
        j.setFont(new Font("Tahoma", Font.BOLD, 15));
        return j;
    }

    public void AddDetails(String name, String contact, String Deposit, String Did) {
        if (NameF != null && ContactF != null && DepositF != null) {
            remove(NameF);
            remove(ContactF);
            remove(DepositF);
            remove(PendingF);
            remove(DocFeesF);
        }

        NameF = textAdjust3(":  " + name, 140 + 15);
        add(NameF);

        ContactF = textAdjust3(":  " + contact, 200 + 15);
        add(ContactF);

        DepositF = textAdjust3(":  " + Deposit, 260 + 15);
        add(DepositF);

        String Fees = "";
        for (String[] row : Ddata) {
            if (row[0].equals(Did)) {
                Fees = row[4];
            }
        }
        DocFeesF = textAdjust3(":  " + Fees, 335);
        add(DocFeesF);
        if (Did.equals("")) {
            String pending = "";
            PendingF = textAdjust3(":  " + pending, 395);
        } else {
            pending1 = Integer.parseInt(Fees) - Integer.parseInt(Deposit);
            PendingF = textAdjust3(":  " + pending1, 395);
        }

        add(PendingF);

        revalidate();
        repaint();
    }

    public void btn() {
        submit = new JButton("Discharge");
        submit.setBounds(250, 470, 140, 40);
//        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(430, 470, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);

    }

    public void UpdatePatientFile() {
        try {
            File file = new File("./src/files/patient.txt");
            // Delete file if it exists
            String data;
            if (file.exists()) {
                FileWriter fw = new FileWriter(file);
                fw.write("");
                fw.close();
            }
            FileWriter fw = new FileWriter(file, true);
            for (String[] row : Pdata) {
                if (!(row[0].equals((String) pid.getSelectedItem()))) {
                    data = row[0] + ";" + row[1] + ";" + row[2] + ";" + row[3] + ";" + row[4] + ";" + row[5] + ";" + row[6] + ";" + row[7] + "\n";
                    fw.write(data);
                }
            }
            fw.close();

        } catch (IOException e1) {
            System.out.println(e1);
            e1.printStackTrace();
        }
    }

    public void UpdateDoctorFile() {
        try {
            File file = new File("./src/files/doctor.txt");
            // Delete file if it exists
            if (file.exists()) {
                FileWriter fw = new FileWriter(file);
                fw.write("");
                fw.close();
            }
            FileWriter fw = new FileWriter(file, true);

            String data;
            for (int i = 0; i < Ddata.length; i++) {
                for (int j = 0; j < Ddata[i].length; j++) {

                    if (docId.equals(Ddata[i][0])) {
                        Ddata[i][5] = "Free";

                    }
                }
            }
            for (String[] row : Ddata) {
                data = row[0] + ";" + row[1] + ";" + row[2] + ";" + row[3] + ";" + row[4] + ";" + row[5] + "\n";
                fw.write(data);
            }
            fw.close();
        } catch (IOException e1) {
            System.out.println(e1);
            e1.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            if (pending1 != 0) {
                int response = JOptionPane.showConfirmDialog(
                        null, // Parent component (null for default)
                        "The bill is pending. Are you sure to dicharge the patient?", // Message
                        "Confirmation", // Title
                        JOptionPane.YES_NO_OPTION, // Option type (Yes/No buttons)
                        JOptionPane.QUESTION_MESSAGE // Message type (Question icon)
                );
                if (response == JOptionPane.YES_OPTION) {
                    UpdatePatientFile();
                    UpdateDoctorFile();
                    textInputs();
                    JOptionPane.showMessageDialog(null, "Patient Discharged Successfully");
                    ViewAll.main(new String[]{});
                } else if (response == JOptionPane.NO_OPTION) {
                    System.out.println("Check-out Canceled");
                } 
            }
            else {
                    UpdatePatientFile();
                    UpdateDoctorFile();
                    textInputs();
                    JOptionPane.showMessageDialog(null, "Patient Discharged Successfully");
                    ViewAll.main(new String[]{});
                }

        } else {
            setVisible(false);
            HospitalManagementSystem.main(new String[]{});

        }

    }

    public static void main(String[] args) {
        Discharge d = new Discharge();
        d.addHeadingBorder();
        d.Heading();
        d.btn();
        d.text();
        d.textInputs();

    }
}
