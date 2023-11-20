package p5_View;

public class Student{
    private String name;
    private String surname;

    public Student(String name, String surname) {
        this.surname = surname;
        this.name = name;

    }
    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                " , name='" + name + '\'' +

                '}';
    }
}
