package org.bits.deliveryservice.repositories;

import org.bits.deliveryservice.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByDeliveryPersonnelId(Long deliveryPersonnelId);
}