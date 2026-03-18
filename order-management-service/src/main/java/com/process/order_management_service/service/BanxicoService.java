package com.process.order_management_service.service;

import com.process.order_management_service.commons.dtos.ResponseBanxico;

public interface BanxicoService {

    ResponseBanxico getSeries(String seriesId);
}
