package com.system.customer_service.service;

import com.system.customer_service.commons.dtos.CustomerDto;
import com.system.customer_service.commons.exception.NotFountExceptio;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> findAll();

    CustomerDto findByUuid(String uuid) throws NotFountExceptio;

    CustomerDto save(CustomerDto customerDto);
}
