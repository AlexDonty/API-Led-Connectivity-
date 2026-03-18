package com.process.order_management_service.commons.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Bmx {

    private List<Series> series;

    private ErrorDTO error;
}
