package demo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextAreaExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JTextArea textArea = new JTextArea("Click me!");
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int offset = textArea.viewToModel(e.getPoint());
                if (offset >= 0 && offset <= 8) {
                    System.out.println("Text clicked!");
                }
            }
        });

        frame.add(textArea);
        frame.setVisible(true);
    }}