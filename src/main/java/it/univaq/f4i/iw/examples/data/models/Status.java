package it.univaq.f4i.iw.examples.data.models;

public enum Status {
    CREATED,        // Vytvořeno
    ASSIGNED,       // Přiřazeno technikovi
    PROPOSED,       // Návrh vytvořen
    ACCEPTED,       // Návrh schválen
    REJECTED,       // Návrh zamítnut
    ORDERED,        // Objednáno
    DELIVERED,      // Dorušeno
    CLOSED_ACCEPTED,// Uzavřeno (přijato)
    CLOSED_DEFECTIVE// Uzavřeno (vadné)
}