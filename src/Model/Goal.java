package Model;

import java.util.Calendar;
import java.util.Date;

public class Goal {

    //private User user;
    //private String description;
    private double weightLossKG;
    private Date targetDate;
    private boolean completed;

    static Date today = Calendar.getInstance().getTime();

    public Goal(double weightLossKG, Date targetDate){

        //making sure the user cannot set the target date to today or the past
        long difference = targetDate.getTime() - today.getTime();
        double daysBetween = (difference / (1000*60*60*24));

        if (daysBetween > 0){
            this.targetDate = targetDate;
        }
        else {
            System.out.println("Please select a target date in the future");
            return;
        }

        this.weightLossKG = weightLossKG;
        this.completed = false;
    }


    public boolean isCompleted() {

        return completed;
    }

    public void setCompleted(boolean completed) {

        this.completed = completed;
    }

    public double getWeightLossKG(){ return
            weightLossKG;}

    public void setWeightLossKG(int weightLossKG){
        this.weightLossKG = weightLossKG;}

    public Date getTargetDate() {
        return targetDate; }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate; }


    @Override
    public String toString(){

        String goalString = "Lose " + weightLossKG + "kg by " + targetDate;

        return goalString;
    }

    public static void main(String args[]){

    Goal myGoal = new Goal(10, today);

    }

}



