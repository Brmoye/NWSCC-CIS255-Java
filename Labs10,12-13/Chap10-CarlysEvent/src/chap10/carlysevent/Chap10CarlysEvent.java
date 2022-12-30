/*
 * Author: Brian Moye
 * Date: 2020/12/06
 * Program: Chap10-CarlysEvent
 * Purpose: Modifies Carlys Event to add a DinnerEvent class and use it.
 */
package chap10.carlysevent;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap10CarlysEvent {
    
    static DecimalFormat currency = new DecimalFormat("$###,###,###,##0.00");
    static DecimalFormat people = new DecimalFormat("###,###,##0");
    static int exit = 0;
    
    public static void main(String[] args) {
        DinnerEvent[] dinnerEvents = new DinnerEvent[4];
        
        for (int i = 0; i < dinnerEvents.length; i++) {
            dinnerEvents[i] = new DinnerEvent(getEventNumber(), 
                getNumOfGuests(), getPhoneNumber(), getEventType(), getEntree(),
                getSide1(), getSide2(), getDessert());
        }
        
//      Test Events
//        dinnerEvents[0] = new DinnerEvent("B232", 11, "(555)555-5555", 2, 0, 0, 
//                                          1, 1);
//        dinnerEvents[1] = new DinnerEvent("L022", 5, "123555-5555", 4, 1, 2, 3,
//                                          2);
//        dinnerEvents[2] = new DinnerEvent("C131", 75, "(555)5255225", 3, 2, 0,
//                                          2, 0);
//        dinnerEvents[3] = new DinnerEvent("H0312", 22, "1234567890", 1, 3, 1, 3,
//                                          1);

        Event.displayMotto();
        
        while(exit != 1) {
            displayEventInfoArray(dinnerEvents);
            pickSort(dinnerEvents);
        }
    }
    
    public static int getNumOfGuests() {
        int inputInt;
        
        String inputStr = JOptionPane.showInputDialog(null,
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
        String inputStr = JOptionPane.showInputDialog(null, 
            "Enter the event number:", "Event Number Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        return inputStr;
    }
    
    public static String getPhoneNumber() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Enter a contact phone number:", "Phone Number Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        return inputStr;
    }
    
    public static int getEventType() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number of the corresponding event type:\n" 
            + "1 - Wedding\n" + "2 - Baptism\n" + "3 - Birthday\n" 
            + "4 - Corporate\n" + "5 - Other", 
            "Event Type Entry", JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr) - 1;
    }
    
    public static int getEntree() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number of the corresponding entree:\n" 
            + "1 - Prime Rib\n" + "2 - Lobster\n" + "3 - Catfish\n" 
            + "4 - Lasagna\n", 
            "Entree Entry", JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr) - 1;
    }
    
    public static int getSide1() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number for the first side choice:\n" 
            + "1 - Mashed Potatoes\n" + "2 - Green Beans\n" 
            + "3 - Mac-N-Cheese\n" + "4 - Caesar Salad\n", 
            "First Side Entry", JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr) - 1;
    }
    
    public static int getSide2() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number for the second side choice:\n" 
            + "1 - Mashed Potatoes\n" + "2 - Green Beans\n" 
            + "3 - Mac-N-Cheese\n" + "4 - Caesar Salad\n", 
            "First Side Entry", JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr) - 1;
    }
    
    public static int getDessert() {
        String inputStr = JOptionPane.showInputDialog(null, 
            "Please enter the number of the corresponding dessert:\n" 
            + "1 - Pumpkin Pie\n" + "2 - Reese's Cake\n" 
            + "3 - Strawberry Cheesecake\n", "First Side Entry", 
            JOptionPane.QUESTION_MESSAGE);
        
        return Integer.parseInt(inputStr) - 1;
    }
    
    public static DinnerEvent[] sortEventByEventNum(DinnerEvent[] event) {
        int outerCount = 1;
        int innerCount;
        DinnerEvent tempEvent;
        
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
    
    public static DinnerEvent[] sortEventByGuests(DinnerEvent[] event) {
        int outerCount = 1;
        int innerCount;
        DinnerEvent tempEvent;
        
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
    
    public static DinnerEvent[] sortEventByEventType(DinnerEvent[] event) {
        int outerCount = 1;
        int innerCount;
        DinnerEvent tempEvent;
        
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
    
    public static void pickSort(DinnerEvent[] events) {
        
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Sort by:\n" + "0 - Event Number\n" + "1 - Number of Guests\n" 
                + "2 - Event Type\n" + "9 - Exit", "Event Sort Options", 
                JOptionPane.INFORMATION_MESSAGE));
        switch (choice) {
            case 0:
                sortEventByEventNum(events);
                break;
            case 2:
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
    
    public static void displayEventInfoArray(DinnerEvent[] events) {
        String theMessage = "";
        
        // For each event in events[]
        for (DinnerEvent event : events) {
            theMessage += displayEventInfo(event) + event.getMenu() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, theMessage, "Carly's Event Details",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static String displayEventInfo(DinnerEvent event) {
        String message = "";
        
        message += "The contact phone number for event #"+ event.getEventNum() 
            + " is " + event.getPhoneNumber() + ".\nThe cost for a(n) " 
            + event.getEventType() + " event with "
            + people.format(event.getNumOfGuests()) + " guests will be " 
            + currency.format(event.getPrice()) + ".\nThe cost per guest is: "
            + currency.format(event.getPricePerGuest())
            + "\nLarge Event: " + event.isLargeEvent() + "\n";
        
//        JOptionPane.showMessageDialog(null, message, "Carly's Event Details",
//                JOptionPane.INFORMATION_MESSAGE);
        return message;
    }
}
