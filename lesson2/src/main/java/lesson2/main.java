package lesson2;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        AuthService.connect();
        AuthService.CreateWorker();
        AuthService.InsertWorker();
        AuthService.SelectWorker();
        AuthService.updateWorker();
        AuthService.SelectWorker();
        AuthService.DeleteWorker();
        AuthService.disconnect();
    }
}
