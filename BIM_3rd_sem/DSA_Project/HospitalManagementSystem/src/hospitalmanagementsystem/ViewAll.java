package hospitalmanagementsystem;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.border.EmptyBorder;

public class ViewAll extends JFrame implements ActionListener {

    JComboBox Sort, View;
    JLabel showhead = new JLabel();
    JTable table;
JButton cancel;
    String data[][];
    JScrollPane scrollPane = new JScrollPane();

    public ViewAll() {
        getContentPane().setBackground(Color.white);
        setBounds(250, 100, 950, 550);
        setVisible(true);
        setLayout(null);

        //Reading patients data from the file and putting it into a doubly list
        PrepareData("Patient");
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
            if (patient) {
                data = plist.traverseandconvert();

            } else {
                data = dlist.traverseandconvert();

            }
            showTable(data, patient,"");

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void Heading() {
        JLabel heading = new JLabel("View All Information");
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

    public void viewAndSortText() {

        JLabel ViewT = new JLabel("View Information of: ");
        ViewT.setBounds(60, 80, 180, 30);
        ViewT.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(ViewT);

        // Room Field
        String arr[] = {
            "Patient",
            "Doctor"
        };
        View = new JComboBox(arr);
        View.setBounds(220, 80, 130, 30);
        View.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBorder(new EmptyBorder(0, 5, 0, 0)); // Padding inside each item
                return label;
            }
        });
        View.setBackground(Color.WHITE);
        View.setCursor(new Cursor(Cursor.HAND_CURSOR));
        View.addActionListener(e -> {
            String selectedItem = (String) View.getSelectedItem();
            System.out.println(selectedItem);
            PrepareData(selectedItem);
        });
        add(View);

        JLabel SortT = new JLabel("Sort(Names):");
        SortT.setBounds(580, 80, 120, 30);
        SortT.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(SortT);

        String arr1[] = {
            "Ascending",
            "Descending"
        };
        Sort = new JComboBox(arr1);
        Sort.setBounds(695, 80, 150, 30);
        Sort.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBorder(new EmptyBorder(0, 5, 0, 0)); // Padding inside each item
                return label;
            }
        });
        Sort.setBackground(Color.WHITE);
        Sort.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Sort.addActionListener(e -> {
            String selectedItem = (String) Sort.getSelectedItem();
           
//            String [][]newdata = sortedReadFile((String)View.getSelectedItem());
         QuickSort q=  new QuickSort();
         String [][]sortedData= q.sort(data,selectedItem);
           for (String[] row : sortedData) {
            System.out.println(row[0] + " " + row[1]);
        }
         if(View.getSelectedItem().equals("Patient"))
         {
             showTable(sortedData,true,selectedItem);
         }
         else{
             showTable(sortedData,false,selectedItem);
         }
        });
        add(Sort);
    }

    public void SearchHeading(String value) {
        remove(showhead);
        showhead = new JLabel(value);
        showhead.setBounds(330, 150, 480, 30);
        showhead.setForeground(Color.BLACK);
        showhead.setFont(new Font("Tahoma", Font.BOLD, 19));
        showhead.setVisible(true);
        add(showhead);
    }

    public void showTable(String[][] data, Boolean patient,String order) {
        String[] columns;
        if (patient) {
            columns = new String[]{"ID", "Name", "Contact", "Gender", "Condition", "Deposit"};
          if(order.equals(""))
          {
                SearchHeading("Information Of All Patients");
          }
          else{
              if(order.equalsIgnoreCase("Ascending"))
              {
                    SearchHeading("Information Of All Patients (Ascending Order)");
              }
              else{
                    SearchHeading("Information Of All Patients (Descending Order)");
              }
               showhead.setBounds(250, 150, 480, 30);
            
          }
        } else {
            columns = new String[]{"ID", "Name", "Address", "Contact", "Fees", "Status"};
           if(order.equals(""))
          {
                SearchHeading("Information Of All Doctor");
          }
          else{
              if(order.equalsIgnoreCase("Ascending"))
              {
                    SearchHeading("Information Of All Doctors (Ascending Order)");
              }
              else{
                    SearchHeading("Information Of All Doctors (Descending Order)");
              }
                showhead.setBounds(250, 150, 480, 30);
               
          }
        }
        remove(scrollPane);
        table = new JTable(data, columns);
// Set row height
        table.setRowHeight(35);
        JTableHeader header1 = table.getTableHeader();
        header1.setPreferredSize(new Dimension(header1.getWidth(), 40)); // header height = 40px
// Custom cell renderer with center alignment + padding
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBorder(new EmptyBorder(5, 10, 5, 10)); // top, left, bottom, right padding

                return label;
            }
        };

// Apply the renderer to all columns
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

// Header styling
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setFont(new Font("Tahoma", Font.BOLD, 12));

// Height calculation
        int rowHeight = table.getRowHeight();
        int totalRowHeight = rowHeight * data.length;
        int headerHeight = header.getPreferredSize().height;
        int totalHeight = totalRowHeight + headerHeight;

// ScrollPane setup
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 210, 830, Math.min(totalHeight + 3, 250));
        scrollPane.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.GRAY));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        repaint();
        revalidate();
        add(scrollPane);

    }
      public void btn() {
        cancel = new JButton("Back");
        cancel.setBounds(380, 450, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);

       
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
            HospitalManagementSystem.main(new String[]{});
        }
    }

    public static void main(String[] args) {
        ViewAll v = new ViewAll();
        v.Heading();
        v.addHeadingBorder();
        v.viewAndSortText();
        v.SearchHeading("Information of all Patients");
        v.btn();
    }
}
