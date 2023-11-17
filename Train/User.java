package main.java.transport.Train;
public class User {
    private String firstName;
    private String lastName;
    private int userId;

    // Конструктор
    public User(String firstName, String lastName, int userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }

    // Геттери та сеттери
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getUserId() {
        return userId;
    }
}
