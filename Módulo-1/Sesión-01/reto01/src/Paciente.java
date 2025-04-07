public class Paciente {
    // Atributos
    String nombre;
    int edad;
    String expediente;

    // Métodos
    public void mostrarInformacion() {
        System.out.println("\nPaciente: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Expediente: " + expediente);
    }
}