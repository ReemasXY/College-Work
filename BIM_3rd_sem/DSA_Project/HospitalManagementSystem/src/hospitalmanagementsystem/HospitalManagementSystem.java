package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HospitalManagementSystem extends JFrame implements ActionListener {

    public static PatientList plist = new PatientList();
     JButton addPatient,addDoctors,Viewall,Appointment,Discharge1,Search1;
    public HospitalManagementSystem() {
        getContentPane().setBackground(Color.white);// getContentPane selects the whole frame
        setBounds(250, 100, 950, 550);
        setVisible(true);
        setLayout(null);

    }

    public void Heading() {
        JLabel heading = new JLabel("Hospital Management System");
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

    public void sidepic()
    {
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/doctor.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 450, 450);
        add(image);
    }
    
      public JButton adjustment(String text,int Xaxis, int Yaxis) {
        JButton j = new JButton(text);
        j.setBounds(Xaxis, Yaxis, 180, 40);
        j.setBackground(Color.BLACK);
        j.setForeground(Color.white);
        j.setCursor(new Cursor(Cursor.HAND_CURSOR));
        j.setFont(new Font("Tahoma", Font.PLAIN, 16));
        return j;
    }
      
    public void buttons() {

        addPatient = adjustment("Add Patient", 60,125);//40 //30
        addPatient.addActionListener(this);
        add(addPatient);
        
         addDoctors = adjustment("Add Doctors", 300,125);//40 //30
        addDoctors.addActionListener(this);
        add(addDoctors);
        
          Viewall = adjustment("View All", 60,205);//40 //30
        Viewall.addActionListener(this);
        add(Viewall);
        
        Search1 = adjustment("Search ", 300,205);//40 //30
        Search1.addActionListener(this);
        add(Search1);
        
             Appointment = adjustment("Appointment ", 60,285);//40 //30
        Appointment.addActionListener(this);
        add(Appointment);   
        
          Discharge1 = adjustment("Discharge ", 300,285);//40 //30
        Discharge1.addActionListener(this);
        add(Discharge1);   
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         setVisible(false);
 if(e.getSource()==addPatient)
{
       PatientUI.main(new String[]{});
}else if(e.getSource()==addDoctors)
{
           DoctorUI.main(new String[]{});
}
else if(e.getSource()== Viewall)
    {
         ViewAll.main(new String[]{});
    }
else if(e.getSource()==Appointment)
{
    AppointmentUI.main(new String[]{});
}
else if(e.getSource()==Discharge1)
{
    Discharge.main(new String[]{});
}
else if(e.getSource()==Search1)
{
    Search.main(new String[]{});
}

    }

    public static void main(String[] args) {
        HospitalManagementSystem h = new HospitalManagementSystem();
        h.Heading();
        h.addHeadingBorder(); 
        h.sidepic();// Add this after Heading
        h.buttons();
//        Patient p1=new Patient("sam","1","1234","M",1200);
//          Patient p2= new Patient("mini","2","1234","F",1200);  
//          Patient p3= new Patient("raj","3","1234","M",1200);
//          plist.Insert(p1);
//            plist.Insert(p2);
//              plist.Insert(p3);
//              plist.traverse();

    }

}
