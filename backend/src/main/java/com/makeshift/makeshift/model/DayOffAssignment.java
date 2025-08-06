package com.makeshift.makeshift.model;

import java.util.Objects;


public class DayOffAssignment {
    // Egy szabadság bejegyzés egy napra.
    private Long employeeId;
    private DayOffType type;

    public DayOffAssignment() {
    }

    public DayOffAssignment(Long employeeId, DayOffType type) {
        this.employeeId = employeeId;
        this.type = type;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public DayOffType getType() {
        return type;
    }

    public void setType(DayOffType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DayOffAssignment)) return false;
        DayOffAssignment that = (DayOffAssignment) o;
        return Objects.equals(employeeId, that.employeeId) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, type);
    }
}
