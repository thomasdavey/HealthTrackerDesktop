package DBClasses;


import Model.Goal;
import Model.User;

import java.sql.*;
import java.util.ArrayList;

public class LoadUser extends DBAccess {

    private User u;

    private String userName, password, firstName, lastName, email;
    private boolean active;

    private int height, weight, bmi, age;
    private ArrayList<Goal> goals;

    public LoadUser(String un) {
        goals = new ArrayList<>();
        populateData(un);

        u = new User(userName);
        u.setPassword(password);
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setActive(active);

        u.setHeight(height);
        u.setWeight(weight);
        u.setBmi(bmi);
        u.setAge(age);

        for (Goal g : goals) {
            u.addGoal(g);
        }

    }

    public User getUser() {
        return u;
    }

    private void populateData(String userName) {

        this.userName = userName;


        getConnection();

        // Profile Data
        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT * FROM PROFILE WHERE USERNAME ='" + this.userName + "'");

            rs.next();
            this.password = rs.getString(2);
            this.firstName = rs.getString(3);
            this.lastName = rs.getString(4);
            this.email = rs.getString(5);
            this.active = rs.getBoolean(6);

            // User Data
            rs = st.executeQuery("SELECT * FROM USER WHERE USERNAME ='" + this.userName + "'");
            rs.next();
            this.height = rs.getInt(2);
            this.weight = rs.getInt(3);
            this.bmi = rs.getInt(4);
            this.age = rs.getInt(5);

            // Goals
            rs = st.executeQuery("SELECT * FROM GOALS WHERE USERNAME ='" + this.userName + "'");
            while (rs.next()) {
                //Goal g = new Goal(this.userName, rs.getString(2), rs.getBoolean(3), rs.getDate(4));
                //goals.add(g);
            }

            closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static int getCaloriesByDate(String u, Date d){
        ResultSet rs = null;
        int kcals = 0;
        getConnection();

        try {
            rs = st.executeQuery("SELECT KCALS FROM CALORIECOUNTS WHERE USERNAME = '"
                    +u+"' AND DATE = '"+d+"'");
            rs.next();
            kcals = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return kcals;
    }

    public static void main(String[] args) {

        User user = new LoadUser("imacpro").getUser();
        System.out.println(user.getUserName());
        System.out.println(user.toString());
        System.out.println(user.getGoals());

        int rodneyCals = getCaloriesByDate("rodney", new Date(119, 1, 23));
        System.out.println(rodneyCals);

    }

}
