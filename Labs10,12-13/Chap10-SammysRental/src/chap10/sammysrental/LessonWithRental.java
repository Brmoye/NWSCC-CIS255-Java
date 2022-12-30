package chap10.sammysrental;

public class LessonWithRental extends Rental {
    
    public final static String[] instructors = {"Robby", "Bobby", "Ashley", 
                            "Bridgette", "Will", "Trevor", "Lisa", "Brandon"};
    
    private boolean lessonRequired = false;
    
    // Constructor
    public LessonWithRental(String contractNumber, int minutesRented, 
            String phoneNumber, int rentalType) {
        
        super(contractNumber, minutesRented, phoneNumber, rentalType);
        if (rentalType == 0 || rentalType == 1) {
            lessonRequired = true;
        }
    }
    
    public String getInstructor() {
        String rentalInfo = "";
        
        if (lessonRequired) {
            rentalInfo = "Your rental of a " + this.getRentalType() 
                + " requires a lesson on how to operate it. " 
                + "Your instructor will be " 
                + instructors[this.getRentalTypeInt()] + ".\n";
        }
        else {
            rentalInfo = "Your rental of a " + this.getRentalType() 
                + " does not require a lesson on how to operate it. " 
                + "If you would like one anyway, your instructor would be " 
                + instructors[this.getRentalTypeInt()] + ".\n";
        }
        
        return rentalInfo;
    }
}
