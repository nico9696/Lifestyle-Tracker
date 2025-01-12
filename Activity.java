/**
    This is a template for a Java file.

    The Activity class has methods that support initializing activity name 
    and calorie value, getting activity name and calorie value, and changing
    the calorie value.

    @author Nicholas Benedict D. Sy (236012)
    @version 16 May 2024

    I have not discussed the Java language code in my program
    with anyone other than my instructor or the teaching assistants
    assigned to this course.

    I have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.
    
    If any Java language code or documentation used in my program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.
**/

public class Activity {
    private String n;
    private double c; 

    /**
     * contructor that initializes all fields.
     * @param n - the activity name
     * @param c - the calorie value of the activity
     */
    public Activity(String n, double c){
        this.n = n;
        this.c = c;
    }

    /**
		Getter / Accessor methods
		@return  name of the activity
	**/ 
    public String getActivityName(){
        return n;
    }

    /**
		Getter / Accessor methods
		@return calorie value burned for performing the activity
	**/ 
    public double getActivityCalories(){
        return c;
    }

    /**
     * enables the calorie value to be updated
     * @param c the new calorie value of the activity 
    */
    public void updateCalories(double c){
        this.c = c;
    }
}
