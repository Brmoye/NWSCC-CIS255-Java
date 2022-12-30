/*
 * Author: Brian Moye
 * Date: 2020/12/05
 * Program: Chap9-CarlysEvent
 * Purpose: Modifies Carlys Event so it can be sorted.
 */
package chap9.carlysevent;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap9CarlysEvent {
    
    static DecimalFormat currency = new DecimalFormat("$###,###,###,##0.00");
    static DecimalFormat people = new DecimalFormat("###,###,##0");
    static int exit = 0;
    
    public static void main(String[] args) {
        Event[] events = new Event[8];
        
        for (int i = 0; i < events.length; i++) {
            events[i] = new Event(getEventNumber(), getNumOfGuests(), 
                    getPhoneNumber(), getEventType());
        }

//      Test Events
//        events[0] = new Event("B232", 11, "(555)555-5555", 2);
//        events[1] = new Event("L022", 5, "123555-5555", 4);
//        events[2] = new Event("C131", 75, "(555)5255225", 3);
//        events[3] = new Event("H0312", 22, "1234567890", 1);
//        events[4] = new Event("E073", 18, "12345678901", 0);
//        events[5] = new Event("A683", 37, "0", 3);
//        events[6] = new Event("B200", 7, "1234", 2);
//        events[7] = new Event("Z666", 66, "abcdefghij", 1);
        
        Event.displayMotto();
        
        while(exit != 1) {
            displayEventInfoArray(events);
            pickSort(events);
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
    
    public static Event[] sortEventByEventNum(Event[] event) {
        int outerCount = 1;
        int innerCount;
        Event tempEvent;
        
        while(outerCount < event.length) {
            tempEvent = event[outerCount];
            innerCount = outerCount - 1;
            while(innerCount >= 0 && event[innerCount].getEventNum()
                    .compareTo(tempEvent.getEventNum()) > 0) {
                event[innerCount + 1] = event[innerCount];
                innerCount--;
            }
            event[innerCount + 1] = tempEvent;
            outerCount++;
        }
        return event;
    }
    
    public static Event[] sortEventByGuests(Event[] event) {
        int outerCount = 1;
        int innerCount;
        Event tempEvent;
        
        while(outerCount < event.length) {
            tempEvent = event[outerCount];
            innerCount = outerCount - 1;
            while(innerCount >= 0 && event[innerCount].getNumOfGuests() 
                    > tempEvent.getNumOfGuests()) {
                event[innerCount + 1] = event[innerCount];
                innerCount--;
            }
            event[innerCount + 1] = tempEvent;
            outerCount++;
        }
        return event;
    }
    
    public static Event[] sortEventByEventType(Event[] event) {
        int outerCount = 1;
        int innerCount;
        Event tempEvent;
        
        while(outerCount < event.length) {
            tempEvent = event[outerCount];
            innerCount = outerCount - 1;
            while(innerCount >= 0 && event[innerCount].getEventTypeInt()
                    > tempEvent.getEventTypeInt()) {
                event[innerCount + 1] = event[innerCount];
                innerCount--;
            }
            event[innerCount + 1] = tempEvent;
            outerCount++;
        }
        return event;
    }
    
    public static void pickSort(Event[] events) {
        
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Sort by:\n" + "1 - Event Number\n" + "2 - Number of Guests\n" 
                + "3 - Event Type\n" + "9 - Exit", "Event Sort Options", 
                JOptionPane.INFORMATION_MESSAGE));
        switch (choice) {
            case 1:
                sortEventByEventNum(events);
                break;
            case 3:
                sortEventByEventType(events);
                break;
            case 9:
                exit = 1;
                break;
            default:
                sortEventByGuests(events);
                break;
        }
    }
    
    public static void displayEventInfoArray(Event[] events) {
        String theMessage = "";
        
        // For each event in events[]
        for (Event event : events) {
            theMessage += displayEventInfo(event) + "\n";
        }
        
        JOptionPane.showMessageDialog(null, theMessage, "Carly's Event Details",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static String displayEventInfo(Event event) {
        String message = "";
        
        message += "The contact phone number for event #"+ event.getEventNum() 
            + " is " + event.getPhoneNumber() + ".\nThe cost for a(n) " 
            + event.getEventType() + " event with "
            + people.format(event.getNumOfGuests()) + " guests will be " 
            + currency.format(event.getPrice()) + ".\nThe cost per guest is: "
            + currency.format(event.getPricePerGuest())
            + "\nLarge Event: " + event.isLargeEvent() + "\n";
        
        return message;
    }
}
