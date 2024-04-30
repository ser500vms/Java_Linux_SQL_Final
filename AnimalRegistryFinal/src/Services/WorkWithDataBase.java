package Services;

import Model.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Scanner;

public class WorkWithDataBase {
    private Statement sqlSt;
    private String SQLstr;
    private ResultSet resultSet;

    private Methods methods = new Methods();

    public void getAllAnimals() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {
                sqlSt = dbConnection.createStatement();
                SQLstr = "SELECT * FROM Животные";
                resultSet = sqlSt.executeQuery(SQLstr);
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String typeOfAnimal = resultSet.getString(2);
                    String name = resultSet.getString(3);
                    LocalDate birthday = resultSet.getDate(4).toLocalDate();
                    String comand = resultSet.getString(5);
                    String packOrHome = resultSet.getString(6);
                    System.out.printf("%d. %s; %s; %s; %s; %s \n", id, typeOfAnimal, name, birthday, comand, packOrHome);
                }
            }
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/Resources/database.properties")) {

            props.load(fis);
            String url = props.getProperty("url");
            String login = props.getProperty("login");
            String password = props.getProperty("password");

            return DriverManager.getConnection(url, login, password);
        }
    }

    public void addNewAnimal() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String[] animal = methods.chooseAnimal();
            if (animal.length == 0){
                return;
            }
            String name = animal[0];
            String birthday = animal[1];
            String type = animal[2];
            String PackOrHome = animal[3];
            try (Connection dbConnection = getConnection()) {
                sqlSt = dbConnection.createStatement();
                SQLstr = "INSERT INTO Животные(type, name, birthday, packOrHome) VALUES ('" + type + "', '" + name +
                        "', '" + birthday + "', '" + PackOrHome + "')";
                sqlSt.executeUpdate(SQLstr);
            }
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void trainAnimal() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Scanner in = new Scanner(System.in);
            System.out.println("Введите команду или команды");
            String comand = in.nextLine();
            System.out.println("Введите id животного для обучения");
            int animalId = in.nextInt();
            try (Connection dbConnection = getConnection()) {
                sqlSt = dbConnection.createStatement();
                SQLstr = "UPDATE Животные SET Comands = '" + comand + "' WHERE Id = " + animalId;
                sqlSt.executeUpdate(SQLstr);
            }
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void findAnimal() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Scanner in = new Scanner(System.in);
            System.out.println("Введите id животного для просмотра его умений");
            int animalId = in.nextInt();
            try (Connection dbConnection = getConnection()) {
                sqlSt = dbConnection.createStatement();
                SQLstr = "SELECT comands FROM Животные WHERE id = " + animalId;
                resultSet = sqlSt.executeQuery(SQLstr);
                while (resultSet.next()) {
                    String comand = resultSet.getString("comands");
                    if (comand == null){
                        comand = "Животное ничего не умеет";
                    }
                    System.out.printf(comand);
                }
            }
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


    public void deleteAnimal(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Введите id животного для удаления\n");
            Scanner in = new Scanner(System.in);
            int animalId = in.nextInt();
            try (Connection dbConnection = getConnection()) {
                sqlSt = dbConnection.createStatement();
                SQLstr = "DELETE FROM Животные WHERE id = " + animalId;
                sqlSt.executeUpdate(SQLstr);
            }
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
