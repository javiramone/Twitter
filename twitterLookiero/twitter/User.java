package twitter;

import java.util.ArrayList;
import java.util.List;

public class User {
    
    String name;
    List <Message> messages;
    Wall wall;
    List <User> follows;
    
    public User(){
        
    }
    
    public User (String name){
        this.name = name;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        if (messages == null){
            this.messages = new ArrayList<Message>();
        }
        return messages;
    }

    public void setMessages(List<Message> message) {
        this.messages = message;
    }

    public Wall getWall() {
        if (wall == null){
            wall = new Wall();
        }
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public List<User> getFollows() {
        if (follows == null){
            follows = new ArrayList<User>();
        }
        return follows;
    }

    public void setFollows(List<User> follows) {
        this.follows = follows;
    }


}
