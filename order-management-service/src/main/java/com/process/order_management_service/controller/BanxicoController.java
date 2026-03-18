package com.process.order_management_service.controller;

import com.process.order_management_service.commons.dtos.ResponseBanxico;
import com.process.order_management_service.service.BanxicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banxico/")
public class BanxicoController {

    private final BanxicoService banxicoService;

    @GetMapping("series/{seriesId}")
    public ResponseEntity<ResponseBanxico> getSeries(@PathVariable String seriesId) {
        return ResponseEntity.ok(banxicoService.getSeries(seriesId));
    }

}
