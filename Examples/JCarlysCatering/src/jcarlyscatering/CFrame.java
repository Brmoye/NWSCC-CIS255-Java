package jcarlyscatering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Create a GUI
// Enter num guests into a text field; if not numeric set event price = 0
// Allow user to choose one entree from a group >= 4 choices
// Two side dishes from >= 4 choices
// One dessert from >= 3 choices
// Display event cost as $35 per person
// Update a list of current items chosen as the user makes selections
// If more than two side dishes are chosen remove all side dish selections
//      so the user can reselect.

public class CFrame extends JFrame implements ActionListener {
    
    final int WIDTH = 800;
    final int HEIGHT = 600;
    
    JLabel question = new JLabel("Enter the number of guests:");
    JLabel entreeSelection = new JLabel();
    JLabel sideSelection = new JLabel();
    JLabel dessertSelection = new JLabel();
    Font headFont = new Font("Arial", Font.BOLD, 16);
    Font bodyFont = headFont.deriveFont(Font.PLAIN, 12);
    JTextField numGuests = new JTextField(20);
    JButton done = new JButton("Enter");
    JPanel entrees = new JPanel(new FlowLayout());
    JCheckBox chicken = new JCheckBox("Chicken", false);
    JCheckBox steak = new JCheckBox("Steak", false);
    JCheckBox pork = new JCheckBox("Pork", false);
    JCheckBox fish = new JCheckBox("Fish", false);
    JPanel choices = new JPanel();
    ButtonGroup entreesGroup = new ButtonGroup();
    
    public CFrame() {
        
        super("Carly's Event Catering");
        setSize(WIDTH, HEIGHT);
        GroupLayout grpLayout = new GroupLayout(entrees);
        setLayout(grpLayout);
        question.setFont(headFont);

        setLocationRelativeTo(null);
        
        chicken.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                entreeSelection.setText("Chicken");
            }
        });
        
        steak.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                entreeSelection.setText("Steak");
            }
        });
        
        pork.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                entreeSelection.setText("Pork");
            }
        });
        
        fish.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                entreeSelection.setText("Fish");
            }
        });
        question.setBounds(20, 20, 240, 18);
        numGuests.setBounds(240, 20, 50, 25);
        numGuests.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        done.setBounds(240, 100, 80, 25);
        entrees.setBounds(40, 360, 340, 25);
        entreeSelection.setBounds(300, 400, 200, 25);
        add(question); 
        add(numGuests);
        add(done);
        
        // Add checkboxes to group so only one can be selected at a time
        entreesGroup.add(chicken);
        entreesGroup.add(steak);
        entreesGroup.add(pork);
        entreesGroup.add(fish);
        
        // Add buttons to entrees panel for placement in GUI
        entrees.add(chicken);
        entrees.add(steak);
        entrees.add(pork);
        entrees.add(fish);
        
        
        add(entrees);
        add(entreeSelection);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        done.addActionListener(this);
        setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
