package hotelmanagementsystem;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;


class Employeeinformation extends JFrame implements ActionListener {
    JButton cancel;
    // Custom header renderer class to add right and bottom borders and padding
    static class CustomHeaderRenderer extends DefaultTableCellRenderer {
        public CustomHeaderRenderer() {
            setHorizontalAlignment(JLabel.CENTER);  // Align text to the center
            
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    // Get the default renderer component
    Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    
    // Increase font size and apply bold
    Font currentFont = comp.getFont();
    Font newFont = currentFont.deriveFont(currentFont.getSize() + 0.49f).deriveFont(Font.BOLD); // Increase font size by 4 points and make it bold
    comp.setFont(newFont);
    
    // Apply right and bottom borders
    setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.GRAY));  // 2px border on right and bottom
    
    // Add padding (top, left, bottom) around the content, but no padding on the right side
    setBorder(BorderFactory.createCompoundBorder(
        getBorder(), // Right and bottom borders applied here
        BorderFactory.createEmptyBorder(10, 0, 10, 0) // Padding: top=10, left=20, bottom=10, no padding on the right
    ));
    
    return comp;
}

    }

    JTable table; // helps to add table in the frame

    Employeeinformation() {
        getContentPane().setBackground(Color.white);
        setBounds(250, 170, 950, 500);
        setVisible(true);
        setLayout(null);



      
    }

    public void table1() {
        JLabel heading = new JLabel("All Employees");
        heading.setBounds(400, 15, 300, 30);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(heading);

        // Initialize JTable and DefaultTableModel
        table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        JScrollPane scroll = new JScrollPane(table);

        // Set the bounds for the JScrollPane, not the table
        scroll.setBounds(0, 70, 950, 300);
        // Set background color of the viewport (which contains the textArea)
        scroll.getViewport().setBackground(Color.WHITE);

        // Remove the border of the JScrollPane (works across Look and Feels)
        scroll.setBorder(BorderFactory.createEmptyBorder());
        // Create a border with only a top border (2 pixels thick, black color)
        Border topBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY);

        // Apply the border to the JScrollPane
        scroll.setBorder(topBorder);

        table.setRowHeight(30);

        // Add the JScrollPane to the JFrame
        add(scroll);

        try {
            Conn c = new Conn();
            String query = "SELECT * FROM employee";
            ResultSet rs = c.s.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            String[] columnNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = rsmd.getColumnName(i + 1);
                
            }
            String Names[]={"Employee ID", "Name","Gender","Job","Salary","Phone"};
            model.setColumnIdentifiers(Names);

            while (rs.next()) {
                String RowData[] = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    RowData[i] = rs.getString(columnNames[i]);
                }
                model.addRow(RowData);
            }

            // Get the table's column model
            TableColumnModel columnModel = table.getColumnModel();

            // Set custom header renderer with right and bottom borders and padding
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                TableColumn column = columnModel.getColumn(i);
                column.setHeaderRenderer(new CustomHeaderRenderer());
            }

            // Center-align the data in all columns
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        setHorizontalAlignment(SwingConstants.CENTER); // Set center alignment
                        return c;
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public void btn()
{
         cancel = new JButton("Back");
        cancel.setBounds(400, 400, 140, 40);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addActionListener(this);
        add(cancel);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Reception.main(new String[]{});
    }
}

public class EmployeeInfo {
    public static void main(String[] args) {
        Employeeinformation r = new Employeeinformation();
        r.table1(); // Call table1() in main as well
        r.btn();
    }
}
