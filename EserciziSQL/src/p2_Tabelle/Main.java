package p2_Tabelle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // Per connetterci al DB
        Connection connection = null;
        try{
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/es2_newdb", "developer", "dev.1234");
             Statement statement = connection.createStatement();

             String createTab = "CREATE TABLE `es2_newdb`.`students` (" +
                                " `id_student` INT NOT NULL AUTO_INCREMENT," +
                                "`last_name` VARCHAR(30)," +
                                "`first_name` VARCHAR(30)," +
                                "PRIMARY KEY (`id_student`))";

            statement.executeUpdate(createTab);

             String ins1 = "INSERT INTO `students` (`id_student`, `last_name`, `first_name`) VALUES (1, 'De Luca', 'Francesco')";
             String ins2 = "INSERT INTO `students` (`id_student`, `last_name`, `first_name`) VALUES (2, 'De Simone', 'Luca')";
             String ins3 = "INSERT INTO `students` (`id_student`, `last_name`, `first_name`) VALUES (3, 'Verdi', 'Gaia')";
             String ins4 = "INSERT INTO `students` (`id_student`, `last_name`, `first_name`) VALUES (4, 'Rossi', 'Marco')";

             statement.executeUpdate(ins1);
             statement.executeUpdate(ins2);
             statement.executeUpdate(ins3);
             statement.executeUpdate(ins4);

            ResultSet resultSet = statement.executeQuery("select * from students");
            while(resultSet.next()){
                System.out.println(resultSet.getString("last_name") +" " +
                        resultSet.getString("first_name"));
            }
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