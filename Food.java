/**
    This is a template for a Java file.

    The Food class has methods that support initializing food name and 
    calorie value, getting food name and calorie value, and changing
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

public class Food {
    private String f;
    private double c; 

    /**
     * constructor that initializes all fields.
     * @param f - the name of the food
     * @param c - the calorie value of the food
     */
    public Food(String f, double c){
        this.f = f;
        this.c = c;
    }

    /**
		Getter / Accessor methods
		@return the name of the food
	**/ 
    public String getFoodName(){
        return f;
    }

    /**
		Getter / Accessor methods
		@return the calorie value of the food
	**/ 
    public double getFoodCalories(){
        return c;
    }

    /**
     * enables the calorie value to be updated
     * @param c the new calorie value of the food
    */
    public void updateCalories(double c){
        this.c = c;
    }
}
