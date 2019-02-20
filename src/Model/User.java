package Model;

import java.util.ArrayList;

public class User extends Profile {

    private int height;
    private int weight;
    private int bmi;
    private double tee;     // ?
    private ArrayList<Goal> goals;

    public void addGoal(Goal g){
        goals.add(g);
    }

    public void removeGoal(Goal g){
        goals.remove(g);
    }

}
