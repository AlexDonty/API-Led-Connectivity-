package com.process.order_management_service.controller;

import com.process.order_management_service.commons.dtos.OrderRequest;
import com.process.order_management_service.commons.dtos.OrderResponse;
import com.process.order_management_service.service.OrderManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-management")
@RequiredArgsConstructor
public class OrderManagementController {

    private final OrderManagementService orderManagementService;

    @GetMapping()
    public ResponseEntity<List<OrderResponse>>getAllOrders() {
        return ResponseEntity.ok(orderManagementService.findAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable  String uuid) {
        return ResponseEntity.ok(orderManagementService.findByUuid(uuid));
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Validated @RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderManagementService.save(orderRequest));
    }
}
