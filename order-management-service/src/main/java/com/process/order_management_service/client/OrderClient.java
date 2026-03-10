package com.process.order_management_service.client;

import com.process.order_management_service.commons.dtos.OrderDto;
import com.process.order_management_service.commons.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderClient {

    @Value("${order.service.url}")
    private String orderServiceUrl;

    private final RestTemplate restTemplate;

    public OrderDto getOrderByUuid(String uuid) {
        ResponseEntity<OrderDto> response = restTemplate.exchange(
                orderServiceUrl + "/order-service/" + uuid,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<OrderDto>() {}
        );

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new BusinessException(response.getStatusCode().toString());
        }

        return response.getBody();
    }

    public List<OrderDto> getAllOrders() {
        ResponseEntity<List<OrderDto>> response = restTemplate.exchange(
                orderServiceUrl + "/order-service",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderDto>>() {}
        );

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new BusinessException(response.getStatusCode().toString());
        }

        return response.getBody();
    }

    public OrderDto createOrder(OrderDto orderDto) {
        String url = orderServiceUrl + "/order-service";
        return restTemplate.postForObject(url, orderDto, OrderDto.class);
    }


}
