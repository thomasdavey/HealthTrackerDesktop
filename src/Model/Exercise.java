package Model;

public class Exercise {

    private String name;
    public enum Type {
        STRENGTH,
        CARDIO
    }
    private Type type;
    private int calsBurnedPer5Mins;

    public Exercise(String name, Type type, int calsBurnedPer5Mins){
        this.name = name;
        this.type = type;
        this.calsBurnedPer5Mins = calsBurnedPer5Mins;
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

    public int getCalsBurnedPer5Mins() {
        return calsBurnedPer5Mins;
    }

    public void setCalsBurnedPer5Mins(int calsBurnedPer5Mins) {
        this.calsBurnedPer5Mins = calsBurnedPer5Mins;
    }

    public static void main(String args[]){

        Exercise walking = new Exercise("walking", Type.CARDIO, 15);

    }


}
