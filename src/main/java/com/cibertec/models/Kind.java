package com.cibertec.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Kind")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Kind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKind;

    @Column(name = "name_kind")
    private String name;
}