package com.process.order_management_service.commons.dtos;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import jdk.jfr.MemoryAddress;
import lombok.*;
import org.springframework.boot.jackson.JacksonComponent;

import java.util.List;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class ResponseBanxico {

    private List<SeriesDto> series;

    private ErrorDTO error;
}
