package overloaddemo;

import javax.swing.JOptionPane;

public class OverloadDemo {
    public static void main(String[] args) {
        int month = 6, day = 24, year = 2020;
        
        displayDate(month);
        displayDate(month, day);
        displayDate(month, day, year);
    }
    
    public static void displayDate(int mm) {
        JOptionPane.showMessageDialog(null, "Event date: " + mm + "/28/2022");
    }
    
    public static void displayDate(int mm, int dd) {
        JOptionPane.showMessageDialog(null, "Event date: " + mm + "/" + dd 
            + "/2021");
    }
    
    public static void displayDate(int mm, int dd, int yy) {
        JOptionPane.showMessageDialog(null, "Event date: " + mm + "/" + dd 
            + "/" + yy);
    }
}
