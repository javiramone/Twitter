package twitter;

import java.util.Date;

public class Message implements Comparable<Message>{
    
    String text;
    String user;
    String wall;
    Date date;
    
    public Message(){
        
    }
    
    public Message (String text, String user){
        this.text = text;
        this.user = user;
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user.substring(0, 1).toUpperCase() + user.substring(1);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getTimeLapsed(){
        Date dateAct = new Date();
        Long millis = dateAct.getTime() - this.date.getTime();
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;
        if (hour > 0){
            return hour + " hours ago";
        } else if (minute > 0){
            return minute + " minutes ago";
        } else {
            return second + " seconds ago";
        } 
    }

    public String printMessageWall (){
        return this.user + " - " + this.text + " ("+getTimeLapsed()+")";
    }
    
    public String printMessageRead (){
        return  this.text + " ("+getTimeLapsed()+")";
    }
    
    @Override
    public int compareTo(Message msg) {
      return this.getDate().compareTo(msg.getDate());
    }
}
