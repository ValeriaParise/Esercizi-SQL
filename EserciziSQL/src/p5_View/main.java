package p5_View;
import java.sql.*;
import java.util.ArrayList;
import java.sql.*;

public class main {
        public static void main(String[] args) {
            Connection connection = null;

            try {
                ArrayList<Student> italianStudents = new ArrayList<>();
                ArrayList<Student> germanStudents = new ArrayList<>();
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/es2_newdb", "developer",
                        "dev.1234");
                Statement statement = connection.createStatement();

                String createviewItaly = "CREATE VIEW italian_students " + "AS SELECT `students`.`last_name` , `students`.`first_name` " +
                        " FROM students " +
                        "WHERE `students`.`country` = 'Italy' ";
                //statement.execute(createviewItaly);
                ResultSet resultSetIT = statement.executeQuery("SELECT last_name, first_name FROM italian_students");
                while(resultSetIT.next()){
                    Student s1 = new Student(resultSetIT.getString("last_name"), resultSetIT.getString("first_name"));
                    italianStudents.add(s1);
                }
                System.out.println("Italian students:\n" + italianStudents);


                String createViewGerman = "CREATE VIEW german_students " + "AS SELECT `students`.`last_name` , `students`.`first_name`" +
                        " FROM students" +
                        " WHERE `students`.`country` = 'Germany' ";
                //statement.execute(createViewGerman);
                ResultSet resultSetGR = statement.executeQuery("SELECT first_name, last_name FROM german_students");
                while(resultSetGR.next()){
                    Student s2 = new Student(resultSetGR.getString("last_name"), resultSetGR.getString("first_name"));
                    germanStudents.add(s2);
                }
                System.out.println("German students:\n" + germanStudents);
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
