package com.makeshift.makeshift.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// ShiftAssignment belső statikus osztály
public class ShiftAssignment {
    // egy shift bejegyzés egy napra. egy shifthez több ember tartozhat
    private Long shiftTemplateId;
    private List<Long> assignedEmployeeIds = new ArrayList<>();
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public ShiftAssignment() {
    }

    public ShiftAssignment(Long shiftTemplateId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.shiftTemplateId = shiftTemplateId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getShiftTemplateId() {
        return shiftTemplateId;
    }

    public void setShiftTemplateId(Long shiftTemplateId) {
        this.shiftTemplateId = shiftTemplateId;
    }

    public List<Long> getAssignedEmployeeIds() {
        return assignedEmployeeIds;
    }

    public void setAssignedEmployeeIds(List<Long> assignedEmployeeIds) {
        this.assignedEmployeeIds = assignedEmployeeIds;
    }


    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void addEmployee(Long employeeId) {
        if (!assignedEmployeeIds.contains(employeeId)) {
            assignedEmployeeIds.add(employeeId);
        }
    }

    public void removeEmployee(Long employeeId) {
        assignedEmployeeIds.remove(employeeId);
    }

    public void removeAllEmployees() {
        assignedEmployeeIds.clear();
    }

    public void removeEmployees(List<Long> employeeIds) {
        assignedEmployeeIds.removeAll(employeeIds);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShiftAssignment)) return false;
        ShiftAssignment that = (ShiftAssignment) o;
        return Objects.equals(shiftTemplateId, that.shiftTemplateId) &&
                Objects.equals(assignedEmployeeIds, that.assignedEmployeeIds) &&
                Objects.equals(date, that.date) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shiftTemplateId, assignedEmployeeIds, date, startTime, endTime);
    }

    // Segéd: dátum + időből LocalDateTime
    public LocalDateTime getStartDateTime() {
        return LocalDateTime.of(date, startTime);
    }

    public LocalDateTime getEndDateTime() {
        return LocalDateTime.of(date, endTime);
    }
}
