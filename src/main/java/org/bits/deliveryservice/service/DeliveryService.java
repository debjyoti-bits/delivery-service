package org.bits.deliveryservice.service;


import org.bits.deliveryservice.model.Delivery;
import org.bits.deliveryservice.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public List<Delivery> getAvailableDeliveries(Long deliveryPersonnelId) {
        return deliveryRepository.findByDeliveryPersonnelId(deliveryPersonnelId);
    }

    public Optional<Delivery> acceptDelivery(Long id, Long deliveryPersonnelId) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if (delivery.isPresent()) {
            Delivery d = delivery.get();
            d.setDeliveryPersonnelId(deliveryPersonnelId);
            d.setStatus("ACCEPTED");
            deliveryRepository.save(d);
        }
        return delivery;
    }

    public Optional<Delivery> updateDeliveryStatus(Long id, String status) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if (delivery.isPresent()) {
            Delivery d = delivery.get();
            d.setStatus(status);
            deliveryRepository.save(d);
        }
        return delivery;
    }

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }
}