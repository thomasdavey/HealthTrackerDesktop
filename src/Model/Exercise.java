package Model;

public class Exercise {

    private String name;
    public enum Type {
        STRENGTH,
        CARDIO
    }
    private Type type;
    private double calPerMin;
    private String username;

    public Exercise(String name, Type type, double calPerMin){
        this.name = name;
        this.type = type;
        this.calPerMin = calPerMin;
    }

    public Exercise(String name, Type type, double calPerMin, String username){
        this.name = name;
        this.type = type;
        this.calPerMin = calPerMin;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getCalPerMin() {
        return calPerMin;
    }

    public void setCalPerMin(double calsBurnedPer5Mins) {
        this.calPerMin = calsBurnedPer5Mins;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String u) {
        this.username = u;
    }

    public static void main(String args[]){

        Exercise walking = new Exercise("walking", Type.CARDIO, 15);

    }


}
