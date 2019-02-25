package DBClasses;


import Model.Goal;
import Model.User;

import java.sql.*;
import java.util.ArrayList;

public class LoadUser extends DBAccess {

    User u;

    private String userName, password, firstName, lastName, email;
    private boolean active;

    private int height, weight, bmi, age;
    private ArrayList<Goal> goals;

    public LoadUser(String un){
        goals = new ArrayList<>();
        populateData(un);

        u = new User();
        u.setPassword(password);
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setActive(active);

        u.setHeight(height);
        u.setWeight(weight);
        u.setBmi(bmi);
        u.setAge(age);

        for(Goal g: goals){
            u.addGoal(g);
        }

    }

    public User getUser(){
        return u;
    }

    private void populateData (String userName){

        this.userName = userName;

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, UN, PW);
            st = conn.createStatement();

            // Profile Data
            ResultSet rs = st.executeQuery("SELECT * FROM PROFILE WHERE USERNAME ='"+this.userName+"'");
            rs.next();
            this.password = rs.getString(2);
            this.firstName = rs.getString(3);
            this.lastName = rs.getString(4);
            this.email = rs.getString(5);
            this.active = rs.getBoolean(6);

            // User Data
            rs = st.executeQuery("SELECT * FROM USER WHERE USERNAME ='"+this.userName+"'");
            rs.next();
            this.height = rs.getInt(2);
            this.weight = rs.getInt(3);
            this.bmi = rs.getInt(4);
            this.age = rs.getInt(5);

            // Goals
            rs = st.executeQuery("SELECT * FROM GOALS WHERE USERNAME ='"+this.userName+"'");
            while(rs.next()){
                Goal g = new Goal();
                g.setUser(this.userName);
                g.setDescription(rs.getString(2));
                g.setCompleted(rs.getBoolean(3));
                g.setCompletionDate(rs.getString(4));
                goals.add(g);
            }

            conn.close();
            st.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        User user = new LoadUser("killacod").getUser();
        System.out.println(user.toString());
        System.out.println(user.getGoals());

    }

}
