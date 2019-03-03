package Model;


import java.sql.Date;

public class Goal {

    private String user;
    private String description;
    private boolean completed;
    private Date completionDate;

    public Goal(String user, String description, boolean completed, Date completionDate){
        this.user = user;
        this.description = description;
        this.completed = completed;
        this.completionDate = completionDate;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Date getCompletionDate() {
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

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public String toString(){

        return description;
    }
}
