package com.process.order_management_service.client;

import com.process.order_management_service.commons.dtos.CustomerDto;
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
public class CustomerClient {

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    private final RestTemplate restTemplate;

    public CustomerDto getCustomerByUuid(String uuid) {
        ResponseEntity<CustomerDto> response = restTemplate.exchange(
                customerServiceUrl + "/customer-service/" + uuid,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<CustomerDto>() {}
        );

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new BusinessException(response.getStatusCode().toString());
        }

        return response.getBody();
    }

    public List<CustomerDto> getAllCustomers() {

        ResponseEntity<List<CustomerDto>> response = restTemplate.exchange(
                customerServiceUrl + "/customer-service",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CustomerDto>>() {}
        );

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new BusinessException(response.getStatusCode().toString());
        }

        return response.getBody();
    }
}
