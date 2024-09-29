package com.assignment.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Embeddable
public class Event {
    public enum EventType {
        ONBOARD, SALARY, BONUS, EXIT, REIMBURSEMENT
    }

    @Enumerated(EnumType.STRING)  // Store the enum as a string in the database (VARCHAR)
    private EventType eventType;

    private double value;
    private LocalDate eventDate;
    private String notes;

    public Event() {}

    public Event(EventType eventType, double value, LocalDate eventDate, String notes) {
        this.eventType = eventType;
        this.value = value;
        this.eventDate = eventDate;
        this.notes = notes;
    }

    // Getters and setters
    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
