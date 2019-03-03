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

    /*public static void addGoal(Goal g){
        getConnection();
        try {
            st.executeUpdate("INSERT INTO GOALS VALUES ('"+g.getUser()+"', '"
                    +g.getDescription()+"', "+g.isCompleted()+", '"+g.getCompletionDate()+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }*/

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

//        // Test adding a user
//        User Rodney = new User("rodney");
//        Rodney.setPassword("rodders123");
//        Rodney.setFirstName("rodney");
//        Rodney.setLastName("trotter");
//        Rodney.setEmail("r.trotter@msn.com");
//        Rodney.setActive(true);
//        Rodney.setHeight(167);
//        Rodney.setWeight(68);
//        Rodney.setBmi(19);
//        Rodney.setAge(32);
//
//        System.out.println(Rodney);
//        addUser(Rodney);

//        // Test adding a food
//        Food bacon = new Food("bacon", 65, 20, 2, 15, 1);
//        System.out.println(bacon);
//        addFood(bacon);

//        // Test adding goal
//        Goal goal = new Goal(Rodney.getUserName(), "Lose my fatty belly",
//                true, new Date(119, 0, 15));
//        System.out.println(goal);
//        addGoal(goal);

//        // Test adding calorie counts
//        addCalories("ladyinred", new Date(119, 1, 20), 1500);
//        addCalories("ladyinred", new Date(119, 1, 21), 910);
//        addCalories("ladyinred", new Date(119, 1, 22), 1400);
//        addCalories("ladyinred", new Date(119, 1, 23), 1200);
//        addCalories("ladyinred", new Date(119, 1, 24), 1330);
//        addCalories("ladyinred", new Date(119, 1, 25), 1060);
//        addCalories("ladyinred", new Date(119, 1, 26), 1333);

        updateCalories("rodney", 10);


    }

}
