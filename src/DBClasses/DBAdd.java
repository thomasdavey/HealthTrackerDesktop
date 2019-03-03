package DBClasses;

import Model.Food;
import Model.Goal;
import Model.User;

import java.sql.*;
import java.util.Calendar;

public final class DBAdd extends DBAccess{

    private DBAdd(){

    }

    public static void addUser(User u){

        getConnection();
        try {
            st.executeUpdate("INSERT INTO PROFILE VALUES ('"+u.getUserName()+"', '"+u.getPassword()+"', '"
                    +u.getFirstName()+"', '"+u.getLastName()+"', '"+u.getEmail()+"', 1)");
            st.executeUpdate("INSERT INTO USER VALUES ('"+u.getUserName()+"', "+u.getHeight()+", "
                    +u.getWeight()+", "+u.getBmi()+", "+u.getAge()+", "+u.getSex()+", "+u.getActivityLevel()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();

    }

    public static void addFood(Food f){
        getConnection();
        try {
            st.executeUpdate("INSERT INTO FOODS VALUES ('"+f.getName()+"', "+f.getKcals()+", "
                    +f.getProtein()+", "+f.getCarbs()+", "+f.getFat()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void addGoal(String id, Goal g){
        getConnection();
        try {
            st.executeUpdate("INSERT INTO GOALS VALUES ('"+id+"', " +g.getTargetWeightLoss()
                    +", '"+g.getTargetDate()+"', "+g.isCompleted()+", " +g.isActive()+", "+g.getStartDays()+
                    ", "+g.getWeightLossProgress()+", "+g.getPercentLost()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void addCalories(String u, Date d, int c){
        getConnection();
        try {
            st.executeUpdate("INSERT INTO CALORIECOUNTS VALUES ('"+u+"', '"+d+"', "+c+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void updateCalories(String u, int c){
        getConnection();
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        try {
            st.executeUpdate("UPDATE CALORIECOUNTS SET KCALS = KCALS + "
                    +c+" WHERE USERNAME = '"+u+"' AND DATE = '"+date+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }

    public static void main(String[] args) {



    }

}
