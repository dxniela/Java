import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); 
        var saldo = 1000.0;
        int opcion; // Variable para almacenar la opción del usuario

        // Repetir el menú de opciones hasta que el usuario elija salir
        do {
            // Mostrar el menú de opciones
            System.out.println("Bienvenido al Cajero Automático");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            // Leer la opción del usuario
            opcion = entrada.nextInt();

            // Ejecutar la opción seleccionada
            switch (opcion) {
                case 1 -> { 
                    // Consultar saldo
                    System.out.println("Su saldo es: $" + saldo);
                }
                case 2 -> { 
                    // Depositar dinero
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = entrada.nextDouble();

                    if (cantidadDeposito <= 0) {
                        System.out.println("La cantidad a depositar debe ser mayor que cero.");
                        continue; // Volver al inicio del bucle
                    }

                    saldo += cantidadDeposito;
                    System.out.println("Depósito exitoso. Su nuevo saldo es: $" + saldo);                    
                }
                case 3 -> { 
                    // Retirar dinero
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = entrada.nextDouble();

                    if (cantidadRetiro <= 0) {
                        System.out.println("La cantidad a retirar debe ser mayor que cero.");
                        continue; // Volver al inicio del bucle
                    }

                    if (cantidadRetiro <= saldo) {
                        saldo -= cantidadRetiro;
                        System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldo);
                    } else {
                        System.out.println("Fondos insuficientes. Su saldo actual es: $" + saldo);
                    }
                }
                case 4 -> { 
                    // Salir
                    System.out.println("Gracias por usar el Cajero Automático. ¡Hasta luego!");
                }
                default -> {
                    // Opción no válida
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 4.");
                }
            }
        } while (opcion != 4); // Continuar hasta que el usuario elija salir

        entrada.close(); // Cerrar el escáner al final       
    }
}