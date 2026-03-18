package com.process.order_management_service.commons.dtos;

import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class SeriesDto {

    private String idSerie;
    private String titulo;
    private String periodicidad;
}
