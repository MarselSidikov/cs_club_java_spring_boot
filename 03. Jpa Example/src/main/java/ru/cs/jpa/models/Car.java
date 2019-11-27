package ru.cs.jpa.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "owner")
@Entity
@Table(name = "jpa_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

}
