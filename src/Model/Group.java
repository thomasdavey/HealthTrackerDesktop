package Model;

import java.util.Arrays;
import java.util.Date;

public class Group {

    private User[] members;
    private Goal groupGoal;
    private String groupName;

    public Group(User[] members, Goal groupGoal, String groupName){
        this.members = members;
        this.groupGoal = groupGoal;
        this.groupName = groupName;
    }

    public User[] getMembers() {
        return members;
    }

    public void setMembers(User[] members) {
        this.members = members;
    }

    public Goal getGroupGoal() {
        return groupGoal;
    }

    public void setGroupGoal(Goal groupGoal) {
        this.groupGoal = groupGoal;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void joinGroup(User user){
        Arrays.copyOf(this.members, this.members.length + 1);
        this.members[this.members.length - 1] = user;
    }

    //delete the users membership from the group
    //update the array and return true if successful
    public boolean deleteMembership(User user){

        for (int i = 0; i < this.members.length; i++){
            if (user.equals(this.members[i])){
                this.members[i] = null;
                for (int j = i + 1; j < this.members.length; j++){
                    this.members[j-1] = this.members[j];
                }
                Arrays.copyOf(this.members, this.members.length - 1);
                return true;
            }
        }

        return false;

    }

    public static void main(String args[]){

        User amy = new User("amyPryor");
        amy.setFirstName("Amy");

        User tom = new User("tomDavey");
        tom.setFirstName("Tom");

        User jamie = new User("jamieGreasley");
        jamie.setFirstName("Jamie");

        Date goalDate = new Date(2019, 8,3);
        Goal groupGoal = new Goal(-10, goalDate);
        User[] mem = {amy, tom};

        Group group = new Group(mem, groupGoal, "group1");
        group.joinGroup(jamie);
        group.deleteMembership(jamie);

    }

}
