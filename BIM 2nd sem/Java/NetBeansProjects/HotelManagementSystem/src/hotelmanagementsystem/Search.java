package hotelmanagementsystem;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import net.proteanit.sql.*;

class RoomSearch extends JFrame implements ActionListener {

    JButton search, cancel;
    JLabel showhead;
    JTextField roomField;
    JComboBox roomavailable;
    JTable table;
    JScrollPane scroll;
    DefaultTableModel model;

    RoomSearch() {
        getContentPane().setBackground(Color.white);
        setBounds(250, 170, 950, 550);
        setVisible(true);
        setLayout(null);

        JLabel heading = new JLabel("Search Room");
        heading.setBounds(380, 15, 300, 30);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.BOLD, 19));
        add(heading);
    }

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

    public void tableadjust() {
        // Set the bounds for the JScrollPane, not the table
        scroll.setBounds(0, 200, 950, 200);
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
    }

    public void showTable(String queryExecute) {

        // Initialize JTable and DefaultTableModel
        table = new JTable();
        model = (DefaultTableModel) table.getModel();
        scroll = new JScrollPane(table);
        add(scroll);
        tableadjust();

        try {
            Conn c = new Conn();
            String query = queryExecute;
            System.out.println(query);
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

            table.setRowSelectionAllowed(false);  // Disable row selection
            table.setColumnSelectionAllowed(false);  // Disable column selection
            table.getTableHeader().setReorderingAllowed(false);
            table.setEnabled(false);
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

    //for left padding in text field
    public static JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(), // Preserve original border
                BorderFactory.createEmptyBorder(0, 10, 0, 10) // Add padding: top, left, bottom, right
        ));
        return textField;
    }

    public void SearchField() {
        //Roomno text
        JLabel Roomno = new JLabel("Room Number: ");
        Roomno.setBounds(60, 80, 120, 30);
        Roomno.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Roomno);

        // Room Field
        roomField = createPaddedTextField();
        roomField.setBounds(190, 80, 130, 30);
        add(roomField);

        //RoomAvailable text
        JLabel RoomAvailable = new JLabel("Availablility:");
        RoomAvailable.setBounds(580, 80, 120, 30);
        RoomAvailable.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(RoomAvailable);

        String arr[] = {
            "Available",
            "Occupied"
        };
        roomavailable = new JComboBox(arr);
        roomavailable.setBounds(690, 80, 150, 30);
        roomavailable.setBackground(Color.WHITE);
        roomavailable.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(roomavailable);

    }

    public void SearchHeading(String value) {

        showhead = new JLabel(value);
        showhead.setBounds(330, 150, 320, 30);
        showhead.setForeground(Color.BLACK);
        showhead.setFont(new Font("Tahoma", Font.BOLD, 19));
        showhead.setVisible(true);
        add(showhead);
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
            Reception.main(new String[]{});
        } else if (e.getSource() == search) {

            try {

                String query1 = "SELECT roomnumber AS 'Room Number', availability AS 'Availability', cleaningStatus AS 'Room Status',price AS 'Price', bedType AS 'Bed Type' FROM room WHERE availability = '" + roomavailable.getSelectedItem() + "'";

                String query2 = "SELECT roomnumber AS 'Room Number', availability AS 'Availability', cleaningStatus AS 'Room Status',price AS 'Price', bedType AS 'Bed Type' FROM room WHERE roomnumber = '" + roomField.getText() + "'";
                String exeQuery = "";
                String h = "";
                if (!(roomField.getText().trim().equals(""))) {
                    exeQuery = query2;
                    h = "Information of Room " + roomField.getText();
                    roomField.setText("");

                } else {
                    exeQuery = query1;
                    h = "Informations of " + roomavailable.getSelectedItem() + " Room ";
                }
                showhead.setVisible(false);
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(exeQuery);

                if (!rs.isBeforeFirst()) { // Checks if there are no rows
                    h = "No Results Found";
                    scroll.setVisible(false);
                } else {
                    scroll.setVisible(true);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
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
                }

                SearchHeading(h);

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }
}

public class Search {

    public static void main(String[] args) {
        RoomSearch r = new RoomSearch();
        r.btn();
        r.SearchField();
        r.SearchHeading("Information of the  Rooms");
        r.showTable("SELECT roomnumber AS 'Room Number', availability AS 'Availability', cleaningStatus AS 'Room Status',price AS 'Price', bedType AS 'Bed Type'FROM room");
    }
}
