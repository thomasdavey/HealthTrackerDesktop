package Model;

public abstract class Profile {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;

    public void activateProfile(){
        active = true;
    }

    public void deactivateProfile(){
        active = false;
    }

    public boolean isActive(){
        return active;
    }

}
