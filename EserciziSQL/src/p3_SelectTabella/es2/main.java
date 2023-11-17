package p3_SelectTabella.es2;

import java.sql.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/es2_newdb", "developer",
                    "dev.1234");
            Statement statement = connection.createStatement();

            String createCountry = "ALTER TABLE students " + "ADD country varchar(30)";

            String setCountry1 = "UPDATE `es2_newdb`.`students` SET `country`='Italy' WHERE `id_student`=1;" ;
            String setCountry2 = "UPDATE `es2_newdb`.`students` SET `country`='Italy' WHERE `id_student`=2;" ;
            String setCountry3 = "UPDATE `es2_newdb`.`students` SET `country`='Germany' WHERE `id_student`=3;";
            String setCountry4 = "UPDATE `es2_newdb`.`students` SET `country`='Germany' WHERE `id_student`=4;" ;
            statement.executeUpdate(createCountry);
            statement.executeUpdate(setCountry1);
            statement.executeUpdate(setCountry2);
            statement.executeUpdate(setCountry3);
            statement.executeUpdate(setCountry4);

            ResultSet resultSet = statement.executeQuery("select first_name, country from students");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name") + " - " + resultSet.getString("country"));
            }
        } catch (SQLException e ){
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
