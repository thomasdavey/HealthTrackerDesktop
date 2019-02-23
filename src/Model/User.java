package Model;

import java.util.ArrayList;

public class User extends Profile {

    private int height;
    private int weight;
    private int bmi;
    private int age;
    private ArrayList<Goal> goals;

    public void addGoal(Goal g){
        goals.add(g);
    }

    public void removeGoal(Goal g){
        goals.remove(g);
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
    public String toString(){

        StringBuilder s = new StringBuilder();
        s.append(super.toString()).append("\n").append("Age: ").append(age).append("\n");
        s.append("Height: ").append(height).append(" - Weight: ").append(weight).append(" - BMI: ").append(bmi);


        return s.toString();
    }
}
