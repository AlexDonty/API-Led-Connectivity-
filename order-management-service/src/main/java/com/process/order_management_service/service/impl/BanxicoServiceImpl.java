package com.process.order_management_service.service.impl;

import com.process.order_management_service.client.CustomerClient;
import com.process.order_management_service.commons.dtos.Bmx;
import com.process.order_management_service.commons.dtos.ResponseBanxico;
import com.process.order_management_service.commons.dtos.ResponseClient;
import com.process.order_management_service.commons.dtos.SeriesDto;
import com.process.order_management_service.service.BanxicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BanxicoServiceImpl implements BanxicoService {

    private final CustomerClient customerClient;

    @Override
    public ResponseBanxico getSeries(String seriesId) {
        Optional<ResponseClient> bmx =  customerClient.getBmx(seriesId);
        ResponseBanxico responseBanxico = new ResponseBanxico();
        if (bmx.isPresent()) {
            List<SeriesDto> series = bmx.get().getBmx().getSeries().stream().map(
                    s->  new SeriesDto(s.getIdSerie(),s.getTitulo(),s.getPeriodicidad())
            ).toList();
            responseBanxico.setSeries(series);
        } else {
            responseBanxico.setSeries(List.of());
        }
        return responseBanxico;
    }
}
