package jframeclassdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class myJFrame extends JFrame implements ActionListener {
    final int WIDTH = 500, HEIGHT = 300;
    
    JLabel namePrompt = new JLabel("Enter your name:");
    JLabel greeting = new JLabel("Who are you?");
    JTextField nameField = new JTextField(12);
    JButton button = new JButton("Click to continue...");
    JLabel greetMsg = new JLabel("");
    Font headlineFont = new Font("Arial", Font.BOLD, 24);
    
    public myJFrame() {
        super("My JFrame Demo");
        
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        
        nameField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        namePrompt.setFont(headlineFont);
        nameField.setFont(headlineFont);
        greeting.setFont(headlineFont);
        greetMsg.setFont(headlineFont);
        add(greeting);
        add(namePrompt);
        add(nameField);
        add(button);
        add(greetMsg);
        nameField.addActionListener(this);
        button.addActionListener(this);

        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        greetMsg.setText("Hello, " + nameField.getText());
    }
}
