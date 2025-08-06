package com.makeshift.makeshift.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// MongoDB dokumentum annotáció
@Document(collection = "daily_schedules")
public class DailySchedule {
    @Id
    private String id;

    private LocalDate date;

    private List<ShiftAssignment> shifts = new ArrayList<>();

    private List<DayOffAssignment> dayOffs = new ArrayList<>(); // szabadságok

    // Üres konstruktor MongoDB-hez
    public DailySchedule() {}

    public DailySchedule(LocalDate date) {
        this.date = date;
    }

    // Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ShiftAssignment> getShifts() {
        return shifts;
    }

    public void setShifts(List<ShiftAssignment> shifts) {
        this.shifts = shifts;
    }

    public List<DayOffAssignment> getDayOffs() {
        return dayOffs;
    }

    public void setDayOffs(List<DayOffAssignment> dayOffs) {
        this.dayOffs = dayOffs;
    }

    // Segédmetódusok
    public void addShift(ShiftAssignment shift) {
        this.shifts.add(shift);
    }

    public void addDayOff(DayOffAssignment dayOff) {
        this.dayOffs.add(dayOff);
    }
}
