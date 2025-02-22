package com.mcr.currenycconverterapiintegration.test;

import com.mcr.currenycconverterapiintegration.dto.CurrencyConversionResponse;
import com.mcr.currenycconverterapiintegration.service.ExchangeRateService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import java.util.Map;

@ExtendWith(org.springframework.test.context.junit.jupiter.SpringExtension.class)
@SpringBootTest
class ExchangeRateServiceTest {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Test
    void testGetExchangeRates() {
        Mono<Map> response = exchangeRateService.getExchangeRates("USD");

        StepVerifier.create(response)
                .expectNextMatches(map -> map.containsKey("rates"))
                .verifyComplete();
    }

    @Test
    void testConvertCurrency() {
        Mono<CurrencyConversionResponse> responseMono = exchangeRateService.convertCurrency("USD", "EUR", 100);

        StepVerifier.create(responseMono)
                .expectNextMatches(res -> res.getConvertedAmount() > 0)
                .verifyComplete();
    }
}
