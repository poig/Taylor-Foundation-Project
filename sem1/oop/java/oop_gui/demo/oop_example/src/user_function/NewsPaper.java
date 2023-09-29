package user_function;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author poig
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewsPaper {
    private final JFrame NewsPaper;
    
    public NewsPaper(int width, int height) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        NewsPaper = new JFrame();
        NewsPaper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // for user-log
        System.out.println("Enter NewsPaper");
        width = (int) (width * 0.5);
        height = (int) (height * 0.5);
        NewsPaper.setSize(width, height);
        NewsPaper.setTitle("NewsPaper"); // set title here
        
        
        NewsPaper.setLayout(new GridBagLayout());
        // font-size
        Font font = new Font("Arial", Font.PLAIN, width/40);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        
        NewsPaper.setVisible(true);
        NewsPaper.setLocationRelativeTo(null); // Center the frame on the screen
    }
    
    public void addQuizWindowListener(WindowListener listener) {
        this.NewsPaper.addWindowListener(listener);
    }
}
