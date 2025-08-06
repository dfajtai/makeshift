package com.makeshift.makeshift.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data  // Generál gettereket, settereket, toString(), equals(), hashCode()
@NoArgsConstructor  // Üres konstruktor
@AllArgsConstructor  // Minden mezőt tartalmazó konstruktor
public class DayOffEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private DayOffType type;
}