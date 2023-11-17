package p3_SelectTabella.es2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/es3_newdb", "developer",
                    "dev.1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " - " + resultSet.getString("country"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
