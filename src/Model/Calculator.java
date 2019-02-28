package Model;


import java.text.DecimalFormat;

public class Calculator {

    static DecimalFormat numFormat = new DecimalFormat("#.00");

    //height and weight are stored as cm and kg

    //method to calculate bmi
    public static double bmi(double weight, double height){
        //using int 2 as measuring in kg and metres
        double bmi = 0;

        //height is converted from cm to m
        height = height/100;

        bmi = (weight) / (height*height);

        return bmi;
    }

    //method to calculate ideal body weight
    //char sex can only take values M or F
    //height is taken in cm so must be converted to inches
    public static double idealBodyWeight(double height, char sex){

        double idealWeight = 0;

        //height is converted from cm to inches
        height = height*0.393701;

        if (sex == 'F'){
            idealWeight = 45.5 + ((height - 60)*2.3);
        }
        else if (sex == 'M'){
            idealWeight = 50 + ((height - 60)*2.3);
        }

        return idealWeight;
    }

    //method to calculate basic metabolic rate
    //age should be in yearsexercise
    //basic metabolic rate is how many calories your body needs with absolutely no exercise
    public static double metabolicRate(double weight, double height, int age, char sex){

        double metabolicRate = 0;

        if (sex == 'M'){
            metabolicRate = (10*weight) + (6.25*height) - (5*age) + 5;
        }
        else if (sex == 'F'){
            metabolicRate = (10*weight) + (6.25*height) - (5*age) - 161;
        }

        return metabolicRate;
    }

    //ENERGY EXPENDITURE
    //"Less than 2 hours per week" = 1.2
    //"2-5 hours per week" = 1.375
    //"5-10 hours per week" = 1.55
    //"10-15 hours per week" = 1.725
    //"More than 15 hours per week" = 1.9

    public static int dailyCals(double metabolicRate, double energyExpenditure){
        int dailyCals =(int) (metabolicRate*energyExpenditure);

        return dailyCals;
    }

    //method that uses above two methods and desired weight loss/gain to calculate target calories
    //this must also calculate calorie deficit based on how extreme weight loss is
    //maybe give goal a numeric value that helps to calculate calories deficit.
    public static int targetCalories(double metabolicRate, double energyExpenditure, double weightLoss){

        int targetCalories = 0;
        int dailyCals = dailyCals(metabolicRate, energyExpenditure);

        //weightloss given a value -3 to 3. negative values are for weight loss, positive for gain
        //-3 indicates a more extreme weight loss goal than -1
        int calorieDeficit = (int) (dailyCals*(weightLoss/10));

        targetCalories = (int) dailyCals - calorieDeficit;

        return targetCalories;
    }


    public static int targetBreakfast(int targetCalories){

        int targetBreakfast = (int) (targetCalories*0.18);

        return targetBreakfast;
    }

    public static int targetLunch(int targetCalories){

        int targetLunch = (int) (targetCalories*0.3);

        return targetLunch;
    }


    public static int targetDinner(int targetCalories){

        int targetDinner = (int) (targetCalories*0.4);

        return targetDinner;
    }

    public static int targetSnacks(int targetCalories){

        int targetSnacks = (int) (targetCalories*0.12);

        return targetSnacks;
    }

    public static int netCalories(int totalCalories, int exerciseCals){

        int netCalories = totalCalories - exerciseCals;

        return netCalories;
    }

    public static int calsUnderBudget(int targetCalories, int netCalories){

        int calsUnderBudget = targetCalories - netCalories;

        return calsUnderBudget;
    }

    public static int targetProtein(double weight){

        //first convert weight to pounds
        //protein intake should be 0.825 * weight in pounds
        weight = (weight*2.20462);
        int targetProtein = (int) (weight*0.825);

        return targetProtein;
    }

    public static int targetFat(int dailyCals){

        int targetFat = (int) ((dailyCals*0.25)/9);

        return targetFat;
    }

    public static int targetCarbs(int dailyCals, int targetProtein, int targetFat){

        int targetCarbs = (dailyCals - ((targetProtein*4) + (targetFat*9)))/4;

        return targetCarbs;
    }

    //optional methods to calculate target fat/carbs/protein/sugar

    //method calculating goal progress

    //method to predict when a user will meet their goal??

    public static void main(String args[]){

        //testing the methods with my measurements
        System.out.println("bmi: " + numFormat.format(bmi(74.8, 170)));
        System.out.println("ideal body weight: " + numFormat.format(idealBodyWeight(170, 'F')));
        double bmr = metabolicRate(74.8, 170, 19, 'F');
        System.out.println("bmr: " + numFormat.format(bmr));
        int cals = targetCalories(bmr, 1.2, 3);
        System.out.println("target calories: " + cals);

        //testing methods with toms measurements
        /*System.out.println("bmi: " + numFormat.format(bmi(77.4, 182)));
        System.out.println("ideal body weight: " + numFormat.format(idealBodyWeight(182, 'M')));
        double bmr2 = metabolicRate(77.4, 182, 20, 'M');
        System.out.println("bmr: " + numFormat.format(bmr2));
        System.out.println("target calories: " + targetCalories(bmr2, 3));
        */

        System.out.println("Breakfast: " + targetBreakfast(cals));
        System.out.println("Lunch: " + targetLunch(cals));
        System.out.println("Dinner: " + targetDinner(cals));
        System.out.println("Snacks: " + targetSnacks(cals));

        int net = netCalories(1600, 400);
        System.out.println("Net calories: " + net);
        System.out.println("Calories under budget: " + calsUnderBudget(cals, net));

        System.out.println("Target Protein: " + targetProtein(74.8) + "g");
        System.out.println("Target Fat: " + targetFat(dailyCals(bmr, 1.5)) + "g");
        System.out.println("Target Carbs: " + targetCarbs(dailyCals(bmr, 1.5),
                targetProtein(74.8), targetFat(dailyCals(bmr, 1.5))) + "g");
    }

}
