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

    //method to calculate total energy expenditure


    //THIS METHOD IS NOT CORRECT YET
    //method that uses above two methods and desired weight loss/gain to calculate target calories
    //this must also calculate calorie deficit based on how extreme weight loss is
    //maybe give goal a numeric value that helps to calculate calories deficit.
    public static int targetCalories(double metabolicRate, double weightLoss){

        int targetCalories = 0;

        //weightloss given a value -5 to 5. negative values are for weight loss, positive for gain
        //-5 indicates a more extreme weight loss goal than -1
        int calorieDeficit = (int) (weightLoss*100);

        targetCalories = (int) (metabolicRate*1.15) - calorieDeficit;

        return targetCalories;
    }

    //optional methods to calculate target fat/carbs/protein/sugar

    //method calculating goal progress

    //method to predict when a user will meet their goal??

    //methods calculating daily net calories, and calories under budget

    public static void main(String args[]){

        //testing the methods with my measurements
        System.out.println("bmi: " + numFormat.format(bmi(74.8, 170)));
        System.out.println("ideal body weight: " + numFormat.format(idealBodyWeight(170, 'F')));
        double bmr = metabolicRate(74.8, 170, 19, 'F');
        System.out.println("bmr: " + numFormat.format(bmr));
        System.out.println("target calories: " + targetCalories(bmr, 3));

        //testing methods with toms measurements
        System.out.println("bmi: " + numFormat.format(bmi(77.4, 182)));
        System.out.println("ideal body weight: " + numFormat.format(idealBodyWeight(182, 'M')));
        double bmr2 = metabolicRate(77.4, 182, 20, 'M');
        System.out.println("bmr: " + numFormat.format(bmr2));
        System.out.println("target calories: " + targetCalories(bmr2, 3));

    }

}
