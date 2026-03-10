package com.process.order_management_service.commons.dtos;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse implements Serializable {

    private OrderDto order;

    private CustomerDto customer;

}
