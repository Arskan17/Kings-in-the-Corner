package main.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    static String id = "";
    static int n = 1; //counts the number of rows/users/enterties in the Database
    public static void main(String[] args) throws SQLException{
        //Data to set connection to SQLServer
        String url = "jdbc:mysql://localhost:3306/sep";
        String uname = "root";
        String pass = "uiop";
        String queryGet = "select * from UserData";
//        String querySet = "Insert into UserData values (6, 'jumboy', 'jeta')";

        //Verifies that the connection to jdbc works properly
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        //Get data from Database
        try{
            Connection connection = DriverManager.getConnection(url, uname, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryGet);

            while (resultSet.next()){
                String uData = "";

                for(int i = 1; i <= 3; i++){
                    uData += resultSet.getString(i) + ":";
                }
                System.out.println(uData);
                n++;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        id = String.valueOf(n);
//        System.out.println(querySet);

        String querySet = "Insert into UserData values (" + id + ", 'miike', 'Ross')";

        //Set data to Database
        try{
            Connection connection = DriverManager.getConnection(url, uname, pass);
            Statement statement = connection.createStatement();
            statement.executeUpdate(querySet);

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
