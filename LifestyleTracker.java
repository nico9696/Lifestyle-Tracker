/**
    This is a template for a Java file.

    The LifestyleTracker class has methods that support adding food and activities 
    to their own lists, recording eating and performing, and viewing full reports, 
    reports so far, and "reports per." Lastly, it supports editing and deleting past 
    records.

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

import java.util.ArrayList;
import java.util.Scanner;

public class LifestyleTracker {

    ArrayList<Food> foodList; 
    ArrayList<Activity> activityList; 

    ArrayList<String> foodEatenList; 
    ArrayList<Double> servingsList; 
    ArrayList<Double> foodCaloriesList; 

    ArrayList<String> activityPerformedList; 
    ArrayList<Double> hoursList; 
    ArrayList<Double> activityCaloriesList; 

    private double totalCaloriesConsumed; 
    private double totalCaloriesBurned;
    private double netCalories;

    /**
     * constructor that initializes all fields.
     * @param foodList list of food added
     * @param activityList list of activities added
     * 
     * @param foodEatenList tracks food eaten
     * @param servingsList tracks serving of each food (if burger is eaten 2 separate times, servings are counted separately)
     * @param foodCaloriesList tracks total calories of each meal (if burger is eaten 2 separate times, total calories are counted separately)
     * 
     * @param activityPerformedList tracks activities performed
     * @param hoursList tracks hours of each activity (if running is done 2 separate times, hours are counted separately)
     * @param activityCaloriesList tracks total calories of each activity (if running is done 2 separate times, total calories are counted separately)

     * 
     * @param totalCaloriesConsumed total calories consumed from food
     * @param totalCaloriesBurned total calories burned from activities
     * @param netCalories totalCaloriesConsumed minus totalCaloriesBurned
     */
    public LifestyleTracker(){
        foodList = new ArrayList<Food>();
        activityList = new ArrayList<Activity>();

        foodEatenList = new ArrayList<String>();
        servingsList = new ArrayList<Double>();
        foodCaloriesList = new ArrayList<Double>();

        activityPerformedList = new ArrayList<String>();
        hoursList = new ArrayList<Double>();
        activityCaloriesList = new ArrayList<Double>();

        this.totalCaloriesConsumed = 0;
        this.totalCaloriesBurned = 0;
        this.netCalories = 0;
    }

    /**
     * adds food to ArrayList called foodList
     * @param n - the name of the food
     * @param c - the calorie value of the food
    */
    public void addFood(String n, double c){
        Food food = new Food(n, c); // new instance of Food class
        boolean repeated = false;
        if(foodList.size() == 0){ // if nothing in list, immediately added
            foodList.add(food);
            System.out.printf("Added Food %s with %.2f kcal%n", n, c);
        }else{
            for(int x = 0; x < foodList.size(); x++){
                if(foodList.get(x).getFoodName().equals(n)){ // if already in list, food calories is updated
                    foodList.get(x).updateCalories(c);
                    repeated = true;
                    System.out.printf("Updated Food %s with %.2f kcal%n", n, c);
                    break;
                }
            }
            if(repeated == false){ // if not in list, food is added
                foodList.add(food);
                System.out.printf("Added Food %s with %.2f kcal%n", n, c);
            }
        }
    }

    /**
     * adds activities to ArrayList called activityList
     * @param n - the name of the activity
     * @param c - the calorie value of the activity
    */
    public void addActivity(String n, double c){
        Activity activity = new Activity(n, c); // new instance of Activity class
        boolean repeated = false;
        if(activityList.size() == 0){ // if nothing in list, immediately added
            activityList.add(activity);
            System.out.printf("Added Activity %s with %.2f kcal%n", n, c);
        }else{
            for(int x = 0; x < activityList.size(); x++){
                if(activityList.get(x).getActivityName().equals(n)){ // if already in list, activity calories is updated
                    activityList.get(x).updateCalories(c);
                    repeated = true;
                    System.out.printf("Updated Activity %s with %.2f kcal%n", n, c);
                    break;
                }
            }
            if(repeated == false){ // if not in list, activity is added
                activityList.add(activity);
                System.out.printf("Added Activity %s with %.2f kcal%n", n, c);
            }
        }
    }

    /**
     * method for eating (adds to ArrayList called foodEatenList, servingsList, and foodCaloriesList)
     * @param foodName the name of the food
     * @param servings the servings eaten of the food
    */
    public boolean eat(String foodName, double servings){
        boolean exists = false;
        if(servings < 0){
            System.out.println("Number of servings cannot be negative.");
            exists = true;
            return true;
        }else{
            for(int x = 0; x < foodList.size(); x++){
                if(foodList.get(x).getFoodName().equals(foodName)){ // if food is in list, returns true; values are added to foodEatenList, servingsList, and foodCaloriesList
                    foodEatenList.add(foodName);
                    servingsList.add(servings);
                    double kcal = foodList.get(x).getFoodCalories() * servings; // calorie value * servings
                    foodCaloriesList.add(kcal);
                    totalCaloriesConsumed += kcal;
                    exists = true;
                    System.out.printf("Ate %.2f serving(s) of %s, %.2f kcal%n", servings, foodName, kcal);
                    return true;
                }
            }
            if(exists == false){ // if food is not in list, returns false
                System.out.println("The specified food does not exist. Would you like to add this food to your list? Yes or No?");
                return false;
            }
        }
        return exists;
    }

    /**
     * method for performing (adds to ArrayList called activityPerformedList, hoursList, and activityCaloriesList)
     * @param actName the name of the activity
     * @param hours hours performed of the activity
    */
    public boolean perform(String actName, double hours){
        boolean exists = false;
        if(hours < 0){
            System.out.println("Number of hours cannot be negative.");
            exists = true;
            return true;
        }else{
            for(int x = 0; x < activityList.size(); x++){
                if(activityList.get(x).getActivityName().equals(actName)){ // if activity is in list, returns true; values are added to activityPerformedList, hoursList, and activityCaloriesList
                    activityPerformedList.add(actName);
                    hoursList.add(hours);
                    double kcal = activityList.get(x).getActivityCalories() * hours; // calorie value * hours
                    activityCaloriesList.add(kcal);
                    totalCaloriesBurned += kcal;
                    exists = true;
                    System.out.printf("Performed %.2f hour(s) of %s, %.2f kcal%n", hours, actName, kcal);
                    return true;
                }
            }
            if(exists == false){ // if activity is not in list, returns false
                System.out.println("The specified activity does not exist. Would you like to add this food to your list? Yes or No?");
                return false;
            }
        }
        return exists;
    }

    /**
     * displays full report
    */
    public void report(){
        String loseOrGain = ""; // if netCalories < 0, loseOrGain = "lose"

        System.out.println("----------------");
        System.out.println("LIFESTYLE REPORT");
        System.out.println("----------------");

        System.out.println("Food Consumed:");
        for(int x = 0; x < foodEatenList.size(); x++){
            System.out.printf("%.2f serving(s) of %s, %.2f kcal%n", servingsList.get(x), foodEatenList.get(x), foodCaloriesList.get(x));
        }

        System.out.println("----------------");
        System.out.printf("Total Calories Consumed: %.2f kcal%n", totalCaloriesConsumed);
        System.out.println("----------------");

        System.out.println("Activities Performed: ");
        for(int x = 0; x < activityPerformedList.size(); x++){
            System.out.printf("%.2f hour(s) of %s, %.2f kcal%n", hoursList.get(x), activityPerformedList.get(x), activityCaloriesList.get(x));
        }

        System.out.println("----------------");
        System.out.printf("Total Calories Burned: %.2f kcal%n", totalCaloriesBurned);
        System.out.println("----------------");

        netCalories = totalCaloriesConsumed - totalCaloriesBurned;
        System.out.printf("Net Calories for the Day: %.2f kcal%n", netCalories);
        System.out.println("If you keep up this lifestyle...");

        if(netCalories < 0){
            loseOrGain = "lose";
        }else{
            loseOrGain = "gain";
        }
        System.out.printf("In a week, you will %s %.2f kilograms.%n", loseOrGain, Math.abs((netCalories * 0.00012959782) * 7)); 
        System.out.printf("In a month, you will %s %.2f kilograms.%n", loseOrGain, Math.abs((netCalories * 0.00012959782) * 30)); 
        System.out.printf("In 3 months, you will %s %.2f kilograms.%n", loseOrGain, Math.abs((netCalories * 0.00012959782) * 90)); 
        System.out.printf("In 6 months, you will %s %.2f kilograms.%n", loseOrGain, Math.abs((netCalories * 0.00012959782) * 180)); 
        System.out.println("----------------");
    }

    // add-ons:

    /**
     * displays report so far (with index)
    */
    public void reportSoFar(){
        System.out.println("----------------");
        System.out.println("LIFESTYLE REPORT (SO FAR)");
        System.out.println("----------------");

        System.out.println("Food Consumed:");
        for(int x = 0; x < foodEatenList.size(); x++){
            System.out.printf("[%d] %.2f serving(s) of %s, %.2f kcal%n", x, servingsList.get(x), foodEatenList.get(x), foodCaloriesList.get(x));
        }

        System.out.println("----------------");
        System.out.println("Activities Performed: ");
        for(int x = 0; x < activityPerformedList.size(); x++){
            System.out.printf("[%d] %.2f hour(s) of %s, %.2f kcal%n", x, hoursList.get(x), activityPerformedList.get(x), activityCaloriesList.get(x));
        }
    }

    /**
     * method for editing food eaten or activity performed given the index
     * @param foodOrActivity is edited value food or activity
     * @param index what index is it in
     * @param name of new food eaten or activity performed
     * @param servingsOrHours number of new servings or hours
    */
    public void edit(String foodOrActivity, int index, String name, double servingsOrHours){

        if(foodOrActivity.equals("Food")){
            if(servingsOrHours < 0){
                System.out.println("Number of servings cannot be negative.");
            }else{
                for(int x = 0; x < foodList.size(); x++){
                    if(foodList.get(x).getFoodName().equals(name)){ 
                        totalCaloriesConsumed -= foodCaloriesList.get(index); // calorie value of previous food minused from total
                        foodEatenList.set(index, name); // replaces old value
                        servingsList.set(index, servingsOrHours);
                        double kcal = foodList.get(x).getFoodCalories() * servingsOrHours; // calorie value * servings
                        foodCaloriesList.set(index, kcal);
                        totalCaloriesConsumed += kcal;
                        System.out.printf("Edited Food Consumed index[%d] to %s with %.2f serving(s)%n", index, name, servingsOrHours);
                    }
                }
            }
        }else if(foodOrActivity.equals("Activity")){
            if(servingsOrHours < 0){
                System.out.println("Number of hours cannot be negative.");
            }else{
                for(int x = 0; x < activityList.size(); x++){
                    if(activityList.get(x).getActivityName().equals(name)){
                        totalCaloriesBurned -= activityCaloriesList.get(index); // calorie value of previous activity minused from total
                        activityPerformedList.set(index, name); // replaces old value
                        hoursList.set(index, servingsOrHours);
                        double kcal = activityList.get(x).getActivityCalories() * servingsOrHours; // calorie value * servings
                        activityCaloriesList.set(index, kcal);
                        totalCaloriesBurned += kcal;
                        System.out.printf("Edited Activity Performed index[%d] to %s with %.2f hour(s)%n", index, name, servingsOrHours);
                    }
                }
            }
        }
    }

    /**
     * method for deleting food eaten or activity performed given the index
     * @param foodOrActivity is edited value food or activity
     * @param index what index is it in
    */
    public void delete(String foodOrActivity, int index){

        if(foodOrActivity.equals("Food")){
            if (index >= 0 && index < foodEatenList.size()) {
                System.out.printf("Deleted Food Eaten %s at index [%d]%n", foodEatenList.get(index), index);
                totalCaloriesConsumed -= foodCaloriesList.get(index); // removed from total calories consumed
                foodEatenList.remove(index); // removed in all corresponing array lists
                servingsList.remove(index);
                foodCaloriesList.remove(index);
            } else {
                System.out.println("Invalid index for Food Eaten list.");
            }
        }else if(foodOrActivity.equals("Activity")){
            if (index >= 0 && index < activityPerformedList.size()) {
                System.out.printf("Deleted Activity Performed %s at index [%d]%n", activityPerformedList.get(index), index);
                totalCaloriesBurned -= activityCaloriesList.get(index); // removed from total calories burned
                activityPerformedList.remove(index); // removed in all corresponing array lists
                hoursList.remove(index);
                activityCaloriesList.remove(index);
            } else {
                System.out.println("Invalid index for Activity Performed list.");
            }
        }
    }

    /**
     * MYSTERY ADD-ON: method for viewing report per total calories of each food eaten or activity performed
    */
    public void reportPer(){
        System.out.println("----------------");
        System.out.println("LIFESTYLE REPORT (PER FOOD OR CATEGORY)");
        System.out.println("----------------");

        System.out.println("Food Consumed:");
        ArrayList<String> accountedForFoodList = new ArrayList<String>();
        for(int x = 0; x < foodEatenList.size(); x++){
            if(!accountedForFoodList.contains(foodEatenList.get(x))){
                accountedForFoodList.add(foodEatenList.get(x)); // added in accountedForFoodList so that there will be no double record
                Double count = foodCaloriesList.get(x); // calorie value of that food eaten is added to count
                for(int y = x + 1; y < foodEatenList.size(); y++){
                    if(foodEatenList.get(x).equals(foodEatenList.get(y))){ // whenever the food name is equal to another food name in the list, its calorie value is added to count
                        count += foodCaloriesList.get(y);
                    }
                }
                System.out.println(foodEatenList.get(x) + ": " + count);
            }
        }
        System.out.println("Activities Performed:");
        ArrayList<String> accountedForActivityList = new ArrayList<String>();
        for(int x = 0; x < activityPerformedList.size(); x++){
            if(!accountedForActivityList.contains(activityPerformedList.get(x))){
                accountedForActivityList.add(activityPerformedList.get(x)); // added in accountedForactivityList so that there will be no double record
                Double count = activityCaloriesList.get(x); // calorie value of that activity performed is added to count
                for(int y = x + 1; y < activityPerformedList.size(); y++){
                    if(activityPerformedList.get(x).equals(activityPerformedList.get(y))){ // whenever the activity name is equal to another activity name in the list, its calorie value is added to count
                        count += activityCaloriesList.get(y);
                    }
                }
                System.out.println(activityPerformedList.get(x) + ": " + count);
            }
        }
    }
}