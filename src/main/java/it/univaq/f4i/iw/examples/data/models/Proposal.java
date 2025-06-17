package it.univaq.f4i.iw.examples.data.models;

import java.math.BigDecimal;

public class Proposal {
    private int id;
    private PurchaseRequest request;
    private User technician;
    private String productName;
    private String productCode;
    private String manufacturer;
    private BigDecimal price;
    private String url;
    private String notes;
    private String rejectionReason;

    // Konstruktory
    public Proposal() {}

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public PurchaseRequest getRequest() { return request; }
    public void setRequest(PurchaseRequest request) { this.request = request; }
    
    public User getTechnician() { return technician; }
    public void setTechnician(User technician) { this.technician = technician; }
    
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    
    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
    
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
}