package ru.cs.hibernate.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "owner")
public class Car {
    private Long id;
    private String model;
    private User owner;

}
