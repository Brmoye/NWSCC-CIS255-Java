package arraydemo;

import javax.swing.JOptionPane;

public class ArrayDemo {
    public static void main(String[] args) {
        final int QUIT = 999;
        final int MAX = 10;
        int[] scores = new int[MAX];
        int score = 0;
        int count = 0;
        int total = 0;
        String strInput, result;
        
        strInput = JOptionPane.showInputDialog(null, "Enter a test score or "
            + QUIT + " to quit:", "Test Scores", 
            JOptionPane.INFORMATION_MESSAGE);
        score = Integer.parseInt(strInput);
        while (score != QUIT) {
            scores[count] = score; //Assign score to array element
            total += scores[count];
            count++;
            
            if (count == MAX) {
                score = QUIT;
            }
            else {
                strInput = JOptionPane.showInputDialog(null, "Enter a test score or "
                    + QUIT + " to quit:", "Test Scores", 
                    JOptionPane.INFORMATION_MESSAGE);
                score = Integer.parseInt(strInput);
            }
        }
        
        displayScores(scores, count, total);
    }
    
    public static void displayScores(int[] sc, int ct, int tot) {
        String result;
        
        result = "The scores entered were:\n";
        for (int x =0; x < ct; x++) {
            result += sc[x] + "\n";
        }
        if (ct != 0) {
            result += "\nAverage score: " + (tot * 1.0 / ct);
        }
        else {
            result += "\nNo scores entered.";
        }
        JOptionPane.showMessageDialog(null, result);
    }
}
