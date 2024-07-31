package com.nqluong.hotel_management_system.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "RoomNumber", nullable = false, unique = true)
    int roomNumber;

    @Column(name = "Type", nullable = false)
    String type;

    @Column(name = "Price", nullable = false)
    BigDecimal price;

    @Column(name = "Status", nullable = false)
    String status;

    @Column(name = "Description", nullable = false)
    String description;
}
