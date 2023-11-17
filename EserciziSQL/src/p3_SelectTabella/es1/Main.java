package p3_SelectTabella.es1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Per connetterci al DB
        try{
            ArrayList<String> surnames = new ArrayList<>();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/es3_newdb", "developer",
                    "dev.1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students");
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
                surnames.add(resultSet.getString("surname"));
            }
            System.out.println("Surnames:\n" + surnames);
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
}
