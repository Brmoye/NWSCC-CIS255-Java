package jframedemo;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JTextField response = new JTextField(10);
        JButton button = new JButton("Ok");
        JLabel greeting = new JLabel("Good day!");
        Font bigFont = new Font("Arial", Font.BOLD, 112);
        greeting.setFont(bigFont);
        frame.add(greeting);
        frame.add(response);
        frame.add(button);
        
        frame.setLayout(new FlowLayout());
        frame.setTitle("Hello");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
}
