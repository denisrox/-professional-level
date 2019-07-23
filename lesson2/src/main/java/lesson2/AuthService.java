package lesson2;

import java.sql.*;

public class AuthService {

    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:worker.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String CreateWorker() {
        String sql = String.format("CREATE TABLE worker (id INTEGER PRIMARY KEY UNIQUE,name STRING,position STRING)");
        try {
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery("SELECT* FROM worker");
            ResultSetMetaData rsmd = rs.getMetaData();
            String name = "Создана новая таблица worker. Её поля:\n"+rsmd.getColumnName(1)+"|"+rsmd.getColumnName(2);
            System.out.println(name);

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
    public static void DeleteWorker()
    {
        String sql = String.format("DROP TABLE worker");
        try {
            stmt.executeUpdate(sql);
            System.out.println("удаление таблицы.");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void updateWorker(){
        String sql = String.format("UPDATE worker SET name = 'Smith' WHERE id = 1;");
        try {
            stmt.executeUpdate(sql);
            System.out.println("Изменили таблицу.");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void InsertWorker(){

        try {
            for(int i = 0;i<5;i++) {
                stmt.executeUpdate("INSERT INTO worker(name,position) VALUES('worker"+i+"', 'engeneer')");
            }

            System.out.println("добавили 5 значений в таблицу.");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void SelectWorker(){
        String sql="SELECT * FROM worker";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void disconnect() {
        try {
            // закрываем соединение
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}