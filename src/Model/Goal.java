package Model;


public class Goal {

    private String user;
    private String description;
    private boolean completed;
    private String completionDate;
    private double weightLossKG;
    private Date targetDate;

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public double getWeightLossKG(){ return weightLossKG;}

    public void setWeightLossKG(int weightLossKG){this.weightLossKG = weightLossKG;}

    public Date getTargetDate() {return targetDate; }

    public void setTargetDate(Date targetDate) { this.targetDate = targetDate; }


    @Override
    public String toString(){

        return description;
    }
}
