package ru.dexsys;

import java.net.URI;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String USERNAME = "dexautomation";
    private static final String PASSWORD = "dexautomation";
    private static final String URL = "jdbc:mysql://db4free.net:3306/dexautomation";
    //"jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC";
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver driver;
        try {
            driver = new com.mysql.cj.jdbc.Driver();
        }
        catch (SQLException ex){
            System.out.println("ошибка при создании драйвера");
            return;
        }
        try {
            DriverManager.registerDriver(driver);
        }
        catch ( SQLException ex){
            System.out.println("не удалось зарегистрировать драйвер");
            return;
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
            System.out.println("code... ");
        }
         catch (SQLException ex){
             System.out.println("не удалось соединение");
             return;
         }
finally {
            if (connection !=null)
                connection.close();
        }
    }
}
