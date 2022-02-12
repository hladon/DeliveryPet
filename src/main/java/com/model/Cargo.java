package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
    @Min(value = 1 , message = "Minimal weight is 1 kg")
    @Column(name = "weight")
    int weightInKg;
    @Min(value = 1 , message = "Minimal volume is 1 litre" )
    @Column(name = "volume")
    int volumeInLitres;
    @NotBlank(message = "Departure city is required")
    @Column
    String departure;
    @NotBlank(message = "Destination city is required")
    @Column
    String destination;
    @NotBlank(message = "Sender is required")
    @Column
    String sender;
    @NotBlank(message = "Recipient is required")
    @Column
    String recipient;
}
