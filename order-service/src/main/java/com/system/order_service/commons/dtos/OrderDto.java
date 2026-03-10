package com.system.order_service.commons.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto implements Serializable {

    private String uuid;
    @NotBlank(message = "El uuid del cliente no puede estar vacío")
    private String customerUuid;
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String product;
    @NotBlank(message = "La cantidad no puede estar vacía")
    private Double quantity;
}
