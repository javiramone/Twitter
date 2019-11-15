package twitter;

public class Command {
    
    String user;
    String action;
    String user2;
    String text;
    
    boolean isRead = false;
    boolean isWall = false;
    boolean isFollow = false;
    boolean isPost = false;
    
    public Command(){
        
    }
    
    public Command (String command){
        this.user = command.split(" ")[0];
        if(command.split(" ").length > 1){
            this.action = command.split(" ")[1];
            if ("->".equals(this.action)){
                isPost = true;
              this.text = command.substring(command.indexOf('>')+1);
            } else if ("follows".equals(this.action)){
                isFollow = true;
                this.user2 = command.split(" ")[2];
            } else if ("wall".equals(this.action)){
                isWall = true;
            }
        } else {
            isRead = true;
        }
    }

    public String getUser() {
        return user.substring(0, 1).toUpperCase() + user.substring(1);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean isWall() {
        return isWall;
    }

    public void setWall(boolean isWall) {
        this.isWall = isWall;
    }

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean isFollow) {
        this.isFollow = isFollow;
    }

    public boolean isPost() {
        return isPost;
    }

    public void setPost(boolean isPost) {
        this.isPost = isPost;
    }

    public String printCommand(){
        if (this.isFollow){
            return this.user + " follows " + this.user2;
        } else if (this.isPost){
            return this.user + " -> " + this.text;
        } else if (this.isRead){
            return this.user;
        } else if (this.isWall){
            return this.user + " wall";
        } else {
            return " --- ACTION WRONG --- ";
        }
    }
}
