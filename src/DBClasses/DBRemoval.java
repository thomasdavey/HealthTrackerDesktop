package DBClasses;

import Model.Food;
import Model.Goal;
import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBRemoval extends DBAccess {

    private static Connection conn;
    private static Statement stat;

    private DBRemoval(){

    }

    private static void getConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, UN, PW);
            stat = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection(){
        try {
            conn.close();
            stat.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeUser(User u){
        removeAllGoals(u);
        getConnection();
        try {
            stat.executeUpdate("DELETE FROM USER WHERE USERNAME ='"+u.getUserName()+"'");
            stat.executeUpdate("DELETE FROM PROFILE WHERE USERNAME ='"+u.getUserName()+"'");
            System.out.println("User: "+u.getUserName()+" removed from database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void removeFood(Food f){
        getConnection();
        try {
            stat.executeUpdate("DELETE FROM FOODS WHERE NAME = '"+f.getName()+"'");
            System.out.println("Food "+f.getName()+" removed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void removeGoal(User u, Goal g){
        getConnection();
        try {
            stat.executeUpdate("DELETE FROM GOALS WHERE USERNAME ='"
                    +u.getUserName()+"' AND DESCRIPTION ='"+g.getDescription()+"'");
            System.out.println("Goal: "+g+" removed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void removeAllGoals(User u){
        getConnection();
        try {
            stat.executeUpdate("DELETE FROM GOALS WHERE USERNAME = '"+u.getUserName()+"'");
            System.out.println("All goals for user: "+u.getUserName()+" removed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void main(String[] args) {
        User user = new LoadUser("pandapaul").getUser();
        DBRemoval.removeUser(user);
    }

}
