package DBClasses;

import Model.Food;
import Model.Goal;
import Model.User;

import java.sql.*;

public final class DBAdd extends DBAccess{

    private static Connection conn;
    private static Statement stat;

    private DBAdd(){

    }

    @SuppressWarnings("Duplicates")
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

    public static void AddUser(User u){

        getConnection();
        try {
            stat.executeUpdate("INSERT INTO PROFILE VALUES ('"+u.getUserName()+"', '"+u.getPassword()+"', '"
                    +u.getFirstName()+"', '"+u.getLastName()+"', '"+u.getEmail()+"', 1)");
            stat.executeUpdate("INSERT INTO USER VALUES ('"+u.getUserName()+"', "+u.getHeight()+", "
                    +u.getWeight()+", "+u.getBmi()+", "+u.getAge()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();

    }

    public static void AddFood(Food f){
        getConnection();
        try {
            stat.executeUpdate("INSERT INTO FOODS VALUES ('"+f.getName()+"', "+f.getKcals()+", "
                    +f.getProtein()+", "+f.getCarbs()+", "+f.getFat()+", "+f.getSugar()+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void AddGoal(Goal g){
        getConnection();
        try {
            stat.executeUpdate("INSERT INTO GOALS VALUES ('"+g.getUser()+"', '"
                    +g.getDescription()+"', "+g.isCompleted()+", '"+g.getCompletionDate()+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public static void main(String[] args) {

        // Test adding a user
        User Rodney = new User("rodney");
        Rodney.setPassword("rodders123");
        Rodney.setFirstName("rodney");
        Rodney.setLastName("trotter");
        Rodney.setEmail("r.trotter@msn.com");
        Rodney.setActive(true);
        Rodney.setHeight(167);
        Rodney.setWeight(68);
        Rodney.setBmi(19);
        Rodney.setAge(32);
//
//        System.out.println(Rodney);
//        AddUser(Rodney);

        // Test adding a food
//        Food bacon = new Food("bacon", 65, 20, 2, 15, 1);
//        System.out.println(bacon);
//        AddFood(bacon);

        // Test adding goal
        Goal goal = new Goal(Rodney.getUserName(), "Lose my fatty belly",
                true, new Date(119, 0, 15));
        System.out.println(goal);
        AddGoal(goal);
    }
}
