package com.mcr.currenycconverterapiintegration.dto;

public class CurrencyConversionRequest {
    private String from;
    private String to;
    private double amount;

    public CurrencyConversionRequest() {
    }

    public CurrencyConversionRequest(String from, String to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
