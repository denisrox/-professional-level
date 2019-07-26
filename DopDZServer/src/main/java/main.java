import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class main {
    public static void main(String[] args) {

        try {
            ServerSocket server= new ServerSocket(3345);
            Socket client = server.accept();
            ObjectInputStream in=new ObjectInputStream(client.getInputStream());
            Player player = (Player) in.readObject();
            player.showInfo();

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
