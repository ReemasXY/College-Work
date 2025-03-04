import javax.swing.*;

public class Try {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("JLabel Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a JLabel
        JLabel label = new JLabel("Initial Text");
        label.setBounds(50, 50, 200, 30);
        frame.add(label);

        // Change the value of the JLabel after some action
        JButton button = new JButton("Change Text");
        button.setBounds(50, 100, 150, 30);
        button.addActionListener(e -> label.setText("Updated Text"));
        frame.add(button);

        // Show the JFrame
        frame.setVisible(true);
    }
}
