package myApp.models;

public class User {
    private int id;
    private String username;
    private String lastName;
    private String email;
    private String phone;
    private boolean isAdmin;
    private boolean isBlocked;

    // Constructors
    public User() {}

    public User(String username, String lastName, String email, String phone, boolean isAdmin) {
        this.username = username;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.isAdmin = isAdmin;
        this.isBlocked = false;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}