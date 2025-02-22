package com.mcr.currenycconverterapiintegration.dto;

public class CurrencyConversionResponse {
    private String from;
    private String to;
    private double amount;
    private double convertedAmount;

    public CurrencyConversionResponse(String from, String to, double amount, double convertedAmount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }
}
