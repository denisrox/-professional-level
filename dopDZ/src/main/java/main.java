import java.io.*;
import java.net.Socket;

public class main {
    public static void main(String[] args) {
        Player player = new Player(10, 5, 3.5);
        player.setLVL(5);
        player.damage(3);
        player.showInfo();

        try {
            Socket socket = new Socket("localhost", 3345);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
