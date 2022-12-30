/*
 * Author: Brian Moye
 * Date: 2020/12/02
 * Program: Chap8-CarlysEvent
 * Purpose: Modifies Carlys Event so that the program defines event type.
 */
package chap8.carlysevent;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap8CarlysEvent {
    public static void main(String[] args) {
        Event[] events = new Event[3];
        
        for (int i = 0; i < events.length; i++) {
            events[i] = new Event(getEventNumber(), getNumOfGuests(), 
                    getPhoneNumber(), getEventType());
        }
        
        Event.displayMotto();
        
        for (Event event : events) {
            displayEventInfo(event);
        }
    }
    
    public static int getNumOfGuests() {
        String inputStr;
        int inputInt;
        
        inputStr = JOptionPane.showInputDialog(null,
            "Enter the number of guests:", "Guest Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        inputInt = Integer.parseInt(inputStr);
        
        if( inputInt < 5 || inputInt > 100 ) {
            JOptionPane.showMessageDialog(null,
                "Number of guests must be between 5 and 100",
                "Guest Entry", 
                JOptionPane.INFORMATION_MESSAGE);
            inputInt = getNumOfGuests();
        }
        
        return inputInt;
    }
    
    public static String getEventNumber() {
        String inputStr;
        
        inputStr = JOptionPane.showInputDialog(null, "Enter the event number:", 
            "Event Number Entry", JOptionPane.QUESTION_MESSAGE);
        
        return inputStr;
    }
    
    public static String getPhoneNumber() {
        String inputStr;
        
        inputStr = JOptionPane.showInputDialog(null, 
            "Enter a contact phone number:", "Phone Number Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        return inputStr;
    }
    
    public static int getEventType() {
        String inputStr;
        
        inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number of the corresponding event type:\n" 
            + "1 - Wedding\n" + "2 - Baptism\n" + "3 - Birthday\n" 
            + "4 - Corporate\n" + "5 - Other", 
            "Event Type Entry", JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr) - 1;
    }
    
    public static void displayEventInfo(Event event) {
        DecimalFormat currency = new DecimalFormat("$###,###,###,##0.00");
        DecimalFormat people = new DecimalFormat("###,###,##0");
        
        JOptionPane.showMessageDialog(null, 
            "The contact phone number for event #"+ event.getEventNum() + " is " 
            + event.getPhoneNumber() + ".\nThe cost for a(n) " 
            + event.getEventType() + " event with "
            + people.format(event.getNumOfGuests()) + " guests will be " 
            + currency.format(event.getPrice()) + ".\nThe cost per guest is: "
            + currency.format(event.getPricePerGuest())
            + "\nLarge Event: " + event.isLargeEvent(), "Carly's Event Details", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
