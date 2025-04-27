/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.table.JTableHeader;

class Node {
    String name;
    int age;
    Node prev, next;

    Node(String name, int age) {
        this.name = name;
        this.age = age;
        this.prev = null;
        this.next = null;
    }
}
public class Try extends JFrame{
      public static void main(String[] args) {
        // Manually link nodes
        Node n1 = new Node("Alice", 20);
        Node n2 = new Node("Bob", 25);
        Node n3 = new Node("Charlie", 30);

        // Linking the nodes
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;

        // Display table
        showTable(n1);
    }

    public static void showTable(Node head) {
        // Count nodes
        int rowCount = 0;
        Node temp = head;
        while (temp != null) {
            rowCount++;
            temp = temp.next;
        }

        // Prepare data
        String[][] data = new String[rowCount][2];
        String[] columns = {"Name", "Age"};

        temp = head;
        int i = 0;
        while (temp != null) {
            data[i][0] = temp.name;
            data[i][1] = String.valueOf(temp.age);
            temp = temp.next;
            i++;
        }

        // Create table
        JTable table = new JTable(data, columns);

        // Center align the cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // Name
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // Age

        JTableHeader header = table.getTableHeader();
header.setBackground(Color.WHITE);
        // Add to frame
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("Manual Doubly List Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
