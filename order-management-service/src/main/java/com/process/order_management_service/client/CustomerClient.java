package com.process.order_management_service.client;

import com.process.order_management_service.commons.dtos.Bmx;
import com.process.order_management_service.commons.dtos.CustomerDto;
import com.process.order_management_service.commons.dtos.ResponseClient;
import com.process.order_management_service.commons.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerClient {

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    @Value("${banxico.service.url}")
    private String url;

    @Value("${banxico.service.token}")
    private String token;

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


    public Optional<ResponseClient> getBmx(String seriesId) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Bmx-Token", token);

        HttpEntity<ResponseClient> bmxHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<ResponseClient> response = restTemplate.exchange(
                url + "/series/" + seriesId,
                HttpMethod.GET,
                bmxHttpEntity,
                new ParameterizedTypeReference<ResponseClient>() {}
        );


        return Optional.ofNullable(response.getBody());
    }
}
