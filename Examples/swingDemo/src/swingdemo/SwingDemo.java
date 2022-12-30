package swingdemo;

import javax.swing.*;
import java.awt.*;

public class SwingDemo {
    public static void main(String[] args) {
        final int WIDTH = 500, HEIGHT = 300;
        JFrame myFrame = new JFrame("My First Frame");
        JLabel greeting = new JLabel("Hello.");
        JLabel greeting2 = new JLabel("Who are you?");
        Font headlineFont = new Font("Arial", Font.BOLD, 36);
        
        myFrame.setSize(WIDTH, HEIGHT);
        myFrame.setLayout(new FlowLayout());
        
        greeting.setFont(headlineFont);
        greeting2.setFont(headlineFont);
        myFrame.add(greeting);
        myFrame.add(greeting2);
        
        myFrame.setDefaultLookAndFeelDecorated(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //myFrame.setBounds(800, 500, WIDTH, HEIGHT);
        myFrame.setLocationRelativeTo(null);
        
        myFrame.setVisible(true);
    }
}