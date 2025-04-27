package hospitalmanagementsystem;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.border.EmptyBorder;

public class Search extends JFrame implements ActionListener {

    JTextField SearchById;
    String data[][];
    JComboBox View;
    JLabel showhead = new JLabel();
    JTable table;
    JButton cancel, search;
    JScrollPane scrollPane = new JScrollPane();

    public Search() {
        getContentPane().setBackground(Color.white);
        setBounds(250, 100, 950, 550);
  
        setVisible(true);
        setLayout(null);
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
            showTable(data, patient, "");

        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void Heading() {
        JLabel heading = new JLabel("Search  Information");
        heading.setBounds(350, 0, 600, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
//         heading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); 
        add(heading);
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
    //for left padding in text field

    public static JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(), // Preserve original border
                BorderFactory.createEmptyBorder(0, 10, 0, 10) // Add padding: top, left, bottom, right
        ));
        return textField;
    }

    public void addHeadingBorder() {
        JPanel line = new JPanel();
        line.setBackground(Color.GRAY);
        line.setBounds(0, 40, getWidth(), 4); // y = 35 just below the heading
        add(line);
    }

    public void SearchField() {
        //Roomno text
//    

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

        JLabel Search = new JLabel("Search By Id: ");
        Search.setBounds(580, 80, 120, 30);
        Search.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Search);

        SearchById = createPaddedTextField();
        SearchById.setBounds(695, 80, 150, 30);
        add(SearchById);
    }

    public void showTable(String[][] data, Boolean patient, String order) {
        String[] columns;
        if (patient) {
            columns = new String[]{"ID", "Name", "Contact", "Gender", "Condition", "Deposit"};
            if (order.equals("")) {
                SearchHeading("Information Of All Patients");
            } else {
                SearchHeading("Infomation of Patient ID: " + order);
                showhead.setBounds(310, 150, 480, 30);

            }
        } else {
            columns = new String[]{"ID", "Name", "Address", "Contact", "Fees", "Status"};
            if (order.equals("")) {
                SearchHeading("Information Of All Doctor");
            } else {
                SearchHeading("Infomation of Doctor ID: " + order);
                showhead.setBounds(310, 150, 480, 30);

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
        cancel.setBounds(480, 450, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);

        search = new JButton("Search");
        search.setBounds(290, 450, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        search.setBackground(Color.BLACK);
        search.setForeground(Color.white);
        search.setCursor(new Cursor(Cursor.HAND_CURSOR));
        search.addActionListener(this);
        add(search);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
            HospitalManagementSystem.main(new String[]{});
        } else if (e.getSource() == search) {
            String key = SearchById.getText();
            //Bubble Sort
            for (int i = 0; i < data.length - 1; i++) {
                for (int j = 0; j < data.length - 1 - i; j++) {
                    if (data[j][0].compareToIgnoreCase(data[j + 1][0]) > 0) {
                        String[] temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;
                    }
                }
            }
            for (String[] row : data) {
                System.out.println(row[0] + " " + row[1]);
            }
            int index = new BinarySearch().search(data, 0, data.length - 1, key);

            if (index == -1) {
                remove(scrollPane);
         
                repaint();
                revalidate();
                SearchHeading("No Result Found");
                showhead.setBounds(350, 150, 480, 30);
            } else {
                String[][] twod = {data[index]};
                if (View.getSelectedItem().equals("Patient")) {
                    showTable(twod, true, key);
                } else {
                    showTable(twod, false, key);
                }
            }

        }
    }

    public static void main(String[] args) {
        Search s = new Search();
        s.Heading();
        s.addHeadingBorder();
        s.SearchField();
        s.btn();
    }
}
