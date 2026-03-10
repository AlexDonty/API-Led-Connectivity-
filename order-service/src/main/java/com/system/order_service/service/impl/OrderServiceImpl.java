package com.system.order_service.service.impl;


import com.system.order_service.commons.dtos.OrderDto;
import com.system.order_service.commons.exception.NotFountExceptio;
import com.system.order_service.entity.OrderEntity;
import com.system.order_service.repository.OrderRepository;
import com.system.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<OrderDto> findAll() {
        List<OrderEntity> customerEntities = orderRepository.findAll();
        return modelMapper.map(customerEntities, List.class);
    }

    @Override
    public OrderDto findByUuid(String uuid) throws NotFountExceptio {
        Optional<OrderEntity> customerEntity = orderRepository.findByUuid(uuid);
        return modelMapper.map(customerEntity.orElseThrow(()-> new NotFountExceptio("El cliente no existe")), OrderDto.class);
    }

    @Override
    public OrderDto save(OrderDto customerDto) {
        OrderEntity customerEntity = modelMapper.map(customerDto, OrderEntity.class);
        OrderEntity savedCustomer = orderRepository.save(customerEntity);
        return modelMapper.map(savedCustomer, OrderDto.class);
    }
}
