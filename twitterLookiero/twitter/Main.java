package twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    
    public static final Map<String, User> usuariosSesion = new HashMap<String, User>();

    public static void leerConsola () throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Command comando = new Command(reader.readLine());

        if (comando.isPost()){
            doPost(comando);
        }
        if (comando.isRead()){
            doRead(comando);
        }
        if (comando.isFollow){
            doFollow(comando);
        }
        if (comando.isWall){
            doWall(comando);
        }
    }

    private static void doPost(Command comando) {
        checkUserSession (comando);
        Message message = new Message(comando.getText(), comando.getUser());
        usuariosSesion.get(comando.getUser().toUpperCase()).getMessages().add(message);
        usuariosSesion.get(comando.getUser().toUpperCase()).getWall().getMessage().add(message);
    }
    
    private static void doRead(Command comando) {
        checkUserSession (comando);
        List<Message> listaMsg =  usuariosSesion.get(comando.getUser().toUpperCase()).getMessages();
        Collections.sort(listaMsg, Collections.reverseOrder());
        for (Message msg:listaMsg){
            System.out.println(msg.printMessageRead());
        }
    }
    
    private static void doFollow(Command comando) {
        checkUserSession (comando);
        if (usuariosSesion.get(comando.getUser2().toUpperCase()) == null){
            System.out.println("No existe el usuario -> "+comando.getUser2());
        } else {
            User userToFollow = usuariosSesion.get(comando.getUser2().toUpperCase());
            List<User> listaFollows =  userToFollow.getFollows();
            for (User usr:listaFollows){
                usuariosSesion.get(comando.getUser().toUpperCase()).getFollows().add(usr);
            }
        }
    }
    
    private static void doWall(Command comando) {
        checkUserSession (comando);
        List<User> listaFollows =  usuariosSesion.get(comando.getUser().toUpperCase()).getFollows();
        List<Message> listaMsg =  new ArrayList<Message>();
        for (User usr:listaFollows){
            Wall wall =  usr.getWall();
            for (Message msg:wall.getMessage()){
                listaMsg.add(msg);
            }
        }
        Collections.sort(listaMsg, Collections.reverseOrder());
        for (Message msg:listaMsg){
            System.out.println(msg.printMessageWall());
        }
    }
    
    private static void checkUserSession (Command comando){
        if (usuariosSesion.get(comando.getUser().toUpperCase()) == null){
            usuariosSesion.put(comando.getUser().toUpperCase(), new User(comando.getUser()));
            usuariosSesion.get(comando.getUser().toUpperCase()).getFollows().add(usuariosSesion.get(comando.getUser().toUpperCase()));
        }  
    }

    public static void main(String[] args) throws IOException {
        System.out.println("### WELCOME ###");
        while (true){
            leerConsola();
        }
    }

}
