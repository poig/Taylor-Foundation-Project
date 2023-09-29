package demo;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;

public class OOP_project extends JPanel implements ActionListener {

    // Declare the components
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private ArrayList<String> ids;
    private JButton btnSubmit;
    private JComboBox<String> chCourse;
    private JTextArea txtAddress;
    JFileChooser filechooser;
    private JButton Miao;
    private JLabel label2;
    // Constructor
    public OOP_project() {
        
        // Initialize the components
        // for the column of the naming part
        label = new JLabel("Enter your name:");
        textField = new JTextField(10);
        button = new JButton("Save");
        ids = new ArrayList<>();
        
        //Entering the age range 
        JLabel lblCourse = new JLabel("Your age:");
        chCourse = new JComboBox<>();
        chCourse.addItem("0-20");
        chCourse.addItem("20-40");
        chCourse.addItem("40 and above");
        chCourse.addItem("none of those");

        //Entering the email 
        JLabel lblAddress = new JLabel("Enter your Email: ");
        txtAddress = new JTextArea(2, 12);
        btnSubmit = new JButton("Submit");

        // Add action listener to the button
        button.addActionListener(this);
        btnSubmit.addActionListener(this);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        
        // adding the dailog of the picture 
        setLayout(new BorderLayout());
        label2 = new JLabel();
        add(label2, BorderLayout.CENTER);
        JButton Miao = new JButton("Open");
        add(Miao, BorderLayout.SOUTH);
        Miao.addActionListener(this);
        filechooser = new JFileChooser();

        // Add the additional components to the panel
        panel.add(lblCourse);
        panel.add(chCourse);
        panel.add(lblAddress);
        panel.add(txtAddress);
        panel.add(btnSubmit);
        panel.add(Miao);
        panel.add(label2);

        // Set the layout manager for the panel
        panel.setLayout(new FlowLayout());

        // Add the panel to the main JPanel
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }

    // Handle the button click event
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            // Get the text from the text field
            String id = textField.getText();

            // Check if the text is not empty
            if (!id.isEmpty()) {
                // Add the id to the ArrayList
                ids.add(id);

                // Clear the text field
                textField.setText("");

                // Show a confirmation message
                JOptionPane.showMessageDialog(this, "Id saved: " + id);
            }
        } else if (e.getSource() == btnSubmit) {
            // Handle submit button click event here
            // This is just a placeholder, you can add your desired functionality
            String course = (String) chCourse.getSelectedItem();
            String address = txtAddress.getText();

            // Show a message with the selected course and entered email address
            JOptionPane.showMessageDialog(this, "Selected Course: " + course + "\nEmail Address: " + address);
        }
        
        
        if (e.getSource() == Miao) {
            int returnVal = filechooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = filechooser.getSelectedFile();
                try {
                    FileInputStream fis = new FileInputStream(file);
                    byte[] data = new byte[fis.available()];
                    fis.read(data);
                    ImageIcon icon = new ImageIcon(data);
                    label.setIcon(icon);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Profile");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(350,200);
            frame.setLocationRelativeTo(null);

            OOP_project panel = new OOP_project();
            frame.getContentPane().add(panel);

            frame.setVisible(true);
        });
    }
}

