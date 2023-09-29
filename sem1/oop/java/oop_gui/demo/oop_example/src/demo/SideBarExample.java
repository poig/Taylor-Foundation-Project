package demo;

import java.awt.*;
import javax.swing.*;

public class SideBarExample extends JFrame {
    public SideBarExample() {
        JPanel sideBar = new JPanel();
        sideBar.setBounds(0, 0, 180, (int) this.getBounds().getHeight());
        sideBar.setLayout(new GridBagLayout());

        JPanel optionBar = new JPanel();
        optionBar.setBorder(BorderFactory.createTitledBorder("Box1"));
        optionBar.setLayout(new GridBagLayout());

        JPanel buttonBar = new JPanel();
        buttonBar.setBorder(BorderFactory.createTitledBorder("Options"));
        buttonBar.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.ipady = 5;
        c.insets = new Insets(10, 0, 0, 0);

        JButton simplify;
        simplify = new JButton("Open");
        //simplify.addActionListener(this.listener);
        c.gridy = 0;
        buttonBar.add(simplify, c);

        JButton mergeButton;
        mergeButton = new JButton("Close");
        //mergeButton.addActionListener(this.listener);
        c.gridy = 1;
        buttonBar.add(mergeButton, c);

        JButton splitButton;
        splitButton = new JButton("Merge");
        //splitButton.addActionListener(this.listener);
        c.gridy = 2;
        buttonBar.add(splitButton, c);

        c.insets = new Insets(0, 5, 5, 5);
        c.gridy = 0;
        sideBar.add(optionBar, c);

        c.gridy = 1;
        c.ipadx = 70;
        sideBar.add(buttonBar, c);

        add(sideBar);
    }

    public static void main(String[] args) {
      SideBarExample frame = new SideBarExample();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400,400);
      frame.setVisible(true);
    }
}