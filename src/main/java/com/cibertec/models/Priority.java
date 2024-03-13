package com.cibertec.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Priority")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPriority;

    @Column(name = "name_priority")
    private String name;
}
