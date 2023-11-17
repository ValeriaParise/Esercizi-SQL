package p3_SelectTabella.es1;

import java.sql.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList<String> cognome = new ArrayList<>();
        // Per connetterci al DB
        Connection connection = null;
        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/es2_newdb", "developer", "dev.1234");
             Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("select first_name, last_name from students");
            while(resultSet.next()){
                System.out.println(resultSet.getString("first_name"));
                cognome.add(resultSet.getString("last_name"));
            }
            System.out.println(cognome);
        }
        catch (SQLException e ){
            System.out.println((e.getMessage()));
        }finally {
            try {
                if (connection != null)
                {connection.close();}
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}