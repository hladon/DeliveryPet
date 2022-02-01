package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "cargo")
@Entity
@NoArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cargoId;
    @Enumerated(EnumType.STRING)
    Status status;
    @Column
    String name;
    @Column
    int weight;
    @Column
    double volume;
    @OneToOne
    City departure;
    @OneToOne
    City destination;
    @Column
    String sender;
    @Column
    String recipient;
}
