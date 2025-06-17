package it.univaq.f4i.iw.examples.data.models;

public class User {
    private int id;
    private String username;
    private String password;
    private Role role; // ADMIN, PURCHASER, TECHNICIAN

    // Konstruktory
    public User() {}
    
    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}