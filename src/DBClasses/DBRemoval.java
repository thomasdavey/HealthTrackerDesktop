package DBClasses;

import Model.Food;
import Model.Goal;
import Model.User;

import java.sql.SQLException;

public final class DBRemoval extends DBAccess {

    private DBRemoval(){

    }

    public static void removeUser(User u){
        removeAllGoals(u);
        getConnection();
        try {
            st.executeUpdate("DELETE FROM USER WHERE USERNAME ='"+u.getUserName()+"'");
            st.executeUpdate("DELETE FROM PROFILE WHERE USERNAME ='"+u.getUserName()+"'");
            System.out.println("User: "+u.getUserName()+" removed from database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void removeFood(Food f){
        getConnection();
        try {
            st.executeUpdate("DELETE FROM FOODS WHERE NAME = '"+f.getName()+"'");
            System.out.println("Food "+f.getName()+" removed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void removeGoal(User u, Goal g){
        getConnection();
        try {
            st.executeUpdate("DELETE FROM GOALS WHERE USERNAME ='"
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
            st.executeUpdate("DELETE FROM GOALS WHERE USERNAME = '"+u.getUserName()+"'");
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
