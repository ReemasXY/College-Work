package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AppointmentUI extends JFrame implements ActionListener {

    JLabel idF, NameF, ContactF, ConditionF, GenderF, NameDF, ContactDF, FeesDF;
    JComboBox idDF;
    String pid, did;
    PriorityQueue p = new PriorityQueue();
    String Pdata[][], Ddata[][];
    JButton submit, cancel;
    Boolean disabled=false;

    AppointmentUI() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whole frame
        setBounds(250, 100, 950, 600);
        setVisible(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/appointment.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(620, 50, 300, 350);
        image.setBackground(Color.WHITE);
        add(image);

        PrepareData("Patient");
//          for (String[] row : Pdata) {
//            System.out.println(row[0] + " " + row[1]);
//        }

        for (String[] row : Pdata) {
            if(row[6].equals("No"))
            {
                int priority;
            if (row[4].equals("Critical")) {
                priority = 4;
            } else if (row[4].equals("Urgent")) {
                priority = 3;
            } else if (row[4].equals("Stable")) {
                priority = 2;
            } else {
                priority = 1;
            }
            p.Enqueue(row, priority);
            }

        }
//        p.traverse();
        String[] dequeueData = p.Dequeue();
//        pid = dequeueData[0];
//        PDetails(dequeueData[0], dequeueData[1], dequeueData[2], dequeueData[3], dequeueData[4]);
if(dequeueData!=null){
             
            pid = dequeueData[0];
            PDetails(dequeueData[0], dequeueData[1], dequeueData[2], dequeueData[3], dequeueData[4]);
            disabled=false;
         }
  else{
              PDetails("", "", "", "", "");
            disabled=true;
         }
    }

    public void Heading() {
        JLabel heading = new JLabel("Appointment Form");
        heading.setBounds(340, 0, 600, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
//         heading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); 
        add(heading);
    }

    public JLabel textAdjust(String text, int Yaxis) {
        JLabel j = new JLabel(text);
        j.setBounds(40, Yaxis, 120, 30);
        j.setFont(new Font("Tahoma", Font.BOLD, 15));
        return j;
    }

    public JLabel textAdjust1(String text, int Yaxis) {
        JLabel j = new JLabel(text);
        j.setBounds(130, Yaxis, 190, 30);
        j.setFont(new Font("Tahoma", Font.BOLD, 15));
        return j;
    }

    public JLabel textAdjust2(String text, int Yaxis) {
        JLabel j = new JLabel(text);
        j.setBounds(350, Yaxis, 190, 30);
        j.setFont(new Font("Tahoma", Font.BOLD, 15));
        return j;
    }

    public JLabel textAdjust3(String text, int Yaxis) {
        JLabel j = new JLabel(text);
        j.setBounds(460, Yaxis, 190, 30);
        j.setFont(new Font("Tahoma", Font.BOLD, 15));
        return j;
    }

    public void text() {

        //id text
        JLabel id = textAdjust("Patient Details", 100);
        add(id);

        //Name text
        JLabel Name = textAdjust("Patient Id", 160);//30//35
        add(Name);

        JLabel Address = textAdjust("Name", 225);//30//35
        add(Address);

        JLabel Contact = textAdjust("Contact", 290);//30//35
        Contact.setSize(80, 30);
        add(Contact);

        JLabel Fees = textAdjust("Gender", 355);//30//35
        add(Fees);

        JLabel conditon = textAdjust("Condition", 415);//30//35
        add(conditon);
        //Doctor 

        //id text
        JLabel doc = textAdjust2("Doctor Details", 100);
        add(doc);

        //Name text
        JLabel id1 = textAdjust2("Doctor Id", 160);//30//35
        add(id1);

        JLabel Name1 = textAdjust2("Doctor Name", 225);//30//35
        add(Name1);

        JLabel Contact1 = textAdjust2("Contact", 290);//30//35
        add(Contact1);

        JLabel Fees1 = textAdjust2("Fees", 355);//30//35
        add(Fees1);
    }

    public void PDetails(String id, String Name, String Contact, String gender, String Condition) {
        if (idF != null) {
            remove(idF);
            remove(NameF);
            remove(ContactF);
            remove(GenderF);
            remove(ConditionF);
        }
        idF = textAdjust1(":  " + id, 160);//30//35
        add(idF);

        NameF = textAdjust1(":  " + Name, 225);//30//35
        add(NameF);

        ContactF = textAdjust1(":  " + Contact, 290);//30//35Contact.setSize(80, 30);
        add(ContactF);

        GenderF = textAdjust1(":  " + gender, 355);//30//35
        add(GenderF);

        ConditionF = textAdjust1(":  " + Condition, 415);//30//35
        add(ConditionF);
        revalidate();
        repaint();
    }

    public void DocDetails() {
        int i = 0, j = 0;
        PrepareData("Doctor");
        for (String[] row : Ddata) {
            if (row[5].equals("Free")) {
                i++;
            }
        }
        String[] options = new String[i];
        for (String[] row : Ddata) {
            if (row[5].equals("Free")) {
                options[j] = row[0];
                j++;
            }
        }
if(idDF!=null){
    remove(idDF);
}
        idDF = new JComboBox(options);
        idDF.setBackground(Color.WHITE);
        idDF.setBounds(460, 160, 160, 30);
        idDF.setCursor(new Cursor(Cursor.HAND_CURSOR));
        idDF.addActionListener(e -> {
            String selectedItem = (String) idDF.getSelectedItem();
            for (String[] row : Ddata) {
                if (row[0].equals(selectedItem)) {
                    DocAddDetails(row[1], row[3], row[4]);
                    System.out.println(row[1]);
                    System.out.println(row[3]);
                    System.out.println(row[4]);
                }
            }
        });
       if( idDF.getSelectedItem()== null)
       {
            DocAddDetails("","","");
            submit.setEnabled(false);
       }
       else{
            for (String[] row : Ddata) {
            if (row[0].equals((String) idDF.getSelectedItem())) {
                DocAddDetails(row[1], row[3], row[4]);
            }
        }
       }
        add(idDF);
          revalidate();
        repaint();

    }

    public void DocAddDetails(String name, String contact, String fees) {
        if (NameDF != null && FeesDF != null && ContactDF != null) {
            remove(FeesDF);
            remove(NameDF);
            remove(ContactDF);
        }

        NameDF = textAdjust3(":  " + name, 225);
        add(NameDF);

        ContactDF = textAdjust3(":  " + contact, 290);
        add(ContactDF);

        FeesDF = textAdjust3(":  " + fees, 355);
        add(FeesDF);

        revalidate();
        repaint();
    }

    public void addHeadingBorder() {
        JPanel line = new JPanel();
        line.setBackground(Color.GRAY);
        line.setBounds(0, 40, getWidth(), 4); // y = 35 just below the heading
        add(line);
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

    public void btn() {
        submit = new JButton("Appoint");
        submit.setBounds(260, 490, 140, 40);
//        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if(disabled)
        {
               submit.setEnabled(false);
        }
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 490, 140, 40);
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
            for (int i = 0; i < Pdata.length; i++) {
                for (int j = 0; j < Pdata[i].length; j++) {

                    if (pid.equals(Pdata[i][0])) {
                        Pdata[i][6] = "Yes"; // Update "No" to "Yes"
                        Pdata[i][7] = (String) idDF.getSelectedItem();
                    }
                }
            }

            for (String[] row : Pdata) {
                System.out.println(row[0] + " " + row[1] + " " + row[6] + " " + row[7]);
            }
            for (String[] row : Pdata) {

//                if (row[5].equals("Yes")) {
//                    data = row[0] + ";" + row[1] + ";" + row[2] + ";" + row[3] + ";" + row[4] + ";" + row[5] + ";" + "Yes" + ";" + row[7] + "\n";
//                } else {
//                    if (pid.equals(row[0])) {
//                        row[6] = "Yes";
//                        row[7] = (String) idDF.getSelectedItem();
//
//                    } else {
//                        row[6] = "No";
//                        row[7] = "Null";
//                    }
//                    data = row[0] + ";" + row[1] + ";" + row[2] + ";" + row[3] + ";" + row[4] + ";" + row[5] + ";" + row[6] + ";" + row[7] + "\n";
//                }
                data = row[0] + ";" + row[1] + ";" + row[2] + ";" + row[3] + ";" + row[4] + ";" + row[5] + ";" + row[6] + ";" + row[7] + "\n";
                fw.write(data);
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
            did = (String) idDF.getSelectedItem();
            String data;
               for (int i = 0; i < Ddata.length; i++) {
                for (int j = 0; j < Ddata[i].length; j++) {

                    if (did.equals(Ddata[i][0])) {
                        Ddata[i][5] = "Appointed"; 
                       
                    }
                }
            }
            for (String[] row : Ddata) {

//                if (row[5].equals("Appointed")) {
//                    data = row[0] + ";" + row[1] + ";" + row[2] + ";" + row[3] + ";" + row[4] + ";" + row[5] + "\n";
//                } else {
//                    data = row[0] + ";" + row[1] + ";" + row[2] + ";" + row[3] + ";" + row[4] + ";" + ((did.equals(row[0])) ? "Appointed" : "Free") + "\n";
//                }
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

            UpdatePatientFile();
            UpdateDoctorFile();
            JOptionPane.showMessageDialog(null, "Appointment Successful");
                String[] dequeueData = p.Dequeue();
         if(dequeueData!=null){
             
            pid = dequeueData[0];
            PDetails(dequeueData[0], dequeueData[1], dequeueData[2], dequeueData[3], dequeueData[4]);
         }
         else{
              PDetails("", "", "", "", "");
            submit.setEnabled(false);
         }
         DocDetails();
        } else {
            setVisible(false);
            HospitalManagementSystem.main(new String[]{});

        }
    }

    public static void main(String[] args) {
        AppointmentUI a = new AppointmentUI();
        a.Heading();
        a.addHeadingBorder();
        a.text();
        a.btn();
        a.DocDetails();
        
    }
}
