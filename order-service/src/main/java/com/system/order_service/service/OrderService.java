package com.system.order_service.service;

import com.system.order_service.commons.dtos.OrderDto;
import com.system.order_service.commons.exception.NotFountExceptio;

import java.util.List;

public interface OrderService {

    List<OrderDto> findAll();

    OrderDto findByUuid(String uuid) throws NotFountExceptio;

    OrderDto save(OrderDto customerDto);
}
