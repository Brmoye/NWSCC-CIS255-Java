package checkboxdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResortCalc extends JFrame implements ItemListener {
    
    final int BASE_PRICE = 200;
    final int WEEKEND_PREMIUM = 100;
    final int BREAKFAST_PREMIUM = 20;
    final int GOLF_PREMIUM = 75;
    int totalPrice = BASE_PRICE;
    Font appFont = new Font("Ariel", Font.BOLD, 16);
    
    JCheckBox weekendBox = new JCheckBox("Weekend premium $" 
        + WEEKEND_PREMIUM, false);
    JCheckBox breakfastBox = new JCheckBox("Breakfast $" 
        + BREAKFAST_PREMIUM, false);
    JCheckBox golfBox = new JCheckBox("Golf $" 
        + GOLF_PREMIUM, false);
    JLabel resortLabel = new JLabel("Resort Price Calculator");
    JLabel priceLabel = new JLabel("The price for your stay is");
    JLabel optionLabel1 = new JLabel("The base price for a room is $" 
        + BASE_PRICE + ".");
    JLabel optionLabel2 = new JLabel("Check the options you want.");
    JTextField totPrice = new JTextField(4);
    
    
    public JResortCalc() {
        super("Resort Price Calculator");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        //Set font for all acreen items
        weekendBox.setFont(appFont);
        breakfastBox.setFont(appFont);
        golfBox.setFont(appFont);
        resortLabel.setFont(appFont);
        priceLabel.setFont(appFont);
        optionLabel1.setFont(appFont);
        optionLabel2.setFont(appFont);
        totPrice.setFont(appFont);
        
        add(resortLabel);
        add(optionLabel1);
        add(optionLabel2);
        add(weekendBox);
        add(breakfastBox);
        add(golfBox);
        add(priceLabel);
        add(totPrice);
        
        totPrice.setText("$" + totalPrice);
        weekendBox.addItemListener(this);
        breakfastBox.addItemListener(this);
        golfBox.addItemListener(this);
    }
    
    @Override
    public void itemStateChanged(ItemEvent event) {
        Object source = event.getSource();
        int select = event.getStateChange();
        
        if (source == weekendBox)
            if (select == ItemEvent.SELECTED)
                totalPrice += WEEKEND_PREMIUM;
            else
                totalPrice -= WEEKEND_PREMIUM;
        else if (source == breakfastBox)
            if (select == ItemEvent.SELECTED)
                totalPrice += BREAKFAST_PREMIUM;
            else
                totalPrice -= BREAKFAST_PREMIUM;
        else if (source == golfBox)
            if (select == ItemEvent.SELECTED)
                totalPrice += GOLF_PREMIUM;
            else
                totalPrice -= GOLF_PREMIUM;
        
        totPrice.setText("$" + totalPrice);
    }
}
