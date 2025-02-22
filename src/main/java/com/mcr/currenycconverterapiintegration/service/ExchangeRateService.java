package com.mcr.currenycconverterapiintegration.service;

import com.mcr.currenycconverterapiintegration.dto.CurrencyConversionResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ExchangeRateService {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";
    private final WebClient webClient = WebClient.create();

    public Mono<Map> getExchangeRates(String base) {
        String url = API_URL + base;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Map.class);
    }

    public Mono<CurrencyConversionResponse> convertCurrency(String from, String to, double amount) {
        String url = API_URL + from;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    Map<String, Object> rates = (Map<String, Object>) response.get("rates");
                    if (!rates.containsKey(to)) {
                        throw new IllegalArgumentException("Invalid currency code: " + to);
                    }
                    double rate = Double.parseDouble(rates.get(to).toString());
                    double convertedAmount = amount * rate;
                    return new CurrencyConversionResponse(from, to, amount, convertedAmount);
                });
    }
}
