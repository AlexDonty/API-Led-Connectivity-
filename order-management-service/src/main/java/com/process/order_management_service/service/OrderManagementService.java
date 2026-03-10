package com.process.order_management_service.service;

import com.process.order_management_service.commons.dtos.OrderRequest;
import com.process.order_management_service.commons.dtos.OrderResponse;

import java.util.List;

public interface OrderManagementService {

    List<OrderResponse> findAll();
    OrderResponse findByUuid(String uuid);
    OrderResponse save(OrderRequest orderRequest);

}
