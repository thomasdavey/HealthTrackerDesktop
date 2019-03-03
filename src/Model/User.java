package Model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class User extends Profile {

    private String userName;
    private int sex;           // Male = 0, Female = 1
    private int height;
    private double weight;
    private double activityLevel;
    private int bmi;
    private int age;
    private LocalDate dob;
    private ArrayList<Goal> goals;

    public User(String userName) {
        this.userName = userName;
        goals = new ArrayList<>();
    }

    public void addGoal(Goal g) {
        goals.add(g);
    }

    public void removeGoal(Goal g) {
        goals.remove(g);
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setActivityLevel(double activityLevel) {
        this.activityLevel = activityLevel;
    }

    public void setBmi(int bmi) {
        this.bmi = bmi;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDob(LocalDate birth) {
        this.dob = birth;
        this.age = Period.between(birth, LocalDate.now()).getYears();
    }

    public String getUserName(){
        return userName;
    }

    public int getSex() {
        return this.sex;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getActivityLevel() {
        return this.activityLevel;
    }

    public int getBmi() {
        return bmi;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        String s = super.toString() + "\n" + "Age: " + age + "\n" +
                "Height: " + height + " - Weight: " + weight + " - BMI: "
                + bmi +" - Sex: "+ sex + " - Activity Level: "+activityLevel;
        return s;
    }
}
