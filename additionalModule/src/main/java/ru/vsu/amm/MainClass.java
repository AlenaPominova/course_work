package ru.vsu.amm;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Additional module for imitating fill db by external systems
 * @author Alena Pominova
 * @version 1.0
 */
public class MainClass {
    private static String URL;
    private static String NAME;
    private static String PASSWORD;

    public static void main(String[] args) {
        int id, freeSpots, n = 0;

        URL = getProperty("url");
        NAME = getProperty("name");
        PASSWORD = getProperty("password");
        Connection connection = null;
        try {
            Class.forName(getProperty("driver"));
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet result1 = statement.executeQuery(Queries.SELECT_AMOUNT);
            while (result1.next()) {
                n = result1.getInt("amount");
            }

            while (true) {
                id = getId(n);
                freeSpots = getSpotsAmount();

                PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATE_SPOTS);
                preparedStatement.setInt(1, freeSpots);
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();

                System.out.println("update PP " + id);
                sleep(20000);
            }
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static String getProperty(String key){
        Properties prop = new Properties();
        try (InputStream fileInputStream = MainClass.class.getClassLoader().getResourceAsStream("db.properties")) {
            prop.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Error: file not found");
        }
        return prop.getProperty(key);
    }

    private static int getId(int n){
        Random random = new Random();
        return Math.abs(random.nextInt() % n) + 1;
    }

    private static int getSpotsAmount(){
        Random rand = new Random();
        return Math.abs(rand.nextInt() % 30);
    }
}