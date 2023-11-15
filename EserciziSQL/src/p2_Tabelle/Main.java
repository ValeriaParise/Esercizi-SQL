package p2_Tabelle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
        // Per connetterci al DB
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/es2_newdb", "root",
                    "orchidea57");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students");
            while(resultSet.next()){
                System.out.println(resultSet.getString("last_name") +" " + resultSet.getString("first_name"));
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
}