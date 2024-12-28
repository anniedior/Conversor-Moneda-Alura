package com.conversormoneda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("- - - - - - - - - - - - - - - - - - - ");
            System.out.println("Bienvenido al Conversor de Moneda\n");
            System.out.println("1. Dolar a Peso Colombiano");
            System.out.println("2. Peso Colombiano a Dolar");
            System.out.println("3. Dolar a Peso Mexicano");
            System.out.println("4. Peso Mexicano a Dolar");
            System.out.println("5. Dolar a Real Brasileño");
            System.out.println("6. Real Brasileño a Dolar");
            System.out.println("7. Salir\n");
            System.out.print("Seleccione la moneda a convertir: \n");
            option = scanner.nextInt();

            if (option >= 1 && option <= 6) {
                System.out.print("Ingrese el valor que desea convertir: \n");
                double amount = scanner.nextDouble();
                TipoCambio converter = new TipoCambio();
                String result = converter.convertirMoneda(option, amount);
                System.out.println(result);
            }
        } while (option != 7);

        scanner.close();
        System.out.println("Gracias por Usar el Conversor de Moneda\n");
    }
}

