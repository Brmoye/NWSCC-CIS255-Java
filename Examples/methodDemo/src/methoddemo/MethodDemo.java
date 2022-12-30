package methoddemo;

import javax.swing.JOptionPane;

public class MethodDemo {
    public static void main(String[] args) {
        displayAddress();
    }
    
    public static void displayAddress() {
        JOptionPane.showMessageDialog(null, "XYZ Company\n" + 
        "8900 U.S. Hwy 14\n" + "Crystal Lake, IL 60014", "Company Banner",
        JOptionPane.INFORMATION_MESSAGE);
    }
}
