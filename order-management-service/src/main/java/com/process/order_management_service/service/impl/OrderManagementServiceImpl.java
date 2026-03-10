package com.process.order_management_service.service.impl;

import com.process.order_management_service.client.CustomerClient;
import com.process.order_management_service.client.OrderClient;
import com.process.order_management_service.commons.dtos.CustomerDto;
import com.process.order_management_service.commons.dtos.OrderDto;
import com.process.order_management_service.commons.dtos.OrderRequest;
import com.process.order_management_service.commons.dtos.OrderResponse;
import com.process.order_management_service.service.OrderManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManagementServiceImpl  implements OrderManagementService {

    private final OrderClient orderClient;
    private final CustomerClient customerClient;


    @Override
    public List<OrderResponse> findAll() {

        List<OrderDto> orders = orderClient.getAllOrders();
        List<CustomerDto> customers = customerClient.getAllCustomers();

        return orders.stream().map(order -> {
            CustomerDto customer = customers.stream()
                    .filter(c -> c.getUuid().equals(order.getCustomerUuid()))
                    .findFirst()
                    .orElse(null);

            return OrderResponse.builder()
                    .order(order)
                    .customer(customer)
                    .build();
        }).toList();

    }

    @Override
    public OrderResponse findByUuid(String uuid) {
        OrderDto order = orderClient.getOrderByUuid(uuid);
        CustomerDto customer = customerClient.getCustomerByUuid(order.getCustomerUuid());
        return OrderResponse.builder()
                .order(order)
                .customer(customer)
                .build();
    }

    @Override
    public OrderResponse save(OrderRequest orderRequest) {

        CustomerDto customer = customerClient.getCustomerByUuid(orderRequest.getCustomerUuid());
        OrderDto order = orderClient.createOrder(orderRequest);

        return OrderResponse.builder()
                .order(order)
                .customer(customer)
                .build();
    }
}
