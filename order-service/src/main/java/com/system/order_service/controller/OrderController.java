package com.system.order_service.controller;

import com.system.order_service.commons.dtos.OrderDto;
import com.system.order_service.commons.exception.NotFountExceptio;
import com.system.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping()
    public ResponseEntity<List<OrderDto>> getAllCustomers() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderDto> getCustomer(@PathVariable String uuid) throws NotFountExceptio {
        return ResponseEntity.ok(orderService.findByUuid(uuid));
    }

    @PostMapping
    public ResponseEntity<OrderDto> createCustomer(@Validated @RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(orderService.save(orderDto));
    }
}
