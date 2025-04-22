import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); 

        // Solicitar datos al usuario
        System.out.print("Ingrese el nombre del medicamento: ");
        String medicamento = entrada.nextLine();

        System.out.print("Ingrese la cantidad: ");
        var cantidad = entrada.nextInt();

        System.out.print("Ingrese el precio unitario: ");
        double precioUnitario = entrada.nextDouble();

        // Simulador de farmacia
        SimuladorFarmacia farmacia = new SimuladorFarmacia(medicamento, cantidad, precioUnitario);

        // Cerrar el escáner
        entrada.close();

        // Llamar métodos
        farmacia.calcularTotal();
        farmacia.mostrarInformacion();
    }
}
