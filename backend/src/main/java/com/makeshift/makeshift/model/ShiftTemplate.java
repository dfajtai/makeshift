package com.makeshift.makeshift.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;


import java.time.LocalTime;
import java.time.LocalDate;                   // dátum esetén
import java.util.Set;                         // használat esetén
import java.util.HashSet;                     // használat esetén


import lombok.*;

@Entity
@Data  // Generál gettereket, settereket, toString(), equals(), hashCode()
@NoArgsConstructor  // Üres konstruktor
@AllArgsConstructor  // Minden mezőt tartalmazó konstruktor
public class ShiftTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING) // Az enum neve (pl. "WORK_8H") kerül az adatbázisba
    private ShiftType shiftType;

    private LocalTime startTime;
    private LocalTime endTime;

    @Min(0)
    private int requiredEmployees;

    @ManyToMany
    @JoinTable(
            name = "shift_qualification",
            joinColumns = @JoinColumn(
                    name = "shift_template_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "employee_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Employee> qualifiedEmployees = new HashSet<>();

}
