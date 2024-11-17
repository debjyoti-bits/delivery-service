package org.bits.deliveryservice.controller;


import org.bits.deliveryservice.model.Delivery;
import org.bits.deliveryservice.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<Delivery>> getAvailableDeliveries(@RequestParam Long deliveryPersonnelId) {
        List<Delivery> deliveries = deliveryService.getAvailableDeliveries(deliveryPersonnelId);
        return ResponseEntity.ok(deliveries);
    }
    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        Delivery createdDelivery = deliveryService.createDelivery(delivery);
        return ResponseEntity.ok(createdDelivery);
    }

    @PostMapping("/{id}/accept")
    public ResponseEntity<Delivery> acceptDelivery(@PathVariable Long id, @RequestBody Map<String, Long> requestBody) {
        Long deliveryPersonnelId = requestBody.get("deliveryPersonnelId");
        Optional<Delivery> delivery = deliveryService.acceptDelivery(id, deliveryPersonnelId);
        return delivery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Delivery> updateDeliveryStatus(@PathVariable Long id, @RequestParam String status) {
        Optional<Delivery> delivery = deliveryService.updateDeliveryStatus(id, status);
        return delivery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}