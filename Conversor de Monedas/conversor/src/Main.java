
//Funcionalidad general en el Readme.md

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsultarMoneda consulta = new ConsultarMoneda();

        Scanner entrada = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {

            String menu = """
                ------------------------------------------------------------------------
                Bienvenido Al Conversor De Monedas
                \n1) Dolar --> Peso Argentino.
                2) Dolar --> Real Brasileño.
                3) Dolar --> Peso Chileno.
                4) Dolar --> Peso Colombiano.
                5) Salir.
                Elija una opcion a desear:
                ------------------------------------------------------------------------
                """;

            System.out.println(menu);
            int option = entrada.nextInt();
            entrada.nextLine();

            switch (option) {
                case 1:
                    cambio(consulta, entrada, "USD", "ARS");
                    break;
                case 2:
                    cambio(consulta, entrada, "USD", "BRL");
                    break;
                case 3:
                    cambio(consulta, entrada, "USD", "CLP");
                    break;
                case 4:
                    cambio(consulta, entrada, "USD", "COP");
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opcion correcta.");
            }

        }

        System.out.println("Cierre del programa, gracias por su visita :)");
        entrada.close();

    }

    private static void cambio(ConsultarMoneda consulta, Scanner entrada, String monedaOriginal, String monedaCambio) {

        Moneda moneda = consulta.buscarMoneda(monedaOriginal);
        System.out.print("Ingrese la cantidad que desea convertir: ");
        double monto = entrada.nextDouble();
        entrada.nextLine();

        Double valorMoneda = moneda.conversion_rates().get(monedaCambio);

        if (valorMoneda == null) {
            System.out.println("No se encontro el tipo de cambio.");
        } else {
            double convierteValor = monto * valorMoneda;
            System.out.printf("El Valor De %.3f %s en %s es: %.3f%n", monto, monedaOriginal, monedaCambio, convierteValor);
        }
    }
}


