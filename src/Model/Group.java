package Model;

import sun.plugin2.message.Message;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Group {

    private ArrayList<User> members;
    private Goal groupGoal;
    private String groupName;

    public Group(ArrayList<User> members, Goal groupGoal, String groupName){
        this.members = members;
        this.groupGoal = groupGoal;
        this.groupName = groupName;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
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
        this.members.add(user);
    }

    //delete the users membership from the group
    //update the array and return true if successful
    public boolean deleteMembership(User user){

        if (this.members.contains(user)){
            this.members.remove(user);
                return true;
            }

        return false;

    }

    protected String randomString() {

        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            random.append(CHARS.charAt(index));
        }
        String randomString = random.toString();
        return randomString;

    }

    public void sendGroupDetails(User sender, User recipient) throws MessagingException {

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication( "2d962aa3c7a979", "27b172431ebc56");
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender.getEmail()));
        message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(recipient.getEmail()));
        message.setSubject(this.getGroupName() + " has invited you to join their group!");



        String msg = "GROUP DETAILS \n \n Group name: " + this.getGroupName() +
                "\nMembers: " + this.getMembers() + "\n Group Goal: " + this.getGroupGoal() +
                "\n\n If you would like to join this group, paste the code below " +
                "into the prompt box when pressing 'Join Group'." + "\n\n" + randomString();

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);
        Transport.send(message);

    }

    public void sendGoalCompletedEmail(User sender, User recipient) throws MessagingException{

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication( "2d962aa3c7a979", "27b172431ebc56");
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender.getEmail()));
        message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(recipient.getEmail()));
        message.setSubject("GOAL COMPLETED!");



        String msg = "GOAL COMPLETED!\n\n" + "Congratulations! Your group has met their goal." +
                "Goal details: \n" + this.getGroupGoal();

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);
        Transport.send(message);

    }

    public static void main(String args[]) throws IOException {

        User amy = new User("amyPryor");
        amy.setFirstName("Amy");
        amy.setLastName("Pryor");
        amy.setEmail("amy.a.p@hotmail.com");

        User tom = new User("tomDavey");
        tom.setFirstName("Tom");
        tom.setLastName("Davey");

        User jamie = new User("jamieGreasley");
        jamie.setFirstName("Jamie");
        jamie.setLastName("Greasley");

        Date goalDate = new Date(2019, 8,3);
        Goal groupGoal = new Goal(-10, goalDate, 82.0);
        ArrayList<User> mem = new ArrayList<>();
        mem.add(amy);
        mem.add(jamie);
        mem.add(tom);

        Group group = new Group(mem, groupGoal, "Group 1");
        group.joinGroup(jamie);
        group.deleteMembership(jamie);

        try {
            group.sendGroupDetails(amy, amy);
            group.sendGoalCompletedEmail(amy, amy);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
