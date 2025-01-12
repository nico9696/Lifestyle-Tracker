/**
    This is a template for a Java file.

    The TrackerConsole class contains the main method, allowing users
    to input their daily routine into the tracker console and view various
    reports about their health 

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

import java.util.Scanner;

public class TrackerConsole {
    public static void main( String[] args ) {
        String name = args[0]; // input: "java TrackerConsole <name>"
        System.out.println("Welcome to " + name + "'s Lifestyle Tracker!");

        LifestyleTracker temp = new LifestyleTracker();
        Scanner in = new Scanner(System.in);
        while (true){
            String s = in.nextLine(); // takes user input
            String[] data; // array of strings called "data"
            data = s.split("\\s+"); // splits every space and adds to array

            if(data[0].equals("Food")){ // if first inputted word is "Food", this happens:
                double calorieValue = Double.parseDouble(data[2]); //converts from a string to a double
                temp.addFood(data[1], calorieValue); // second and third inputted words are passed as parameters
            } else if(data[0].equals("Activity")){
                double calorieValue = Double.parseDouble(data[2]);
                temp.addActivity(data[1], calorieValue);
            } else if(data[0].equals("Eat")){
                double servings = Double.parseDouble(data[2]);
                boolean correct = temp.eat(data[1], servings);
                if(!correct){
                    String yes = in.nextLine();
                    if(yes.equals("Yes")){
                        System.out.println("Sure! Please input the calorie value of that food.");
                        Double newCalorieValue = Double.parseDouble(in.nextLine());
                        temp.addFood(data[1], newCalorieValue);
                        temp.eat(data[1], servings);
                    }
                }
            } else if(data[0].equals("Perform")){
                double hours = Double.parseDouble(data[2]);
                boolean correct = temp.perform(data[1], hours);
                if(!correct){
                    String yes = in.nextLine();
                    if(yes.equals("Yes")){
                        System.out.println("Sure! Please input the calorie value of that activity.");
                        Double newCalorieValue = Double.parseDouble(in.nextLine());
                        temp.addActivity(data[1], newCalorieValue);
                        temp.perform(data[1], hours);
                    }
                }
            } else if(data[0].equals("Report")){
                temp.report();

            // add-ons:
            } else if(data[0].equals("ReportSoFar")){
                temp.reportSoFar();
            } else if(data[0].equals("Edit")){
                int index = Integer.parseInt(data[2]);
                double servingsOrHours = Double.parseDouble(data[4]);
                temp.edit(data[1], index, data[3], servingsOrHours);
            } else if(data[0].equals("Delete")){
                int index = Integer.parseInt(data[2]);
                temp.delete(data[1], index);
            } else if(data[0].equals("ReportPer")){
                temp.reportPer();
            }  
        }
    }
}
