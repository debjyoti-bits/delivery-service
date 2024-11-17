package org.bits.deliveryservice.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "deliveries")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long orderId;

    private Long deliveryPersonnelId;

    private String status;

    private Timestamp pickupTime;

    private Timestamp deliveryTime;

    // Getters and Setters
}
