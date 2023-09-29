package demo;


import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class TabbedPaneExample extends JPanel {

    public static void main(String[] args) {
        String multiLineString = "This is an example\nof a multiple line string.\\ It contains punctuation!";
        
        if (multiLineString.contains("\\")) {
            System.out.println("ok");
        } 
        
        /*
        boolean containsPunctuation = multiLineString.matches("\\p{Punct}");
        if (containsPunctuation) {
            System.out.println("The string contains punctuation.");
        } else {
            System.out.println("The string does not contain punctuation.");
        }
*/
    }
}
