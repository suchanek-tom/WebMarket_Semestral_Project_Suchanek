package it.univaq.f4i.iw.examples.data.models;

import java.util.List;

public class Category {
    private int id;
    private String name;
    private Category parent; // pro stromovou strukturu
    private List<Feature> features;

    // Konstruktory
    public Category() {}
    
    public Category(String name) {
        this.name = name;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Category getParent() { return parent; }
    public void setParent(Category parent) { this.parent = parent; }
    
    public List<Feature> getFeatures() { return features; }
    public void setFeatures(List<Feature> features) { this.features = features; }
}