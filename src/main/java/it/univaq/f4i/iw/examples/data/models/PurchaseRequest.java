package it.univaq.f4i.iw.examples.data.models;

import java.time.LocalDateTime;
import java.util.Map;

public class PurchaseRequest {
    private int id;
    private User purchaser;
    private Category category;
    private Map<Feature, String> featureValues; // Hodnoty pro jednotlivé vlastnosti
    private String notes;
    private LocalDateTime creationDate;
    private Status status;

    // Konstruktory
    public PurchaseRequest() {
        this.creationDate = LocalDateTime.now();
        this.status = Status.CREATED;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public User getPurchaser() { return purchaser; }
    public void setPurchaser(User purchaser) { this.purchaser = purchaser; }
    
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    
    public Map<Feature, String> getFeatureValues() { return featureValues; }
    public void setFeatureValues(Map<Feature, String> featureValues) { this.featureValues = featureValues; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }
    
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}