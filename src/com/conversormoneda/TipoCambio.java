package com.conversormoneda;

public class TipoCambio {
    private final ApiCliente apiCliente;

    public TipoCambio() {
        this.apiCliente = new ApiCliente();
    }

    public String convertirMoneda(int option, double amount) {
        String fromCurrency = "";
        String toCurrency = "";
        String toCurrencySymbol = "";

        switch (option) {
            case 1:
                fromCurrency = "USD";
                toCurrency = "COP";
                toCurrencySymbol = "Peso Colombiano";
                break;
            case 2:
                fromCurrency = "COP";
                toCurrency = "USD";
                toCurrencySymbol = "Dólares";
                break;
            case 3:
                fromCurrency = "USD";
                toCurrency = "MXN";
                toCurrencySymbol = "Peso Mexicano";
                break;
            case 4:
                fromCurrency = "MXN";
                toCurrency = "USD";
                toCurrencySymbol = "Dólares";
                break;
            case 5:
                fromCurrency = "USD";
                toCurrency = "BRL";
                toCurrencySymbol = "Real Brasilero";
                break;
            case 6:
                fromCurrency = "BRL";
                toCurrency = "USD";
                toCurrencySymbol = "Dólares";
                break;
        }

        double rate = apiCliente.getTasaCambio(fromCurrency, toCurrency);
        double convertedAmount = amount * rate;
        return String.format("El valor de %.2f %s corresponde a %.2f %s", amount, fromCurrency, convertedAmount, toCurrencySymbol);
    }
}
