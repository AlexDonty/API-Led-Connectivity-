package com.system.customer_service.controller;

import com.system.customer_service.commons.dtos.CustomerDto;
import com.system.customer_service.commons.exception.NotFountExceptio;
import com.system.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer-service")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable String uuid) throws NotFountExceptio {
        return ResponseEntity.ok(customerService.findByUuid(uuid));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Validated @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.save(customerDto));
    }
}
