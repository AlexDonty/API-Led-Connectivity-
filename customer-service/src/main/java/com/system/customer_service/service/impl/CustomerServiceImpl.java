package com.system.customer_service.service.impl;

import com.system.customer_service.commons.dtos.CustomerDto;
import com.system.customer_service.commons.exception.NotFountExceptio;
import com.system.customer_service.entity.CustomerEntity;
import com.system.customer_service.repository.CustomerRepository;
import com.system.customer_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<CustomerDto> findAll() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return modelMapper.map(customerEntities, List.class);
    }

    @Override
    public CustomerDto findByUuid(String uuid) throws NotFountExceptio {
        Optional<CustomerEntity> customerEntity = customerRepository.findByUuid(uuid);
        return modelMapper.map(customerEntity.orElseThrow(()-> new NotFountExceptio("El cliente no existe")), CustomerDto.class);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }
}
