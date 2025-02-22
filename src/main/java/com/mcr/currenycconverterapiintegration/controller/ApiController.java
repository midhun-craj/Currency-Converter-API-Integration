package com.mcr.currenycconverterapiintegration.controller;

import com.mcr.currenycconverterapiintegration.dto.CurrencyConversionRequest;
import com.mcr.currenycconverterapiintegration.dto.CurrencyConversionResponse;
import com.mcr.currenycconverterapiintegration.service.ExchangeRateService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ExchangeRateService exchangeRateService;

    public ApiController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/rates")
    public Mono<Map> getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
        return exchangeRateService.getExchangeRates(base);
    }

    @PostMapping("/convert")
    public Mono<CurrencyConversionResponse> convertCurrency(@RequestBody CurrencyConversionRequest request) {
        return exchangeRateService.convertCurrency(request.getFrom(), request.getTo(), request.getAmount());
    }
}
