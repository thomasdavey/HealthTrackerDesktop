package View;

import DBClasses.DBAdd;
import DBClasses.LoadUser;

import java.sql.Date;

public class test {

    public static void main(String[] args) {
        DBAdd.addCalories("rodney", new Date(119,2,2), 2089);
        DBAdd.addCalories("rodney", new Date(119,2,1), 1977);
        DBAdd.addCalories("rodney", new Date(119,1,28), 2293);
        DBAdd.addCalories("rodney", new Date(119,1,27), 1895);
    }
}