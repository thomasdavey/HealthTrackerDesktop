package Model;

public class Message {

    private String user;
    private String name;
    private String message;

    public Message(String user, String name, String message) {
        this.user = user;
        this.name = name;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
