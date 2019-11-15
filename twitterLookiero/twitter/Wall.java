package twitter;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    
    String user;
    List <Message> message;
    
    public Wall(){
        
    }
    
    public Wall (String user){
        this.user = user;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Message> getMessage() {
        if (message == null){
            message = new ArrayList <Message>();
        }
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public String printWall(){
        //TODO: mostrar todos los mensajes
        return "";
    }
}
