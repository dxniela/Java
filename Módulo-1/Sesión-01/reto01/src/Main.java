import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Paciente paciente = new Paciente();
        Scanner input = new Scanner(System.in); 

        System.out.println("Ingresa el nombre del paciente: ");
        paciente.nombre = input.nextLine();  

        System.out.println("Ingresa la edad: ");
        paciente.edad = input.nextInt();
        input.nextLine();

        System.out.println("Ingresa el expediente: ");
        paciente.expediente = input.nextLine();

        paciente.mostrarInformacion();
    }
}