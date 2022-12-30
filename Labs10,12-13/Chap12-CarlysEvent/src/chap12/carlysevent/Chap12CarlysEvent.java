/*
 * Author: Brian Moye
 * Date: 2020/12/07
 * Program: Chap12-CarlysEvent
 * Purpose: Modifies Carlys Event to catch exceptions.
 */
package chap12.carlysevent;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Chap12CarlysEvent {
    
    static DecimalFormat currency = new DecimalFormat("$###,###,###,##0.00");
    static DecimalFormat people = new DecimalFormat("###,###,##0");
    static int exit = 0;
    
    public static void main(String[] args) {
        DinnerEvent dinnerEvent = new DinnerEvent(getEventNumber(), 
            getNumOfGuests(), getPhoneNumber(), getEventType(), getEntree(), 
            getSide1(), getSide2(), getDessert());

        getStaff(dinnerEvent);
        
        Event.displayMotto();
        
        JOptionPane.showMessageDialog(null, displayEventInfo(dinnerEvent));
    }
    
    public static int getNumOfGuests() {
        int inputInt = 0;
        
        try {
            inputInt = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Enter the number of guests:", "Guest Entry", 
                JOptionPane.QUESTION_MESSAGE));

            if( inputInt < 5 || inputInt > 100 ) {
                JOptionPane.showMessageDialog(null,
                    "Number of guests must be between 5 and 100",
                    "Guest Entry", 
                    JOptionPane.INFORMATION_MESSAGE);
                inputInt = getNumOfGuests();
            }
        }
        catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Number of guests must "
                    + "be an integer number!");
            getNumOfGuests();
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
        int inputInt = 0;
        
        try {
            inputInt = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Please enter the number of the corresponding event type:\n" 
                + "1 - Wedding\n" + "2 - Baptism\n" + "3 - Birthday\n" 
                + "4 - Corporate\n" + "5 - Other", 
                "Event Type Entry", JOptionPane.QUESTION_MESSAGE)) - 1;
        }
        catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Please select a listed "
                    + "option.");
            getEventType();
        }
        
        return inputInt;
    }
    
    
    // Menu options
    public static int getEntree() {
        int inputInt = 0;
        
        try {
            inputInt = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Please enter the number of the corresponding entree:\n" 
                + "1 - Prime Rib\n" + "2 - Lobster\n" + "3 - Catfish\n" 
                + "4 - Lasagna\n", 
                "Entree Entry", JOptionPane.QUESTION_MESSAGE)) - 1;
        }
        catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Please select a listed "
                    + "option.");
            getEntree();
        }
        if (inputInt < 0 || inputInt > 3) {
            JOptionPane.showMessageDialog(null, "Please select a listed "
                    + "option.");
            getEntree();
        }
        
        return inputInt;
    }
    
    public static int getSide1() {
        int inputInt = 0;
        
        try {
            inputInt = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Please enter the number for the first side choice:\n" 
                + "1 - Mashed Potatoes\n" + "2 - Green Beans\n" 
                + "3 - Mac-N-Cheese\n" + "4 - Caesar Salad\n", 
                "First Side Entry", JOptionPane.QUESTION_MESSAGE)) - 1;
        }
        catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Please select a listed "
                    + "option.");
            getSide1();
        }
        if (inputInt < 0 || inputInt > 3) {
            JOptionPane.showMessageDialog(null, "Please select a listed "
                    + "option.");
            getSide1();
        }
        
        return inputInt;
    }
    
    public static int getSide2() {
        int inputInt = 0;
        
        try {
            inputInt = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Please enter the number for the first side choice:\n" 
                + "1 - Mashed Potatoes\n" + "2 - Green Beans\n" 
                + "3 - Mac-N-Cheese\n" + "4 - Caesar Salad\n", 
                "First Side Entry", JOptionPane.QUESTION_MESSAGE)) - 1;
        }
        catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Please select a listed "
                    + "option.");
            getSide2();
        }
        if (inputInt < 0 || inputInt > 3) {
            JOptionPane.showMessageDialog(null, "Please select a listed "
                    + "option.");
            getSide2();
        }
        
        return inputInt;
    }
    
    public static int getDessert() {
        int inputInt = 0;
        
        try {
            inputInt = Integer.parseInt(JOptionPane.showInputDialog(null, 
            "Please enter the number of the corresponding dessert:\n" 
            + "1 - Pumpkin Pie\n" + "2 - Reese's Cake\n" 
            + "3 - Strawberry Cheesecake\n", "First Side Entry", 
            JOptionPane.QUESTION_MESSAGE)) - 1;
        }
        catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Please select a listed "
                    + "option.");
            getDessert();
        }
        if (inputInt < 0 || inputInt > 2) {
            JOptionPane.showMessageDialog(null, "Please select a listed "
                    + "option.");
            getDessert();
        }
        
        return inputInt;
    }
    
    public static void getStaff(DinnerEvent event) {
        int guests= event.getNumOfGuests();
        int waiter;
        int bartender = guests / 25;
        int employeeType = 0;
        String strInput;
        int count = 1;
 
        waiter = guests / 10;
        if (waiter < 1) {
            waiter = 1;
        }
        
        while (count <= waiter) {
            // count is being used to position the employee in the employees array
            strInput = JOptionPane.showInputDialog(null, 
                    "Enter the Employee ID of waitstaff #" + (count) 
                            + ": ");
            int ID = Integer.parseInt(strInput);
            
            strInput = JOptionPane.showInputDialog(null, 
                    "Enter the First and Last name of waitstaff#" + (count) 
                            + ": ");
            String[] name = strInput.split(" ");
            
            strInput = JOptionPane.showInputDialog(null, 
                    "Enter the pay of waitstaff#" + (count) + ": ");
            double pay = Double.parseDouble(strInput);
            
            // setEmployee(is this employee waitstaff, bartender, or coordinator,
            //             position in the array, employee ID number, first name, last name, pay rate)
            event.setEmployee(employeeType, count, ID, name[0], name[1], pay);
            ++count;
        }
        
        if (bartender > 0) {
            employeeType = 1;
            while (bartender > 0) {
                strInput = JOptionPane.showInputDialog(null, 
                        "Enter the Employee ID of bartender #" + bartender
                                + ": ");
                int ID = Integer.parseInt(strInput);

                strInput = JOptionPane.showInputDialog(null, 
                        "Enter the First and Last name of bartender#" 
                                + bartender + ": ");
                String[] name = strInput.split(" ");

                strInput = JOptionPane.showInputDialog(null, 
                        "Enter the pay of bartender#" + bartender + ": ");
                double pay = Double.parseDouble(strInput);

                event.setEmployee(employeeType, count, ID, name[0], name[1], 
                                    pay);
                --bartender;
                ++count;
            }
        }
        
        employeeType = 2;
        strInput = JOptionPane.showInputDialog(null, 
                "Enter the Employee ID of the coordinator: ");
        int ID = Integer.parseInt(strInput);

        strInput = JOptionPane.showInputDialog(null, 
                "Enter the First and Last name of the coordinator: ");
        String[] name = strInput.split(" ");

        strInput = JOptionPane.showInputDialog(null, 
                "Enter the pay of the coordinator: ");
        double pay = Double.parseDouble(strInput);

        event.setEmployee(employeeType, count, ID, name[0], name[1], pay);
    }
    
    // Sorting
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
                --innerCount;
            }
            event[innerCount + 1] = tempEvent;
            ++outerCount;
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
                --innerCount;
            }
            event[innerCount + 1] = tempEvent;
            ++outerCount;
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
                --innerCount;
            }
            event[innerCount + 1] = tempEvent;
            ++outerCount;
        }
        return event;
    }
    
    // Pick the method of sorting
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
            theMessage += displayEventInfo(event);
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
            + "\nLarge Event: " + event.isLargeEvent() + "\n\n" + event.getMenu() 
            + "\n" + event.getEmployeesInfo();
        
        return message;
    }
}
