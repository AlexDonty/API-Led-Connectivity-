package com.process.order_management_service.commons.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Series {

    private String idSerie;
    private String titulo;
    private String fechaInicio;
    private String fechaFin;
    private String periodicidad;
    private String cifra;
    private String unidad;
    private String versionada;
}
