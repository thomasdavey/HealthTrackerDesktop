package Model;

import java.util.ArrayList;

public class User extends Profile {

    private int height;
    private int weight;
    private int bmi;
    private int age;
    private ArrayList<Goal> goals;

    public User() {
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

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBmi(int bmi) {
        this.bmi = bmi;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String s = super.toString() + "\n" + "Age: " + age + "\n" +
                "Height: " + height + " - Weight: " + weight + " - BMI: " + bmi;
        return s;
    }
}
