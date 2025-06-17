package it.univaq.f4i.iw.examples.data.models;

public class Feature {
    private int id;
    private String name;
    private String description;

    // Konstruktory
    public Feature() {}
    
    public Feature(String name) {
        this.name = name;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}